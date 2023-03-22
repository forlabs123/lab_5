package org.example.commands;

import org.example.Exeption.WrongAmountOfElementsException;
import org.example.File.Collection;
import org.example.model.Worker;

import java.util.ArrayList;
import java.util.Collections;

/**
 *  The 'PrintDescending' class is a command that prints the list of workers in the reverse order.
 */
public class PrintDescending extends Command{
    private Collection collection;

    public PrintDescending(Collection collection) {
        this.collection = collection;
    }

    /**
     *Print the list of organizations in reverse order
     */
    @Override
    public void execute(String[] args) {
        if (!(args.length <1)) throw new WrongAmountOfElementsException();
        ArrayList<Worker> workerArrayList = new ArrayList<>(collection.getWorkers());
        workerArrayList.sort(Collections.reverseOrder());
        for(Worker worker : workerArrayList){
            System.out.println(worker.toString());
        }
    }
}
