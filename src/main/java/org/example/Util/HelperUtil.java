package org.example.Util;

import org.example.Exeption.NullArgumentException;
import org.example.model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class HelperUtil {
    public static boolean checkInteger(String s) {
        try {
            int a = Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public static boolean checkString(String s){
        if (s.equals("null")){
            return true;
        }
        return false;
    }

    public static boolean checkLong(String s) {
        try {
            long a = Long.parseLong(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean checkFloat(String s) {
        try {
            float a = Float.parseFloat(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public static String inputString() {
        Scanner scanner = new Scanner(System.in);
        String result;
        while (true) {
            String s = scanner.next();
            if (s.equals("null") || s.isEmpty()) {
                System.err.println("данные не могут быть null");
            } else {
                result = s;
                break;
            }
        }
        return result;
    }


        public static long inputLong() {
        Scanner scanner = new Scanner(System.in);
        long result;
        while (true) {
            String s = scanner.next();
            if (checkLong(s)) {
                result = Long.parseLong(s);
                break;
            } else {
                System.err.println("нужен long формат данных");
            }
        }
        return result;
    }

    public static int inputInt() {
        Scanner scanner = new Scanner(System.in);
        int result;
        while (true) {
            String s = scanner.next();
            if (checkInteger(s)) {
                result = Integer.parseInt(s);
                break;
            } else {
                System.err.println("нужен int формат данных");
            }
        }
        return result;
    }

    public static float inputFloat() {
        Scanner scanner = new Scanner(System.in);
        float result;
        while (true) {
            String s = scanner.next();
            if (checkFloat(s)) {
                result = Float.parseFloat(s);
                break;
            } else {
                System.err.println("нужен float формат данных");
            }
        }
        return result;
    }

    public static float inputFloatSalary() {
        Scanner scanner = new Scanner(System.in);
        float result;
        while (true) {
            String s = scanner.next();
            if (checkFloat(s)) {
                result = Float.parseFloat(s);
                if (result <= 0) {
                    System.err.println("зарплата должна быть больше нуля)");
                } else {
                    break;
                }
            } else {
                System.err.println("нужен float формат данных");
            }
        }
        return result;
    }

    public static boolean checkData(String data) {
        try {
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(data, formatter2);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static LocalDate inputData() {
        Scanner scanner = new Scanner(System.in);
        LocalDate result;
        while (true) {
            String s = scanner.next();
            if (checkData(s)) {
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                result = LocalDate.parse(s, formatter2);
                break;
            } else {
                System.err.println("некорректаня дата");
            }
        }
        return result;
    }
    public static void checkWorkers(Long id, String name, Coordinates coordinates, LocalDate creationDate, Float salary, LocalDate startDate, Position position, Status status, String nameOrg, long emploeesCount, OrganizationType status1, String address){
        if (id == null) throw new NullArgumentException("id не может быть null");
        if (id <= 0) throw new IllegalArgumentException("id не положительный");
        if (Objects.equals(name,"null") || name == null || name.isEmpty() || name.isBlank()) throw new NullArgumentException("имя пустое");
        if (coordinates == null) throw  new NullArgumentException("пустые координаты");
        if (creationDate == null)throw new NullArgumentException("нулевое время");
        if (salary <= 0) throw new IllegalArgumentException("зарплата <= 0");
        if (startDate == null) throw new NullArgumentException("нулевое время");
        if (position == null) throw new NullArgumentException("некорректная позиция");
        if (status == null) throw new NullArgumentException("некорректный статус");
        if (nameOrg.length() > 1847) throw  new IllegalArgumentException("некорректный формат полного имени");
        if (emploeesCount <= 0) throw  new IllegalArgumentException("зарплата не может быть <= 0 ");
        if (Objects.equals(emploeesCount,null)) throw  new NullArgumentException("зарплата не может быть null");
        if (Objects.equals(status1,null)) throw  new NullArgumentException("статус не может быть null");
        if (address == null) throw  new NullArgumentException("данные не могут быть null");
    }
}

