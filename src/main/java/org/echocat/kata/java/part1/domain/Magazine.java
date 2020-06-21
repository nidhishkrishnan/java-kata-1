package org.echocat.kata.java.part1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Magazine extends Book {

    @JsonFormat(pattern="dd.MM.yyyy")
    private Date publishedAt;

    public boolean isMagazine() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Magazine)) return false;
        Magazine magazine = (Magazine) o;
        return getIsbn() != null ? getIsbn().equals(magazine.getIsbn()) : magazine.getIsbn() == null;
    }

    @Override
    public int hashCode() {
        return getIsbn() != null ? getIsbn().hashCode() : 0;
    }
}
