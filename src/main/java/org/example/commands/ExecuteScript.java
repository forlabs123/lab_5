package org.example.commands;

import org.example.CommandResult;
import org.example.Factory;
import org.example.File.Collection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * The 'execute_script' command.
 * Execute the script from the file.
 */
public class ExecuteScript extends Command{
    private Collection collection;
    private Factory factory;
    //private static ArrayList<String> filenames;
    private static ArrayDeque<String> filenames;
    public ExecuteScript(Collection collection, Factory factory) {
        this.factory = factory;
        this.collection = collection;
        filenames = new ArrayDeque<>();
    }
    /**
     * Execute a script
     */
    @Override
    public void execute(String[] args) {
       String filename = args[0];
       if (filenames.contains(filename)){
           filenames.clear();
           throw new IllegalArgumentException("бесконечный вызов файлов");
       }
       if (!new File(filename).exists()){
           filenames.clear();
           throw new IllegalArgumentException("нет такого файла");
       }
       if (! new File(filename).isFile()){
           filenames.clear();
           throw new IllegalArgumentException("это директория, а не файл");
       }
       filenames.add(filename);
       ArrayList<String> arrayListLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line=reader.readLine())!=null){
                if (!line.trim().isEmpty()) {
                    arrayListLines.add(line);
                }
            }
        } catch (Exception e) {
            filenames.clear();
            throw new RuntimeException(e);
        }
        try {
            for (int i = 0; i<arrayListLines.size(); i++){
                CommandResult command = factory.create(arrayListLines.get(i));
                boolean flag = true;
                if (command.getCommand() instanceof Add && command.getArgs().length == 0){
                    if ((flag && Factory.checkCommand(arrayListLines.get(i+1)))) throw new RuntimeException("в add не хватает данных");
                    flag = false;
                    if (i < arrayListLines.size()-1 && !Factory.checkCommand(arrayListLines.get(i+1))){
                        flag = false;
                        String addWorker = "";
                        for (int j = 0; j<13; j++){
                            i++;
                            addWorker += arrayListLines.get(i) + ";";
                        }
                        String[] strings = {addWorker};
                        command.setArgs(strings);
                    }
                }
                command.getCommand().execute(command.getArgs());
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        filenames.pop();
    }
}
