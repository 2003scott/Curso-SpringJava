package com.pe.SwaggerEjercicio.RestController;

import com.pe.SwaggerEjercicio.Entity.Laptop;
import com.pe.SwaggerEjercicio.Repository.LaptopRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class LaptopRestController {
    /**
     * manera de ver la documentacion en swagger
     * http://localhost:8081/swagger-ui/index.html#/
     */

    //logs - logger
    private final Logger log = LoggerFactory.getLogger(LaptopRestController.class);


    // Atributos
    @Autowired // Injector
    private LaptopRepository laptopRepository;

    /**
     * http://localhost:8081/api/laptops
     * @return
     */
    @Operation(summary = "Listar todas las laptos")
    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

    /**
     * http://localhost:8081/api/laptops/1
     * @param id
     * @return
     */

    @Operation(summary = "Listar laptos por id")
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findById(@PathVariable Long id){
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        if (laptopOpt.isPresent())
            return ResponseEntity.ok(laptopOpt.get());
        else
            return ResponseEntity.notFound().build();
    }

    @Operation(summary = "crear nueva lapto")
    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody  Laptop laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        if (laptop.getId() != null){
            log.warn("tratando de crear una laptop con id");
            return  ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "actualizar una laptop")
    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody  Laptop laptop){
        if (laptop.getId() != null){
            log.warn("Intentando actualizar una laptop no existente");
            return  ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())){
            log.warn("Intentando actualizar una laptop no existente");
            return ResponseEntity.notFound().build();
        }

        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Eliminar laptop por id")
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if (!laptopRepository.existsById(id)){
            log.warn("Intentando eliminar una laptop no existente");
            return  ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return  ResponseEntity.notFound().build();
    }

    @Operation(summary = "Eliminar todas las laptops")
    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        log.debug("Solicitud REST para eliminar todos los libros");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
