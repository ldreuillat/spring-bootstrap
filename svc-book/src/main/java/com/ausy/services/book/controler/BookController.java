package com.ausy.services.book.controler;

import com.ausy.services.book.entity.Book;
import com.ausy.services.book.exception.BookNotFoundException;
import com.ausy.services.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/{bookId}")
    public Book findBook(@PathVariable Long bookId) {
        Book book = bookService.findBookById(bookId);

        if (book == null) {
            throw new BookNotFoundException("Book not found : " + bookId);
        }
        return book;
    }

    @PostMapping("create")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("update/{bookId}")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }
}
