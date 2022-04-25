package com.ausy.services.book.repository;

import com.ausy.services.book.entity.Book;

import java.util.HashMap;
import java.util.Map;

public class BookStorage {
    private static BookStorage instance = new BookStorage();
    private Map<Long, Book> mapBook;

    private BookStorage() {
        this.mapBook = new HashMap<>();

        this.mapBook.put(1L, new Book(1L, "JK Rowling", "Harry Potter à l'école des sorciers"));
    }

    public static BookStorage getInstance() {
        return instance;
    }

    public Map<Long, Book> getMapBook() {
        return this.mapBook;
    }
}
