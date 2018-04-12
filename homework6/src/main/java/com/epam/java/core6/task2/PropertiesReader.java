package com.epam.java.core6.task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesReader {

    private Properties properties;

    public PropertiesReader(String filePath) {
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

    public void readProperties(String key) {
        if (properties.getProperty(key) == null) {
            throw new IllegalArgumentException("There is no such key");
        } else {
            System.out.println(properties.getProperty(key));
        }
    }

    public Map<String, String> getPropertiesMap() {
        Map map = new HashMap();
        for (String name : properties.stringPropertyNames()) {
            map.put(name, properties.getProperty(name));
        }
        return map;
    }
}