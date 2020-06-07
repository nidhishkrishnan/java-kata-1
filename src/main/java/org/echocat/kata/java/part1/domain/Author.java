package org.echocat.kata.java.part1.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Author {

    private String email;

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;
}
