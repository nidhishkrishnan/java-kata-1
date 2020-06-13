package org.echocat.kata.java.part1.service;

import lombok.RequiredArgsConstructor;
import org.echocat.kata.java.part1.domain.Book;
import org.echocat.kata.java.part1.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getBooks() throws IOException {
        return bookRepository.getBooks();
    }
}
