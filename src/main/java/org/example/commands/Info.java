package org.example.commands;

import org.example.File.Collection;

/**
 * The 'Info' class provides information about the collection.
 */
public class Info extends Command{
    Collection collection;

    public Info(Collection collection) {
        this.collection = collection;
    }

    /**
     *Print information about collection: type, initialization date, number of items
     */
    @Override
    public void execute(String[] args) {
        if (args.length > 0){
            System.out.println("Лишние аргументы");
            return;
        }
        System.out.println("Информация о коллекции: ");
        System.out.println("Тип коллекции: " + collection.getType());
        System.out.println("Количество элементов: " + collection.getWorkers().size());
        System.out.println(""+ collection.getDateInit());
        if (collection.getDateSave() == null){
            System.out.println("Коллекция не сохранена");
        } else {
            System.out.println("Коллекция сохранена: " + collection.getDateSave());
        }
    }
}
