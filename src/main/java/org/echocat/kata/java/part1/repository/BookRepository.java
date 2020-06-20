package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.domain.Book;
import org.echocat.kata.java.part1.domain.Magazine;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.echocat.kata.java.part1.utils.DataProcessorUtil.readData;

@Repository
public class BookRepository {

    public List<? extends Magazine> getBooks() {
        List<Book> books = readData(Book.class, "books.csv");
        List<Magazine> magazines = readData(Magazine.class, "magazines.csv");
        return Stream.of(magazines, books)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }
}
