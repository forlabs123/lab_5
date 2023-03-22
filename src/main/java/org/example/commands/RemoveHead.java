package org.example.commands;

import org.example.Exeption.EmptyCollectionException;
import org.example.File.Collection;

/**
 * The 'RemoveHead' class is a command that remove first element
 */
public class RemoveHead extends Command{
    private Collection collection;

    public RemoveHead(Collection collection) {
        this.collection = collection;
    }

    /**
     * The command remove first element or throw exeption
     */
    @Override
    public void execute(String[] args) {
        if (collection.countElements() < 1) throw new EmptyCollectionException();
        collection.showFirst();
        collection.removeFirst();
    }
}
