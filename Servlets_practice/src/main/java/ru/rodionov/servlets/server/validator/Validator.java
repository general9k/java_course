package ru.rodionov.servlets.server.validator;

public interface Validator<T> {

    ValidationResult isValid(T object);
}
