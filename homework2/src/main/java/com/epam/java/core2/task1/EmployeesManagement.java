package com.epam.java.core2.task1;

public class EmployeesManagement {

    public static int getStationeryValue(Employee person) {
        int result = 0;
        for (Stationery currentStationery : person.getStationery()) {
            result += currentStationery.getPrice();
        }
        return result;
    }

    public static void setStationery(Employee person, Stationery currentStanionery) {
        person.getStationery().add(currentStanionery);
    }
}