package com.epam.java.core3.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (InputStream resource = Main.class.getClassLoader()
                .getResourceAsStream("Java.SE.03.Information handling_task_attachment.html");
                BufferedReader reader = new BufferedReader(new InputStreamReader(resource))) {
            StringBuilder builder = new StringBuilder();
            reader.lines().forEach(line -> builder.append(line).append("\n"));
            HTMLParser parser = new HTMLParser(builder.toString());
            parser.isOrdered();

            for (String line : parser.findReferences()) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
