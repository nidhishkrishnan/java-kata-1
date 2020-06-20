package org.echocat.kata.java.part1.controller;

import lombok.RequiredArgsConstructor;
import org.echocat.kata.java.part1.domain.Magazine;
import org.echocat.kata.java.part1.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/books")
public class BookController {

    private final BookService bookService;

    @GetMapping("/")
    public List<? extends Magazine> books() {
        return bookService.getBooks();
    }
}
