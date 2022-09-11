package com.bridgelabz.bookstoreapplication.book.repository;

import com.bridgelabz.bookstoreapplication.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    Book deleteById(int id);
}
