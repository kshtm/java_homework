package com.epam.java.core3.task2;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Locale en = new Locale("en");
        Locale ru = new Locale("ru");

        Questionnaire enQuestionnarie = new Questionnaire(en);
        Questionnaire ruQuestionnarie = new Questionnaire(ru);

        System.out.println(enQuestionnarie.getAnswer("1"));
        System.out.println(ruQuestionnarie.getAnswer("2"));
    }
}
