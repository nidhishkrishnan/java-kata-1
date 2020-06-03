package org.echocat.kata.java.part1.controller;

import org.echocat.kata.java.part1.domain.Author;
import org.echocat.kata.java.part1.service.AuthorService;
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

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@DisplayName("Testing Author Controller")
public class AuthorControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AuthorService authorService;

    @InjectMocks
    private AuthorController authorController;


    @BeforeEach
    void setMockOutput()
    {
        mockMvc = MockMvcBuilders.standaloneSetup(authorController).build();
    }

    @Test
    @DisplayName("Test for getting Author details ('v1/authors')")
    public void getAuthorsTest() throws Exception
    {
        when(authorService.getAuthors()).thenReturn(buildAuthors());
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/authors")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", is("someFirstName")))
                .andExpect(jsonPath("$[0].lastName", is("someLastName")));
    }

    private List<Author> buildAuthors() {
        Author author = new Author();
        author.setEmail("author@email.com");
        author.setFirstName("someFirstName");
        author.setLastName("someLastName");
        return Collections.singletonList(author);
    }

}
