package com.example.Sesionrestdatajpa;

import com.example.Sesionrestdatajpa.Entity.Book;
import com.example.Sesionrestdatajpa.Repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class SesionRestDatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SesionRestDatajpaApplication.class, args);
		BookRepository repository = context.getBean(BookRepository.class);

		// CRUD
		// crear libro

			Book book1 = new Book(null,"Homo Deus", "Tuval Noah",450,29.99, LocalDate.of(2018,12,1), true);
			Book book2 = new Book(null,"La Ventajas de se invicible", "UN brother",450,49.99, LocalDate.of(2020,10,5), true);

		// alamacenar un libro

			repository.save(book1);
			repository.save(book2);

		//recuperar todos los

			System.out.println("Numero de libro en bd" + repository.findAll().size());

		// borrar un libro

			//repository.deleteById(1L);
			//System.out.println("Numero de libro en bd" + repository.findAll().size());
	}

}
