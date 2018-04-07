package com.epam.java.core3.task2;

import java.util.ListResourceBundle;

public class Questions_en extends ListResourceBundle {

    static final Object[][] contents = {
            {"1", new Question("To be or not to be?", "Not to be")},
            {"2", new Question("Is there life on Mars?", "No, there is not")},
            {"3", new Question("What is the answer to the ultimate question of life, the Universe and everything?", "42")},
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }

}
