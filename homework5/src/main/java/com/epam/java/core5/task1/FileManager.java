package com.epam.java.core5.task1;

import java.io.*;
import java.text.SimpleDateFormat;

public class FileManager {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");


    public void addFile(String filePath, String content) {
        if (filePath == null || content == null) {
            throw new IllegalArgumentException("File path & content are required");
        }
        try (FileWriter writer = new FileWriter(new File(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Failed to create file: " + e.getMessage());
        }
    }

    public void viewFile(String filePath) {
        File file = new File(filePath);
        if (!file.isFile() || !file.exists()) {
            throw new IllegalArgumentException("There is no such file");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.lines().forEach(line -> System.out.println(line));
        } catch (IOException e) {
            System.err.println("Failed to view file: " + e.getMessage());
        }
    }

    public void editFile(String filePath, String content) {
        File file = new File(filePath);
        if (!file.isFile() || !file.exists()) {
            throw new IllegalArgumentException("There is no such file");
        }
        if (content == null) {
            throw new IllegalArgumentException("Content is required");
        }
        try (FileWriter writer = new FileWriter(new File(filePath), true)) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Failed to edit file: " + e.getMessage());
        }
    }


    public void deleteFile(String filePath) {
        File file = new File(filePath);
        if (!file.isFile() || !file.exists()) {
            throw new IllegalArgumentException("There is no such file");
        }
        if (file.delete()) {
            System.out.println("File successfully deleted");
        } else {
            System.err.println("Failed to delete file");
        }
    }
    public void viewDirectory(String filePath) {
        File directory = new File(filePath);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("There is no such directory");
        }
        File[] files = directory.listFiles();
        if (files == null) {
            System.err.println("Directory is empty");
            return;
        }
        for (File file : files) {
            System.out.println(file.getName() + " " + file.length() + " " + DATE_FORMAT.format(file.lastModified()));
        }
    }
}
