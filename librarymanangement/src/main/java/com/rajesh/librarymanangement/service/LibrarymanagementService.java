package com.rajesh.librarymanangement.service;

import java.util.List;

import com.rajesh.librarymanangement.model.Book;

public interface LibrarymanagementService {

    String addBook(Book book);
    String addBookwithRateLimit(Book book);
    List<Book> getBookList();
    List<Book> getBookListBulkhead();
}