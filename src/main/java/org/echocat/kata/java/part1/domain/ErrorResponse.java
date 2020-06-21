package org.echocat.kata.java.part1.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ErrorResponse {

    private final int status;

    private final String message;

    private final List<?> errors;
}
