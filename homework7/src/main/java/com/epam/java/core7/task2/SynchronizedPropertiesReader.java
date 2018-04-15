package com.epam.java.core7.task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedPropertiesReader {

    private volatile Properties properties;
    private String filePath;
    private Lock lock = new ReentrantLock();
    public SynchronizedPropertiesReader(String filePath) {
        this.filePath = filePath;
    }

    private void readFile() {
        System.out.println("Reading properties file...");
        File file = new File(filePath);
        if (!file.isFile() || !file.exists()) {
            throw new IllegalArgumentException("There is no such file");
        }
        try (FileInputStream stream = new FileInputStream(file)) {
            Properties properties = new Properties();
            properties.load(stream);
            this.properties = properties;
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public String readProperties(String key) {
        lock.lock();
        try {
            if (properties == null) {
                readFile();
            }
        } finally {
            lock.unlock();
        }
        if (properties.getProperty(key) == null) {
            throw new IllegalArgumentException("There is no such key");
        } else {
            return properties.getProperty(key);
        }
    }
}