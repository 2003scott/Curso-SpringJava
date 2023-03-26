package com.example.Sesionrestdatajpa.Repository;

import com.example.Sesionrestdatajpa.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {

}
