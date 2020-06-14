package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.echocat.kata.java.part1.utils.DataProcessorUtil.readData;

@Repository
public class BookRepository {

    public List<Book> getBooks() {
        return readData(Book.class, "books.csv");
    }
}
