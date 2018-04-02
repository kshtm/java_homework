package com.epam.java.core2.task1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Pen pen1 = new Pen(20,"Bic", "China");
        Pen pen2 = new Pen(50,"AAA Luxury Pen", "Belarussia");
        Pen pen3 = new Pen(100,"Parker", "China");
        Pencil pencil1 = new Pencil(10, "Bic", "China");
        Notebook notebook1 = new Notebook(150, "Лысьва", "Albania");

        Employee leonidSergeev = new Employee(30, "Leonid Sergeev");
        Employee galinaIvanova = new Employee(25, "Galina Ivanova");

        EmployeesManagement.supplyNewComer(leonidSergeev);
        EmployeesManagement.supplyNewComer(galinaIvanova);

        EmployeesManagement.addStationery(leonidSergeev, pen1);
        EmployeesManagement.addStationery(leonidSergeev, pen2);
        EmployeesManagement.addStationery(leonidSergeev, notebook1);

        EmployeesManagement.addStationery(galinaIvanova, pencil1);
        EmployeesManagement.addStationery(galinaIvanova, pen3);

        System.out.println(EmployeesManagement.getStationeryPrice(leonidSergeev));
        System.out.println(EmployeesManagement.getStationeryPrice(galinaIvanova));

        List<Stationery> stationery = leonidSergeev.getStationery();
        Collections.sort(stationery);
        System.out.println(stationery);

        stationery.sort(new Stationery.TitleComparator());
        System.out.println(stationery);

        stationery.sort(Comparator.comparing(Stationery::getManufactured));
        System.out.println(stationery);

    }
}
