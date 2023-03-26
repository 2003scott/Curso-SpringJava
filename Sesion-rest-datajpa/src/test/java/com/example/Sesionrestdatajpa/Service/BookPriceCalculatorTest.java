package com.example.Sesionrestdatajpa.Service;

import com.example.Sesionrestdatajpa.Entity.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void calcularPrice() {
        //configuracion de la prueba
        Book book = new Book(1L, "El señor de los anillos", "Author",1000,49.99, LocalDate.now(),true);
        BookPriceCalculator calculator = new BookPriceCalculator();

        //se ejecuta el comprotacimiento a testear
        double price  = calculator.calcularPrice(book);
        System.out.println(price);

        //comprobacion aserciones
        assertTrue(price>0);
        assertEquals(57.980000000000004,price);
    }
}