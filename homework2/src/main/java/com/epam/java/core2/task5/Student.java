package com.epam.java.core2.task5;


import java.util.Objects;

public class Student {

    private final int age;
    private final String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return getAge() == student.getAge() &&
                Objects.equals(getName(), student.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getAge(), getName());
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
