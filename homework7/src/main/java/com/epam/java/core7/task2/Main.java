package com.epam.java.core7.task2;

import java.io.FileOutputStream;
import java.io.IOException;
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

        SynchronizedPropertiesReader synchronizedReader = new SynchronizedPropertiesReader(PROPERTIES_FILE);
        Thread thread1 = new Thread(new PropertiesReader(synchronizedReader));
        Thread thread2 = new Thread(new PropertiesReader(synchronizedReader));

        thread1.start();
        thread2.start();
    }

    private static class PropertiesReader implements Runnable{

        private SynchronizedPropertiesReader reader;

        public PropertiesReader(SynchronizedPropertiesReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            System.out.println(reader.readProperties("1"));
            System.out.println(reader.readProperties("2"));
            System.out.println(reader.readProperties("3"));
            System.out.println(reader.readProperties("4"));
        }
    }
}
