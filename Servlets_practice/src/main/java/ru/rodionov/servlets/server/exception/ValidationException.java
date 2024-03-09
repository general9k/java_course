package ru.rodionov.servlets.server.exception;

import lombok.Getter;
import ru.rodionov.servlets.server.validator.Error;

import java.util.List;

@Getter
public class ValidationException extends RuntimeException {
    private final List<Error> errors;


    public ValidationException(List<Error> errors) {
        this.errors = errors;
    }
}
