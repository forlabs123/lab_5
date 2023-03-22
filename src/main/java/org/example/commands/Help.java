package org.example.commands;

/**
 * The `HelpCommand` class is a command that displays the help of the available commands
 */
public class   Help extends Command{
    /**
     * Prints information about the available commands in the program to the console.
     */
    @Override
    public void execute(String[] args) {
        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "remove_first : удалить первый элемент из коллекции\n" +
                "remove_head : вывести первый элемент коллекции и удалить его\n" +
                "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный\n" +
                "remove_all_by_salary salary : удалить из коллекции все элементы, значение поля salary которого эквивалентно заданному\n" +
                "print_descending : вывести элементы коллекции в порядке убывания\n" +
                "print_field_ascending_organization : вывести значения поля organization всех элементов в порядке возрастания\n" +
                "remove_by_id id : удалить элемент из коллекции по его id");
    }
}
