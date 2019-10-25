package com.rajesh.bookmanangement.service;

import java.util.ArrayList;
import java.util.List;

import com.rajesh.bookmanangement.model.Book;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    List<Book> bookList = new ArrayList<>();

    @Override
    public String addBook(Book book) {
        String message  =   "";
        boolean status  =   bookList.add(book);
        if(status){
            message=    "Book is added successfully to the library.";
        }
        else{
             message=    "Book could not be added in library due to some technical issue. Please try later!";
        }
        return message;
    }

    @Override
    public List<Book> retrieveBookList() {
        return bookList;
    }
}