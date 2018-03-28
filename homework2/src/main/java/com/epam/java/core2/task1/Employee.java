package com.epam.java.core2.task1;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private int age;
    private String name;
    private List<Stationery> stationery;

    public Employee(int age, String name) {
        this.age = age;
        this.name = name;
        this.stationery = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stationery> getStationery() {
        return stationery;
    }

    public void setStationery(List<Stationery> stationery) {
        this.stationery = stationery;
    }
}
