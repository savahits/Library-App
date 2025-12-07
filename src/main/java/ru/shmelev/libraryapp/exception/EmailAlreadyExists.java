package ru.shmelev.libraryapp.exception;

public class EmailAlreadyExists extends RuntimeException {
    public EmailAlreadyExists(String email) {
        super(String.format("Читатель с email '%s' уже существует", email));
    }
}
