package org.echocat.kata.java.part1.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Publication {

    private String title;

    private String isbn;

    private List<String> authors;

    @JsonProperty("isMagazine")
    private boolean isMagazine = false;
}
