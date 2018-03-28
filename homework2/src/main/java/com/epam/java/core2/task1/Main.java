package com.epam.java.core2.task1;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Pen pen1 = new Pen(20,"Bic", "China");
        Pen pen2 = new Pen(50,"Luxury Pen", "Belarussia");
        Pen pen3 = new Pen(100,"Parker", "China");
        Pencil pencil1 = new Pencil(10, "Bic", "China");
        Notebook notebook1 = new Notebook(150, "Лысьва", "Russia");

        Employee leonidSergeev = new Employee(30, "Leonid Sergeev");
        Employee galinaIvanova = new Employee(25, "Galina Ivanova");

        EmployeesManagement.setStationery(leonidSergeev, pen1);
        EmployeesManagement.setStationery(leonidSergeev, pen2);
        EmployeesManagement.setStationery(leonidSergeev, notebook1);

        EmployeesManagement.setStationery(galinaIvanova, pencil1);
        EmployeesManagement.setStationery(galinaIvanova, pen3);

        System.out.println(EmployeesManagement.getStationeryValue(leonidSergeev));
        System.out.println(EmployeesManagement.getStationeryValue(galinaIvanova));

    }
}
