package org.echocat.kata.java.part1.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Magazine {

    private String title;

    private String isbn;

    private List<String> authors;

    private String description;
}
