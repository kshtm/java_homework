package com.epam.java.core4.task1;

public class Main {

    public static void main(String[] args) {

        JavaCodeReader reader = new JavaCodeReader("C:\\Users\\kshtm\\IdeaProjects\\java_homework\\homework4\\src\\main\\resources\\class.txt");
        System.out.println(reader.countKeywords());
    }
}
