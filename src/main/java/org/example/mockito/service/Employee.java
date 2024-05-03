package org.example.mockito.service;

import java.util.Objects;
import java.util.Random;

public class Employee {
    private String firstName;
    private String lastName;
    private int department;
    private double selary;


    public Employee(String firstName, String lastName, int department, int selary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.selary = selary;
    }
    public Employee(String firstName, String lastName) {
        Random random = new Random();
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = random.nextInt(5) + 1;
        this.selary = random.nextInt(1000) + 1000;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFullName(){
        return firstName + " " + lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDepartment() {
        return department;
    }

     public double getSelary() {
            return selary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
        public void setSelary(double selary) {
            this.selary = selary;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(selary, employee.selary) == 0 && department == employee.department && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, selary, department);
    }

    public String getFirstNeme() {
        return firstName;


    }

    public void put(Object o, Employee employee) {

    }

    public String getLastNaime() {
        return null;
    }

    public Object gettFirstName() {
        return null;
    }
}





