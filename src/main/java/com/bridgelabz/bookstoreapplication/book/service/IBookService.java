package com.bridgelabz.bookstoreapplication.book.service;

import com.bridgelabz.bookstoreapplication.book.dto.BookDTO;
import com.bridgelabz.bookstoreapplication.user.dto.ResponseDTO;

public interface IBookService {

    //getAll
    ResponseDTO getAllBooks();
    //get
    ResponseDTO getBooksById(Integer id);
    //post
    ResponseDTO creatNewBook(BookDTO bookDTO);
    //update
    ResponseDTO updateBook(int id, BookDTO bookDTO);
    //delete
    ResponseDTO deleteBookById(int id);
}
