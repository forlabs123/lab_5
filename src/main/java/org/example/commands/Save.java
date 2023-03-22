package org.example.commands;

import org.example.File.Collection;

/**
 * Write the collection to the file
 */
public class Save extends Command{
    private Collection collection;

    public Save(Collection collection) {
        this.collection = collection;
    }
    /**
     * Write the collection to the file
     */
    @Override
    public void execute(String[] args){
        collection.save();
        /*
            try {
                if (args.length > 0) throw new WrongAmountOfElementsException();
                collection.saveCollection();
            } catch (WrongAmountOfElementsException exception) {
                ResponseOutputer.appendLn("Usage: '" + getName() + " " + getUsage() + "'");
            }

         */
    }
}
