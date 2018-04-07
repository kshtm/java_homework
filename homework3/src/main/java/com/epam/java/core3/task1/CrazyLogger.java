package com.epam.java.core3.task1;

import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class CrazyLogger {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-YYYY : hh-mm");
    private static final String LOG_TEMPLATE = "%s - %s\n";
    private StringBuilder stringBuilder;
    TreeMap<Integer, Integer> logsIndices;

    public CrazyLogger() {
        this.stringBuilder = new StringBuilder();
        this.logsIndices = new TreeMap<>();
    }

    public void log(String message) {
        LocalDateTime now = LocalDateTime.now();
        String formattedDate = FORMATTER.format(now);
        String formattedMessage = String.format(LOG_TEMPLATE, formattedDate, message);
        stringBuilder.append(formattedMessage);
        logsIndices.put(stringBuilder.length(), stringBuilder.length() - formattedMessage.length());
    }

    public void printLog(PrintStream stream) {
        stream.print(stringBuilder);
    }

    public void findLogs(PrintStream stream, String search) {
        int i = stringBuilder.indexOf(search);
        while (i != -1) {
            Map.Entry<Integer, Integer> coordinates = logsIndices.ceilingEntry(i);
            if (coordinates == null) {
                return;
            }
            stream.print(stringBuilder.substring(coordinates.getValue(), coordinates.getKey()));
            i = stringBuilder.indexOf(search, coordinates.getKey() + 1);
        }
    }
}

