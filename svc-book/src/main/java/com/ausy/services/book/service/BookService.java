package com.ausy.services.book.service;

import com.ausy.services.book.entity.Book;
import com.ausy.services.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(Long bookId) {
        return bookRepository.findById(bookId);
    }

    public Book createBook(Book book) {
        return bookRepository.create(book);
    }

    public void deleteBook(Long bookId) {
        Book existingBook = bookRepository.findById(bookId);

        bookRepository.delete(existingBook);
    }

    public Book updateBook(Book book) {
        return bookRepository.update(book);
    }
}
