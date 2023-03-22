package org.example.Exeption;

public class EmptyCollectionException extends RuntimeException{
    public EmptyCollectionException() {
        super("коллекция пуста ");
    }

    public EmptyCollectionException(String message) {
        super(message);
    }
}
