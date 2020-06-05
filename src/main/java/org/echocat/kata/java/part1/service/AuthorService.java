package org.echocat.kata.java.part1.service;

import lombok.RequiredArgsConstructor;
import org.echocat.kata.java.part1.domain.Author;
import org.echocat.kata.java.part1.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> getAuthors() throws IOException {
        return authorRepository.getAuthors();
    }
}
