package com.bash.jacksonjson.controller;

import com.bash.jacksonjson.domain.Book;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class BookController {

    @GetMapping(path = "/books")
    public Book getBooks() {
        return Book.builder()
                .isbn("123456789")
                .title("Title")
                .author("Author")
                .yearPublished("1995").build();
    }

    @PostMapping(path = "/books")
    public Book addBook(@RequestBody final Book book) {
        log.info("Adding book: " + book.toString());
        return book;
    }
}
