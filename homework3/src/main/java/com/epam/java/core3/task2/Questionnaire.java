package com.epam.java.core3.task2;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Questionnaire {

    private ResourceBundle answers;

    public Questionnaire(Locale locale) {
        this.answers = ResourceBundle.getBundle("com.epam.java.core3.task2.Questions", locale);
    }

    public String getAnswer(String questionID) {
        try {
            Question result = (Question) answers.getObject(questionID) ;
            return result.getQuestion() + " " + result.getAnswer();
        } catch (MissingResourceException e) {
            return "Question not found";
        }
    }
}
