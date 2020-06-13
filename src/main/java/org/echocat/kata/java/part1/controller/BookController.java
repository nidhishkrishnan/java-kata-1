package org.echocat.kata.java.part1.controller;

import lombok.RequiredArgsConstructor;
import org.echocat.kata.java.part1.domain.Book;
import org.echocat.kata.java.part1.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/books")
public class BookController {

    private final BookService bookService;

    @GetMapping("/")
    public List<Book> books() throws IOException {
        return bookService.getBooks();
    }
}
