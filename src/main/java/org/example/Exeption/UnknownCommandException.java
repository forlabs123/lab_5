package org.example.Exeption;

public class UnknownCommandException extends RuntimeException{
    public UnknownCommandException() {
        super("некорректная команда");
    }

    public UnknownCommandException(String message) {
        super(message);
    }
}
