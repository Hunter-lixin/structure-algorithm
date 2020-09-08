package com.basic.test;

public class Employee {

    public Employee(double salery) {
        this.salery = salery;
    }

    private double salery;

    public double getSalery() {
        return salery;
    }

    public void setSalery(double salery) {
        this.salery = salery;
    }

    public static void main(String[] args) {
        double x = 10;
        System.out.println(x);
        tripleValue(x);
        System.out.println(x);

        Employee harry = new Employee(100);
        System.out.println(harry.getSalery());
        tripleSalery(harry);
        System.out.println(harry.getSalery());
    }

    public static void tripleValue(double x) {
        x = 3 * x;
    }

    public static void tripleSalery(Employee employee) {
        employee.setSalery(200);
    }
}
