package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.domain.Book;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

import static org.echocat.kata.java.part1.utils.DataProcessorUtil.getAllBooks;

@Repository
public class BookRepository {

    public List<Book> getBooks() throws IOException {
        return getAllBooks();
    }
}
