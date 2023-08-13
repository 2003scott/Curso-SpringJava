package com.pe.SwaggerEjercicio;

import com.pe.SwaggerEjercicio.Entity.Laptop;
import com.pe.SwaggerEjercicio.Repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SwaggerEjercicioApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SwaggerEjercicioApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		// Creamos un Crud

		// Crear Laptop

		Laptop laptop1 = new Laptop(null,"ThinkBook","Lenovo",1200.00,true);
		Laptop laptop2 = new Laptop(null,"Zephyrus","Asus",2500.00,true);

		// Guardar libro creados

		repository.save(laptop1);
		repository.save(laptop2);

		// Por que hacemos esto?
		// Lo hacemos para ahorrarnos el tiempo y dar por predeterminado las laptops y una ves
		// que se termine el programa se solo quedene este dotos en memoria
		// y los demas datos se eliminaran
	}

}
