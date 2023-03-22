package org.example.commands;

import org.example.model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class WorkerBuilder{
    public static Worker create(long identifier){
        Scanner scanner = new Scanner(System.in);
        long id = identifier;
        System.out.println("name ");
        String name = scanner.next();
        Coordinates coordinates = createCoordinates();
        System.out.println("Введите время ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = scanner.next();
        LocalDate localDate = LocalDate.parse(date, formatter);
        System.out.println("Введите зарплату работника: ");
        Float salary = scanner.nextFloat();
        System.out.println("Введите время_2 ");
        String date2 = scanner.next();
        LocalDate localDate2 = LocalDate.parse(date2, formatter);
        System.out.println("Выберите должность 0-DIRECTOR 1-HEAD_OF_DIVISION 2-BAKER 3-COOK 4-CLEANER");
        int number = scanner.nextInt();
        Position position = Position.values()[number];
        System.out.println("Выберите статус 0-HIRED 1-RECOMMENDED_FOR_PROMOTION 2-REGULAR 3-PROBATION");
        int numberStatus = scanner.nextInt();
        Status status = Status.values()[numberStatus];
        Organization organisation = createOrganisation();
        Worker worker = new Worker(id, name, coordinates, localDate,salary, localDate2, position, status, organisation);
        return worker;
    }
    private static Organization createOrganisation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите полное имя ");
        String fullName = scanner.next();
        System.out.println("Введите количество сотрудников ");
        long emploeesCount = scanner.nextLong();
        System.out.println("Выберите статус 0-PUBLIC 1-GOVERNMENT 2-PRIVATE_LIMITED_COMPANY 3-OPEN_JOINT_STOCK_COMPANY");
        int numberStatus = scanner.nextInt();
        OrganizationType status = OrganizationType.values()[numberStatus];
        Address address = createAddres();
        return new Organization(fullName, emploeesCount, status, address);
    }
    private static Address createAddres(){
        System.out.println("Введите адрес ");
        Scanner scanner = new Scanner(System.in);
        String address = scanner.next();
        return new Address(address);
    }

    private static Coordinates createCoordinates(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите x, y");
        float x = scanner.nextFloat();
        long y = scanner.nextLong();
        return new Coordinates(x,y);
    }

}
