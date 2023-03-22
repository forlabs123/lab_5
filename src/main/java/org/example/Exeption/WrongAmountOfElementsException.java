package org.example.Exeption;
/**
 * This class is used to throw an exception when the number of elements in a list is not equal to the
 * number of elements in the array
 */
public class WrongAmountOfElementsException extends RuntimeException{
    public WrongAmountOfElementsException() {
        super("неверное количество аргументов команды");
    }

    public WrongAmountOfElementsException(String message) {
        super(message);
    }
}
