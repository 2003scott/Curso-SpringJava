package com.example.Sesionrestdatajpa.Service;

import com.example.Sesionrestdatajpa.Entity.Book;

public class BookPriceCalculator {

    public double calcularPrice(Book book){
        double price = book.getPrice();

        if (book.getPages()>300){
            price +=5;
        }
        price +=2.99;
        return price;

    }
}
