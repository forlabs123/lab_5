package org.example.File;

import org.example.model.Organization;
import org.example.model.Worker;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * The CollectionManager class manages the collection of all the collections
 * in the application
 */
public class Collection {
    private ArrayDeque<Worker> workers;
    private LocalDateTime dateSave;
    private FileManager fileManager;
    public LocalDateTime getDateSave() {
        return dateSave;
    }
    public void save(){
        dateSave = LocalDateTime.now();
        fileManager.save(workers);
    }
    public void saveAs(String fileName){
        FileManager fileManager1 = new FileManager(fileName);
        fileManager1.save(workers);
    }

    private LocalDateTime dateInit;
    public Collection(FileManager fileManager) throws FileNotFoundException {
        this.workers = fileManager.readFile();
        dateInit = LocalDateTime.now();
        this.fileManager = fileManager;
            }
    /**
     * Get the creation date of the object
     * @return The creation date of the collection.
 */
    public LocalDateTime getDateInit() {
        return dateInit;
    }
    /**
     * This function returns the collection of workers
     * @return The ArrayDeque of Workers objects.
     */
    public ArrayDeque<Worker> getWorkers(){
        return workers;
    }
    public void add(Worker worker){
        workers.add(worker);
    }
    public String getType(){
        return workers.getClass().getName();
    }
    public void clear(){
        workers.clear();
    }
    public Worker getById(long id){
        for (Worker worker : workers){
            if (worker.getId() == id){
                return worker;
            }
        }
        return null;
    }
    public Worker getBySalary(float salary){
        for (Worker worker : workers){
            if (worker.getSalary() == salary){
                return worker;
            }
        }
        return null;
    }
    public void removeById(long id) {
        ArrayList<Worker> workerArrayList = new ArrayList<>(workers);
        for (int i = 0; i < workerArrayList.size(); ++i) {
            if (workerArrayList.get(i).getId() == id) {
                workerArrayList.remove(i);
            }
        }
        workers = new ArrayDeque<>(workerArrayList);
    }
    public Long maxId(){
        if (workers.isEmpty()){
            return 0L;
        }
        return workers.stream().max(Comparator.comparing(Worker::getId)).get().getId();
    }
    public int countElements(){
        return workers.size();
    }
    public void removeGreater(float salary){
        workers.removeIf(worker -> worker.getSalary() > salary);
    }
    public void removeFirst(){
        workers.removeFirst();
    }
    public void showFirst() {
        System.out.println(workers.peek());
    }
    public ArrayList<Organization> getOrganisation(){
        ArrayList<Organization> organizations = new ArrayList<>();
        for (Worker worker : workers){
            if (!organizations.contains(worker.getOrganization())){
                organizations.add(worker.getOrganization());
            }
        }
        return organizations;
    }
    public void removeAllBySalary(float salary) {
        workers.removeIf(worker -> worker.getSalary() == salary);
    }

    /*
    public void saveCollection(Collection collection){
        try (PrintWriter collectionPrintWriter = new PrintWriter(new File(fileName))) {
            collectionPrintWriter.println(gson.toJson(collection));
        } catch (IOException e) {
            System.out.println("Загрузочный фацл не может быть открыт");
        }
    }
    }
     */
}
