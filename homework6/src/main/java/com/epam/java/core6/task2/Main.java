package com.epam.java.core6.task2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class Main {

    public static final String PROPERTIES_FILE = "properties.txt";

    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        properties.setProperty("1", "One");
        properties.setProperty("2", "Two");
        properties.setProperty("3", "Three");
        properties.setProperty("4", "Four");
        try (FileOutputStream outputStream = new FileOutputStream(PROPERTIES_FILE)) {
            properties.store(outputStream, "Numbers");
        }

        PropertiesReader properties2 = new PropertiesReader(PROPERTIES_FILE);
//        properties2.readProperties("1");
//        properties2.readProperties("10");

        Map map = properties2.getPropertiesMap();
        System.out.println(map);
    }
}

