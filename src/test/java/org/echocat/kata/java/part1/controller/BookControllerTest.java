package org.echocat.kata.java.part1.controller;

import org.echocat.kata.java.part1.domain.Book;
import org.echocat.kata.java.part1.domain.Magazine;
import org.echocat.kata.java.part1.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.format.DateTimeFormatter.ofPattern;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@DisplayName("Testing Book Controller")
public class BookControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;


    @BeforeEach
    void setMockOutput()
    {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    @DisplayName("Test for getting Books details ('v1/books/')")
    public void getBooksTest() throws Exception
    {
        when(bookService.getBooks()).thenReturn(buildBooks());
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/books/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].description", is("someDesc")))
                .andExpect(jsonPath("$[1].publishedAt", is(LocalDate.now().format(ofPattern("dd.MM.yyyy")))));
    }

    private List<Book> buildBooks() {
        Book book = new Book();
        book.setAuthors(Collections.singletonList("someAuthor@email.com"));
        book.setDescription("someDesc");
        book.setIsbn("someIsbn");
        book.setTitle("someTitle");
        List<Book> books = new ArrayList();
        books.add(book);

        Magazine magazine = new Magazine();
        magazine.setAuthors(Collections.singletonList("someAuthor@email.com"));
        magazine.setPublishedAt(new Date());;
        magazine.setIsbn("someIsbn");
        magazine.setTitle("someTitle");
        List<Magazine> magazines = new ArrayList();
        magazines.add(magazine);

        return Stream.of(books, magazines)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }

}
