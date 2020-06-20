package org.echocat.kata.java.part1.service;

import lombok.RequiredArgsConstructor;
import org.echocat.kata.java.part1.domain.Magazine;
import org.echocat.kata.java.part1.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<? extends Magazine> getBooks() {
        return bookRepository.getBooks();
    }
}
