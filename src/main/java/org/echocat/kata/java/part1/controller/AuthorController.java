package org.echocat.kata.java.part1.controller;

import lombok.RequiredArgsConstructor;
import org.echocat.kata.java.part1.domain.Author;
import org.echocat.kata.java.part1.service.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/authors")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/")
    public List<Author> authors() throws IOException {
        return authorService.getAuthors();
    }
}
