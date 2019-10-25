package com.rajesh.librarymanangement.service;

import java.util.ArrayList;
import java.util.List;

import com.rajesh.librarymanangement.model.Book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class LibrarymanagementServiceImpl implements LibrarymanagementService {
    Logger logger = LoggerFactory.getLogger(LibrarymanagementServiceImpl.class);
    private RestTemplate restTemplate;
    public LibrarymanagementServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @CircuitBreaker(name = "add", fallbackMethod = "fallbackForaddBook")
    public String addBook(Book book){
        String response = restTemplate.postForObject("/books", book, String.class);
        logger.error("Inside addbook, cause ");
        return response;
    }

    @Override
    @RateLimiter(name = "add", fallbackMethod = "fallbackForRatelimitBook")
    public String addBookwithRateLimit(Book book){
        String response = restTemplate.postForObject("/books", book, String.class);
        logger.error("Inside addbook, cause ");
        return response;
    }

    @Override
    @Retry(name = "get", fallbackMethod = "fallbackRetry")
    public List<Book> getBookList(){
        return restTemplate.getForObject("/books", List.class);
    }

    public String fallbackForaddBook(Book book, Throwable t) {
        logger.error("Inside circuit breaker fallbackForaddBook, cause - {}", t.toString());
        return "Inside circuit breaker fallback method. Some error occurred while calling service for adding book";
    }

    public String fallbackForRatelimitBook(Book book, Throwable t) {
        logger.error("Inside fallbackForRatelimitBook, cause - {}", t.toString());
        return "Inside fallbackForRatelimitBook method. Some error occurred while calling service for adding book";
    }

   public List<Book> fallbackRetry(Throwable t) {
        logger.error("Inside fallbackRetry, cause - {}", t.toString());
        Book book   =   new Book();
        book.setAuthor("Default");
        book.setStatus("Default");
        book.setTitle("Default");
        List<Book> list =   new ArrayList<Book>();
        list.add(book);
        return list;
    }
      
}