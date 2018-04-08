package com.epam.java.core3.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLParser {

    //(Рис. 20) (Рис. 14-а)
    private static final Pattern REFERENCE_PATTERN = Pattern.compile("(\\(Рис\\.\\s(\\d+)-?[а-я]?\\))");
    private static final Pattern SENTENCE_PATTERN = Pattern.compile("(?!Рис)([А-Я][^.!?]+\\(Рис\\.\\s\\d+-?[а-я]?\\)[^.!?]*[.!?])");

    private String text;

    public HTMLParser(String text) {
        this.text = text;
    }

    public boolean isOrdered() {
        Matcher matcher = REFERENCE_PATTERN.matcher(text);
        int previousIndex = 0;
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            int refNumber = Integer.parseInt(matcher.group(2));
            if (refNumber < previousIndex) {
                System.out.println(String.format("Reference %d comes after reference %d", refNumber, previousIndex));
                return false;
            }
            previousIndex = refNumber;
        }
        return true;
    }

    public List<String> findReferences() {
        Matcher matcher = SENTENCE_PATTERN.matcher(text);
        List<String> result = new ArrayList<>();
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }


}
