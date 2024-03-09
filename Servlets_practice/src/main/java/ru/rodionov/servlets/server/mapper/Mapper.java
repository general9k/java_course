package ru.rodionov.servlets.server.mapper;

public interface Mapper<F, T> {
    T mapFrom(F object);
}
