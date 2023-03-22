package org.example;

import org.example.Exeption.UnknownCommandException;
import org.example.Exeption.WrongAmountOfElementsException;
import org.example.File.Collection;
import org.example.Util.HelperUtil;
import org.example.commands.*;

import java.util.HashMap;
import java.util.HashSet;

public class Factory {
    private final HashMap<String, Command> commandMap;
    private final HashSet<String> commandsWithArgs;

        public Factory(Collection collection){
        commandMap = new HashMap<>();
        commandMap.put("info", new Info(collection));
        commandMap.put("add", new Add(collection));
        commandMap.put("show", new Show(collection));
        commandMap.put("update", new UpdateId(collection));
        commandMap.put("remove_by_id", new RemoveById(collection));
        commandMap.put("clear", new Clear(collection));
        commandMap.put("save", new Save(collection));
        commandMap.put("execute_script", new ExecuteScript(collection, this));
        commandMap.put("exit", new Exit());
        commandMap.put("remove_first", new RemoveFirst(collection));
        commandMap.put("remove_head", new RemoveHead(collection));
        commandMap.put("remove_greater", new RemoveGreater(collection));
        commandMap.put("remove_all_by_salary", new RemoveAllBySalary(collection));
        commandMap.put("print_descending", new PrintDescending(collection));
        commandMap.put("print_field_ascending_organization", new PrintFieldAscendingOrganization(collection));
        commandMap.put("help", new Help());
        commandsWithArgs = new HashSet<>();
        commandsWithArgs.add("update");
        commandsWithArgs.add("remove_by_id");
        commandsWithArgs.add("remove_greater");
        commandsWithArgs.add("execute_script");
        commandsWithArgs.add("remove_all_by_salary");
        commandsWithArgs.add("save_as");
        }
        public CommandResult create(String s){
            String[] a = s.split(" ");
            String command1 = a[0];
            String[] args1 = new String[0];

            if (commandsWithArgs.contains(command1)){
                if (a.length > 2 || a.length == 1) throw new WrongAmountOfElementsException();
                args1 = new String[1];
                args1[0] = a[1];
            } else if (a.length > 1) throw new WrongAmountOfElementsException();
            Command command = commandMap.get(command1);
            if (command == null) {
                throw new UnknownCommandException();
            }
            //String[] a1 = Arrays.copyOfRange(a, 1, a.length);
            return new CommandResult(command, args1);
        }
    public static boolean checkCommand(String s) {
        if (HelperUtil.checkLong(s)) {
            return false;
        }
        return true;
    }
}



