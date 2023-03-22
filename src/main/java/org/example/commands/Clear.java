package org.example.commands;

import org.example.File.Collection;

/**
 * Clear the collection
 */
public class Clear extends Command{
    private Collection collection;

    public Clear(Collection collection) {
        this.collection = collection;
    }
    /**
     * Clear the collection
     */
    @Override
    public void execute(String[] args) {
        collection.clear();
    }
}
