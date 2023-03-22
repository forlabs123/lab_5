package org.example.Exeption;

public class WrongSizeOfElementException extends RuntimeException{
    public WrongSizeOfElementException() {
        super ("неверный размер аргумента");
    }

    public WrongSizeOfElementException(String message) {
        super(message);
    }
}
