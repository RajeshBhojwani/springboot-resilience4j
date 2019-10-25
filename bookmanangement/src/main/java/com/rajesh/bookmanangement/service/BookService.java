package com.rajesh.bookmanangement.service;

import java.util.List;

import com.rajesh.bookmanangement.model.Book;

public interface BookService {


    public String addBook(Book book);

    public List<Book> retrieveBookList();
}
