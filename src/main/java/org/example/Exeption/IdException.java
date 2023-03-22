package org.example.Exeption;

public class IdException extends  RuntimeException{
    public IdException() {
        super("повторяющийся id элементов");
    }

    public IdException(String message) {
        super(message);
    }
}
