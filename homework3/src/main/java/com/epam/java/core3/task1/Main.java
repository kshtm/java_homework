package com.epam.java.core3.task1;

import com.epam.java.core3.task1.CrazyLogger;

public class Main {

    public static void main(String[] args) {

        CrazyLogger logger = new CrazyLogger();
        logger.log("Good Evening");
        logger.log("Good Evening");
        logger.log("Buenas Tardes");
        logger.printLog(System.out);
        System.out.println();
        logger.findLogs(System.out, "G");
        logger.findLogs(System.out, "Buenas");
        logger.findLogs(System.out, "zd");
    }
}
