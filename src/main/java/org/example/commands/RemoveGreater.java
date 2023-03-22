package org.example.commands;

import org.example.Exeption.EmptyCollectionException;
import org.example.File.Collection;
import org.example.Util.HelperUtil;

/**
 * The 'RemoveGreater' class is a command that remove all elements greater that the person enter
 */
public class RemoveGreater extends Command{
    private Collection collection;
    public RemoveGreater(Collection collection){
        this.collection = collection;
    }

    /**
     * The command that remove all elemunt greater than person enter
     * @param args if args is null throw new exeption
     */
    @Override
    public void execute(String[] args) {
        if (collection.countElements() == 0) throw new EmptyCollectionException();
        /*
        try {
            float salary = Float.parseFloat(args[0]);
            collection.removeGreater(salary);
        } catch (Exception e) {
            System.err.println(" float тип данных");
        }
         */
        float salary = Float.parseFloat(args[0]);
        collection.removeGreater(salary);
    }
}
