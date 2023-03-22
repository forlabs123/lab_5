package org.example.commands;

import org.example.File.Collection;
import org.example.model.Worker;

/**
 * The 'RemoveById' class is command that remove an organization from the collection
 */
public class RemoveById extends Command{
    private Collection collection;

    public RemoveById(Collection collection) {
        this.collection = collection;
    }
    /**
     * Remove an organization from the collection
     */
    @Override
    public void execute(String[] args) {
            if (args.length == 1) {
                int id = Integer.parseInt(args[0]);
                Worker worker = collection.getById(id);
                if (worker != null) {
                    collection.removeById(id);
                }
            } else {
                System.err.println("некорректное количество аргументов");
            }
            if (collection.countElements() == 0){
                System.err.println("коллекция пуста");
        }
    }
}
