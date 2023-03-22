package org.example.model;

import org.example.Exeption.NullArgumentException;

import java.time.LocalDate;
import java.util.Objects;

public class Worker implements Comparable<Worker>{
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float salary; //Поле может быть null, Значение поля должно быть больше 0
   private LocalDate startDate; //Поле не может быть null
    private Position position; //Поле может быть null
    private Status status; //Поле может быть null
    private Organization organization; //Поле не может быть null
    public Worker(Long id, String name, Coordinates coordinates, LocalDate creationDate, Float salary, LocalDate startDate, Position position, Status status, Organization organization) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.salary = salary;
        this.startDate = startDate;
        this.position = position;
        this.status = status;
        this.organization = organization;
    }
    /*
    public Worker(Long id, String name, Coordinates coordinates, LocalDate creationDate, Float salary, LocalDate startDate, Position position, Status status, Organization organization) {
        if (id.equals(null)) throw new NullArgumentException("нулевой id");
        if (id <= 0) throw new IllegalArgumentException("id не положительный");
        this.id = id;
        if (name.equals("null") || name == null || name.isEmpty() || name.isBlank()) throw new NullArgumentException("имя пустое");
        this.name = name;
        if (coordinates == null) throw  new NullArgumentException("пустые координаты");
        this.coordinates = coordinates;
        if (creationDate == null)throw new NullArgumentException("нулевое время");
        this.creationDate = creationDate;
        if (salary <= 0) throw new IllegalArgumentException("зарплата <= 0");
        this.salary = salary;
        if (startDate == null) throw new NullArgumentException();
        this.startDate = startDate;
        if (position == null) throw new NullArgumentException();
        this.position = position;
        if (status == null) throw new NullArgumentException();
        this.status = status;
        if (organization == null) throw new NullArgumentException();
        this.organization = organization;
    }
     */


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", salary=" + salary +
                ", startDate=" + startDate +
                ", position=" + position +
                ", status=" + status +
                ", organization=" + organization +
                '}';
    }
    @Override
    public int compareTo(Worker o) {
        if (!Objects.equals(salary, o.salary)) {
            return Float.compare(salary, o.salary);
        }
        if (name.length() != o.name.length()) {
            return Integer.compare(name.length(), o.name.length());
        }
        return Long.compare(id, o.id);
    }
    public void checkWorker(){
            if (getId() == null) throw new NullArgumentException("id не может быть null");
            if (getId() <= 0) throw new IllegalArgumentException("id не положительный");
            if (Objects.equals(getName(),"null") || getName() == null || getName().isEmpty() || getName().isBlank()) throw new NullArgumentException("имя пустое");
            if (getCoordinates() == null) throw  new NullArgumentException("пустые координаты");
            if (getCreationDate() == null)throw new NullArgumentException("нулевое время");
            if (getSalary() <= 0) throw new IllegalArgumentException("зарплата <= 0");
            if (getStartDate() == null) throw new NullArgumentException("нулевое время");
            if (getPosition() == null) throw new NullArgumentException("некорректная позиция");
            if (getStatus() == null) throw new NullArgumentException("некорректный статус");
            if (getOrganization() == null) throw new NullArgumentException("некорректная организация");
            if (getOrganization().getFullName().length() > 1847) throw  new IllegalArgumentException("некорректный формат полного имени");
            if (getOrganization().getEmployeesCount() <= 0) throw  new IllegalArgumentException("зарплата не может быть <= 0 ");
            if (getOrganization().getEmployeesCount() == null) throw  new NullArgumentException("зарплата не может быть null");
            if (getOrganization().getType() == null || getOrganization().getPostalAddress() == null) throw  new NullArgumentException("данные не могут быть null");
        }
}


