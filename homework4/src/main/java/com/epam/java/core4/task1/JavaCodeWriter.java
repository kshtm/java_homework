package com.epam.java.core4.task1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class JavaCodeWriter {

    private String filePath;

    public JavaCodeWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writeToFileBytes(Map<String, Integer> data) {
        try (FileOutputStream stream = new FileOutputStream(new File(filePath))) {
            stream.write(data.toString().getBytes());
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }


    public void writeToFileChars(Map<String, Integer> data) {
        try (FileWriter writer = new FileWriter(new File(filePath))) {
            writer.write(data.toString());
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

}
