package org.example.commands;

import org.example.Exeption.WrongTypeException;
import org.example.File.Collection;
import org.example.Util.HelperUtil;

/**
 * The 'RemoveAllBySalary' class is a command that
 */
public class RemoveAllBySalary extends Command{
    private Collection collection;

    public RemoveAllBySalary(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 1){
            if (!HelperUtil.checkFloat(args[0])) throw new WrongTypeException();
            float salary = Float.parseFloat(args[0]);
            collection.removeAllBySalary(salary);
        } else {
            System.out.println("Некорректное количество аргументов");
        }
    }
}
