package com.epam.java.core5.task1;

import com.epam.java.core5.task1.FileManager;

public class Main {

    public static void main(String[] args) {

        FileManager manager = new FileManager();
        manager.addFile("managerExample.txt", "Good evening \nI like cats");
        manager.viewFile("managerExample.txt");
        manager.editFile("managerExample.txt", "\nAnd pigs");
        manager.viewFile("managerExample.txt");
        manager.viewDirectory("C:\\Users\\kshtm\\IdeaProjects\\java_homework");
        manager.deleteFile("managerExample.txt");
    }
}
