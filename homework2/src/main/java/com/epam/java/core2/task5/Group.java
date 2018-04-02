package com.epam.java.core2.task5;

import java.util.*;

public class Group {

    private Course course;
    private Set<Student> students;
    private Map<Student, Number> marks;

    public Group(Course course) {
        this.course = course;
        this.students = new HashSet<>();
        this.marks = new HashMap<>();
    }

    public Course getCourse() {
        return course;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void setMark(Student student, Number mark) {
        if (course.isDoubleMark()) {
            if (!(mark instanceof Double)) {
                throw new IllegalArgumentException("Invalid mark type");
            }
        } else {
            if (!(mark instanceof Integer)) {
                throw new IllegalArgumentException("Invalid mark type");
            }
        }
        marks.put(student, mark);
    }

    public Number getMark(Student student) {
        return marks.get(student);
    }
}
