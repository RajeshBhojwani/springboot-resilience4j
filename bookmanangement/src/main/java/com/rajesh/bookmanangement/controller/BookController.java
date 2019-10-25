package com.rajesh.bookmanangement.controller;

import java.util.List;

import com.rajesh.bookmanangement.model.Book;
import com.rajesh.bookmanangement.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService  ;

    @PostMapping
    public String addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping
    public List<Book> retrieveBookList(){
        return bookService.retrieveBookList();
    }
}