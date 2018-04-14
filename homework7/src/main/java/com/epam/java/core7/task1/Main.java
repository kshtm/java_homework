package com.epam.java.core7.task1;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        try (Bank sberbank = new Bank("C:\\Users\\kshtm\\IdeaProjects\\java_homework\\homework7\\src\\main\\resorces\\Accounts.txt")) {
            System.out.println(sberbank.getAccounts());
            sberbank.addAccount(new Account(new Random().nextInt(), 999.99, "John Show"));
            sberbank.transfer(300, 144, 1000.0);
            System.out.println(sberbank.getAccounts());
        }

    }
}
