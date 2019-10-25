package com.rajesh.librarymanangement.controller;

import java.util.List;

import com.rajesh.librarymanangement.model.Book;
import com.rajesh.librarymanangement.service.LibrarymanagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class LibrarymanagementController {

    @Autowired
    private LibrarymanagementService librarymanagementService;
    @PostMapping
    public String addBook(@RequestBody Book book){
        return librarymanagementService.addBook(book);
    }

    @PostMapping ("/ratelimit")
    public String addBookwithRateLimit(@RequestBody Book book){
        return librarymanagementService.addBookwithRateLimit(book);
    }

    @GetMapping
    public List<Book> getSellersList() {
        return librarymanagementService.getBookList();
    }
}