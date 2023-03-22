package org.example.commands;

import org.example.Exeption.EmptyCollectionException;
import org.example.File.Collection;
import org.example.model.Worker;
/**
 * The `ShowCommand` class is a command that prints all the elements of the collection in string
 * representation
 */
public class Show extends Command{
    private Collection collection;
    public Show(Collection collection) {
        this.collection=collection;
    }

    /**
     * * Prints all the organizations in the collection
     * @param args the arguments passed to the command.
     */
    @Override
    public void execute(String[] args) {
        if (collection.countElements() == 0) throw new EmptyCollectionException();
        for (Worker worker : collection.getWorkers()){
            System.out.println(worker);
        }
    }
}
