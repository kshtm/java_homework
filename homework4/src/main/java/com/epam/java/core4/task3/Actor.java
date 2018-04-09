package com.epam.java.core4.task3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Actor implements Serializable {

    private String name;
    private int age;
    private List<String> films;

    public Actor(String name, int age) {
        this.name = name;
        this.age = age;
        this.films = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", films=" + films +
                '}';
    }

    public void addFilm(String film) {
        films.add(film);
    }


}
