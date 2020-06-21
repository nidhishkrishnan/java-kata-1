package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.domain.Author;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.echocat.kata.java.part1.utils.DataProcessorUtil.readData;

@Repository
public class AuthorRepository {

    @Cacheable("authors")
    public List<Author> getAuthors() {
        return readData(Author.class, "author.csv");
    }
}
