package org.example.model;

public class Organization implements Comparable<Organization>{
    private String fullName; //Длина строки не должна быть больше 1847, Поле может быть null
    private Long employeesCount; //Поле не может быть null, Значение поля должно быть больше 0
    private OrganizationType type; //Поле не может быть null
    private Address postalAddress; //Поле не может быть null

    public Organization(String fullName, Long employeesCount, OrganizationType type, Address postalAddress) {
        this.fullName = fullName;
        this.employeesCount = employeesCount;
        this.type = type;
        this.postalAddress = postalAddress;
    }


    public Organization() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(Long employeesCount) {
        this.employeesCount = employeesCount;
    }

    public OrganizationType getType() {
        return type;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(Address postalAddress) {
        this.postalAddress = postalAddress;
    }
    @Override
    public String toString() {
        return "Organization{" +
                "fullName='" + fullName + '\'' +
                ", employeesCount=" + employeesCount +
                ", type=" + type +
                ", postalAddress=" + postalAddress +
                '}';
    }

    @Override
    public int compareTo(Organization o) {
            return fullName.compareTo(o.fullName);
    }
}