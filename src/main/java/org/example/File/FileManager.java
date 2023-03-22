package org.example.File;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.DataAdapter.DateAdapter;
import org.example.Exeption.FileException;
import org.example.Exeption.IdException;
import org.example.Exeption.NullArgumentException;
import org.example.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

public class FileManager {
    private String fileName;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    public ArrayDeque<Worker> readFile() throws FileNotFoundException {
        ArrayDeque<Worker> workers = new ArrayDeque<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                if (!bufferedReader.ready()){
            } else {
                while ((line = bufferedReader.readLine()) != null) {
                 stringBuilder.append(line);
                }
                Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new DateAdapter()).create();
                var collectionType = new TypeToken<ArrayDeque<Worker>>() {
                }.getType();
                workers = gson.fromJson(stringBuilder.toString(), collectionType);}
            }  catch (Exception e) {
            throw new RuntimeException(e);
            }
        if (!checkWorkeId(workers)){
            workers.clear();
            //System.err.println("одинаковые id элементов");
            throw new IdException();
        }
        boolean check = true;
        for (Worker worker : workers){
            worker.checkWorker();
        }

        return workers;
    }

    private boolean checkWorkeId(ArrayDeque<Worker> workers){
        HashSet<Long> set = new HashSet<>();
        for (Worker worker : workers){
            if (set.contains(worker.getId())){
                return false;
            }
            set.add(worker.getId());
        }
        return true;
    }
    public void save(ArrayDeque<Worker> arrayDeque) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new DateAdapter()).setPrettyPrinting().create();
        //try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Main.class.getClassLoader().getResource(fileName).toURI())))) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter( fileName))) {
            gson.toJson(arrayDeque, bufferedWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    try (Writer writer = new FileWriter("Output.json")) {
    Gson gson = new GsonBuilder().create();
    gson.toJson(users, writer);
    }
    public void writeCollection(Collection<?> collection) {
        if (System.getenv().get(envVariable) != null) {
            try (FileWriter collectionFileWriter = new FileWriter(new File(System.getenv().get(envVariable)))) {
                collectionFileWriter.write(gson.toJson(collection));
                Console.println("Коллекция успешна сохранена в файл!");
            } catch (IOException exception) {
                Console.printerror("Загрузочный файл является директорией/не может быть открыт!");
            }
        } else Console.printerror("Системная переменная с загрузочным файлом не найдена!");
    }
     */
}
