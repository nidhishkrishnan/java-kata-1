package org.echocat.kata.java.part1.controller;

import org.echocat.kata.java.part1.domain.ErrorResponse;
import org.echocat.kata.java.part1.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.google.common.collect.Lists.newArrayList;

@RestControllerAdvice
public class DefaultControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllOtherException(final Exception exception) {
        ErrorResponse apiError = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error Occurred" , newArrayList(exception.getLocalizedMessage()));
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ EntityNotFoundException.class })
    public ResponseEntity<Object> handleAllEntityNotFoundException(final Exception exception) {
        ErrorResponse apiError = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Not Found" , newArrayList(exception.getLocalizedMessage()));
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}


