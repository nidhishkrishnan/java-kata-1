package org.echocat.kata.java.part1.service;

import lombok.RequiredArgsConstructor;
import org.echocat.kata.java.part1.domain.Book;
import org.echocat.kata.java.part1.exception.EntityNotFoundException;
import org.echocat.kata.java.part1.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    public Book findBookByIsbn(final String isbn) {
        return getBooks().stream().filter(book -> book.getIsbn().equals(isbn)).findAny().orElseThrow(()-> new EntityNotFoundException(String.format("Book not found for the given isbn %s", isbn)));
    }

    public List<Book> findBooksByEmail(String emailId) {
        return getBooks().stream().filter(book -> book.getAuthors().contains(emailId)).collect(Collectors.toList());
    }

    public List<Book> sortByTitle() {
        return getBooks().stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
    }
}
