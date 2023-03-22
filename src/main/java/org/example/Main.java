package org.example;

import org.example.File.Collection;
import org.example.File.FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        //InputStream is = classloader.getResourceAsStream(args[0]);
        //File file = (new File(Main.class.getClassLoader().getResource(args[0]).toURI()));
       // System.out.println(file.getParentFile().getAbsolutePath());
        //System.out.println(file.getAbsolutePath());
        if (args.length == 0){
            System.err.println("передайте название файла");
            System.exit(1);
        }
        String fileName = args[0];
        Collection collection = null;
        try {
            FileManager fileManager = new FileManager(fileName);
            collection = new Collection(fileManager);
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(2);
        }


        Scanner scanner = new Scanner(in);
        Factory factory = new Factory(collection);
        boolean workingProsess = true;
        while (workingProsess) {
            try {
                if (scanner.hasNextLine()){
                    String s = scanner.nextLine();
                    //CommandResult command = factory.create(s, collection);
                    CommandResult command = factory.create(s);
                    command.getCommand().execute(command.getArgs());
                    workingProsess = command.getCommand().getFlag();
                }
                else {
                    workingProsess = false;
                    System.err.println("не вводите ctrl + D    :-(   ");
                }
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
}
