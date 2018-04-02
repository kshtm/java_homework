package com.epam.java.core2.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeesManagement {

    public final static List<Stationery> NEWCOMERS_STATIONERY = Arrays.asList(
            new Pen(20, "Bic", "China"),
            new Pencil(10, "Bic", "China"),
            new Notebook(150, "Лысьва", "Russia"));

    public static void supplyNewComer(Employee employee) {
        employee.setStationery(new ArrayList<>(NEWCOMERS_STATIONERY));
    }

    public static int getStationeryPrice(Employee person) {
        int result = 0;
        for (Stationery currentStationery : person.getStationery()) {
            result += currentStationery.getPrice();
        }
        return result;
    }

    public static void addStationery(Employee person, Stationery currentStanionery) {
        person.getStationery().add(currentStanionery);
    }
}