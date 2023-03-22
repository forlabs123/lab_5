package org.example.commands;

import org.example.Exeption.EmptyCollectionException;
import org.example.File.Collection;

/**
 * The 'RemoveFirst' class is a command that remove first element
 */
public class RemoveFirst extends Command{
    private Collection collection;

    public RemoveFirst(Collection collection) {
        this.collection = collection;
    }

    /**
     * Remove first element or throw exception
     */
    @Override
    public void execute(String[] args) {
        if (collection.countElements() == 0) throw new EmptyCollectionException();
        collection.removeFirst();
    }
}
