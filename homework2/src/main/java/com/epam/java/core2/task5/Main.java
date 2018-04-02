package com.epam.java.core2.task5;


public class Main {


    public static void main(String[] args) {

        Student semenovPetr = new Student(20, "Semenov Petr");
        Student ivanovaElena = new Student(19, "Ivanova Elena");
        Student kolyadaGalina = new Student(40, "Kolyada Galina");

        Group mathematics = new Group(Course.MATHEMATICS);
        Group chemistry = new Group(Course.CHEMISTRY);
        Group history = new Group(Course.HISTORY);

        mathematics.addStudent(semenovPetr);
        mathematics.addStudent(ivanovaElena);
        mathematics.addStudent(kolyadaGalina);
        chemistry.addStudent(semenovPetr);
        history.addStudent(kolyadaGalina);
        history.addStudent(semenovPetr);

        mathematics.setMark(semenovPetr, 5.0);
        mathematics.setMark(ivanovaElena, 4.8);
        mathematics.setMark(kolyadaGalina, 2.0);
        chemistry.setMark(semenovPetr, 4.0);
        history.setMark(kolyadaGalina, 3);
        history.setMark(semenovPetr, 3);

        printMarks(semenovPetr, mathematics, chemistry, history);

    }

    public static void printMarks(Student student, Group... groups) {
        System.out.println("Marks for student " + student.getName());
        for (Group group : groups) {
            Number mark = group.getMark(student);
            if (mark == null) {
                continue;
            }
            System.out.println(group.getCourse().name() + " " + mark);
        }

    }
}
