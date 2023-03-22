package org.example.Exeption;

public class NullArgumentException extends RuntimeException{
    public NullArgumentException() {
        super("нулевой аргумент");
    }

    public NullArgumentException(String message) {
        super(message);
    }
}
