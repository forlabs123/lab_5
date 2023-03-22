package org.example.commands;

import org.example.Exeption.IdException;
import org.example.Exeption.NullArgumentException;
import org.example.Exeption.WrongSizeOfElementException;
import org.example.Exeption.WrongTypeException;
import org.example.File.Collection;
import org.example.Util.HelperUtil;
import org.example.model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * The class is responsible for adding an organization to the collection
 */
public class Add extends Command{
    private Collection collection;
    public Add(Collection collection) {
        this.collection = collection;
    }
    /**
     * The function adds an organization to the collection
     */
    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            //System.out.println("Введите id работника: ");
            //long id = scanner.nextLong();
            long id = collection.maxId() + 1;
            System.out.println("Введите имя работника ");
            String name = HelperUtil.inputString();
            Coordinates coordinates = createCoordinates();
            //System.out.println("Введите время dd-MM-yyyy");
            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            //String date = scanner.next();
            LocalDate localDate = LocalDate.now();
            System.out.println("Введите зарплату работника        (зарплата больше 0, хотя бы МРОТ в теории): ");
            Float salary = HelperUtil.inputFloatSalary();
            System.out.println("Введите время dd-MM-yyyy");
            LocalDate localDate2 = HelperUtil.inputData();
            System.out.println("Выберите должность 0-DIRECTOR 1-HEAD_OF_DIVISION 2-BAKER 3-COOK 4-CLEANER");
            String number = scanner.next();
            Position position = createPosition(number);
            System.out.println("Выберите статус 0-HIRED 1-RECOMMENDED_FOR_PROMOTION 2-REGULAR 3-PROBATION");
            String numberStatus = scanner.next();
            Status status = createStatus(numberStatus);
            Organization organisation = createOrganisation();
            Worker worker = new Worker(id, name, coordinates, localDate, salary, localDate2, position, status, organisation);
            collection.add(worker);
        }
        else {
            String[] params = args[0].split(";");
            long id = Long.parseLong(params[0]);
            if (id <= 0 ) throw new WrongTypeException("id должен быть положительным");
            if (collection.getById(id) != null){
                throw new IdException();
            }
            //if (params[1].isEmpty() || params[1].equals("null")) throw new WrongTypeException();
            String name = params[1];
            float x = Float.parseFloat(params[2]);
            long y = Long.parseLong(params[3]);
            Coordinates coordinates = new Coordinates(x,y);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(params[4], formatter);
            Float salary = Float.parseFloat(params[5]);
            LocalDate localDate2 = LocalDate.parse(params[6], formatter);
            Position position = createPosition(params[7]);
            Status status = createStatus(params[8]);
            String nameOrg = params[9];
            if (params[9].isEmpty() || params[9].equals("null")) throw new WrongTypeException("организация не может быть null");
            long emploeesCount = Long.parseLong(params[10]);
            OrganizationType status1;
            if (HelperUtil.checkInteger(params[11])){
                int number1 = Integer.parseInt(params[11]);
                status1 = OrganizationType.values()[number1];
            } else {
                status1 = OrganizationType.valueOf(params[11]);
            }
            String address = params[12];
            Address adr = new Address(address);
            HelperUtil.checkWorkers(id, name, coordinates, localDate, salary, localDate2, position, status, nameOrg, emploeesCount, status1, address);
            Organization organisation = new Organization(nameOrg, emploeesCount, status1, adr);
            Worker worker = new Worker(id, name, coordinates, localDate, salary, localDate2, position, status, organisation);
            collection.add(worker);
        }
    }

    private Organization createOrganisation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите полное имя ");
        String fullName = scanner.nextLine();
        System.out.println("Введите количество сотрудников ");
        long emploeesCount = HelperUtil.inputLong();
        System.out.println("Выберите статус 0-PUBLIC 1-GOVERNMENT 2-PRIVATE_LIMITED_COMPANY 3-OPEN_JOINT_STOCK_COMPANY");
        int numberStatus = HelperUtil.inputInt();
        OrganizationType status = OrganizationType.values()[numberStatus];
        Address address = createAddres();
        return new Organization(fullName, emploeesCount, status, address);
    }
    private Address createAddres(){
        System.out.println("Введите адрес ");
        Scanner scanner = new Scanner(System.in);
        String address = scanner.next();
        return new Address(address);
    }

    private Coordinates createCoordinates(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите x, y");
        float x = HelperUtil.inputFloat();
        long y = HelperUtil.inputLong();
        return new Coordinates(x,y);
    }
    private Position createPosition(String s){
        Position position;
        if (s.equals("null")){
            System.err.println("значение не может быть null");
        }
        if (HelperUtil.checkInteger(s)){
            int number = Integer.parseInt(s);
            position = Position.values()[number];
        } else {
            position = Position.valueOf(s);
        }
        return position;
    }
    private Status createStatus(String s){
        Status status;
        if (HelperUtil.checkInteger(s)){
            int number1 = Integer.parseInt(s);
            status = Status.values()[number1];
        } else {
            status = Status.valueOf(s);
        }
        return status;
    }

}
