package com.example.Sesionrestdatajpa.RestController;

import com.example.Sesionrestdatajpa.Entity.Book;
import com.example.Sesionrestdatajpa.Repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);

    //atributos
    @Autowired
    private BookRepository bookRepository;

    // crud sobre la entidad book

    //Busacar todos los libros

    /**
     * http://localhost:8090/api/books
     * @return
     */
    @GetMapping("/api/books")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    // Buscar todos los libros por id
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        // Opcion 1
        if (bookOpt.isPresent())
           return ResponseEntity.ok(bookOpt.get());
        else
            return ResponseEntity.notFound().build();
        // Opcion 2
        //return bookOpt.orElse(null);
    }

    // crear un nuevo libro en base de datos
    @PostMapping("/api/books")
    // rquestheader httpheader no sisve para saver quien nos esta mandando la peticion
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        // guardar el libro recibido por parametro en la base ded datos
        if (book.getId() != null){//quiere decir que existe el id y por tanto no es una creacion
            log.warn("trying to create a book with id");
            System.out.println("trying to create a book with id");
            return  ResponseEntity.badRequest().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }

    /**
     * Actualizar un libro existente en base de datos
     */
    @PutMapping("/api/books")
    public ResponseEntity<Object> update(@RequestBody Book book){
        if (book.getId() == null){// si no tiene id decirque si es una creacion
            log.warn("Trying to update a nom existent book");
            return  ResponseEntity.badRequest().build();
        }
        if (!bookRepository.existsById(book.getId())){
            log.warn("Trying to update a nom existent book");
            return  ResponseEntity.notFound().build();
        }
        //proceso de actualizacion
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result); //el libro devuelto tiene una clase primaria
    }

    /**
     * eliminar un libro
     */
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book>delete(@PathVariable Long id){
        if (!bookRepository.existsById(id)){
            log.warn("Trying to delete a nom existent book");
            return  ResponseEntity.notFound().build();
        }

        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteAll(){
        log.debug("REST request for delete all books");
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
