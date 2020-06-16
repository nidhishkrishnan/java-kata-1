package org.echocat.kata.java.part1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class Magazine {

    private String title;

    private String isbn;

    private List<String> authors;

    @JsonFormat(pattern="dd.MM.yyyy")
    private Date publishedAt;
}
