package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.domain.Author;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

import static org.echocat.kata.java.part1.utils.DataProcessorUtil.getAllAuthors;

@Repository
public class AuthorRepository {

    public List<Author> getAuthors() throws IOException {
        return getAllAuthors();
    }
}
