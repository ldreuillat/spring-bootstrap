package com.ausy.services.book.repository;

import com.ausy.services.book.entity.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import static java.util.stream.Collectors.toList;

@Component
public class BookRepository {
    public List<Book> findAll() {
        BookStorage bookStorage = BookStorage.getInstance();

        return bookStorage.getMapBook().values().stream().collect(toList());
    }

    public Book findById(Long id) {
        BookStorage bookStorage = BookStorage.getInstance();

        return bookStorage.getMapBook().get(id);
    }

    public Book create(Book book) {
        BookStorage bookStorage = BookStorage.getInstance();
        bookStorage.getMapBook().put(book.getId(), book);

        return bookStorage.getMapBook().get(book.getId());
    }

    public void delete(Book book) {
        BookStorage bookStorage = BookStorage.getInstance();

        bookStorage.getMapBook().remove(book.getId());
    }

    public Book update(Book book) {
        BookStorage bookStorage = BookStorage.getInstance();
        bookStorage.getMapBook().put(book.getId(), book);

        return bookStorage.getMapBook().get(book.getId());
    }
}
