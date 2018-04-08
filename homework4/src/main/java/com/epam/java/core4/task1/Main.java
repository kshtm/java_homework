package com.epam.java.core4.task1;

public class Main {

    public static void main(String[] args) {

        JavaCodeReader reader = new JavaCodeReader("C:\\Users\\kshtm\\IdeaProjects\\java_homework\\homework4\\src\\main\\resources\\class.txt");
        System.out.println(reader.countKeywordsBytes());
        System.out.println(reader.countKeywordsChars());
        JavaCodeWriter writer = new JavaCodeWriter("result.txt");
        writer.writeToFileBytes(reader.countKeywordsBytes());
        JavaCodeWriter writer2 = new JavaCodeWriter("result2.txt");
        writer2.writeToFileChars(reader.countKeywordsChars());

    }
}
