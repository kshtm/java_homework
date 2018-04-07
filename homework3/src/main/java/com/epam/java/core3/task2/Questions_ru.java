package com.epam.java.core3.task2;

import java.util.ListResourceBundle;

public class Questions_ru extends ListResourceBundle {

    static final Object[][] contents = {
            {"1", new Question("Быть или не быть?", "Не быть")},
            {"2", new Question("Есть ли жизнь на Марсе?", "Нет")},
            {"3", new Question("Главный вопрос жизни, Вселенной и всего такого?", "42")},
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }

}
