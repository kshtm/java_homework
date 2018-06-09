package com.epam.java.spring1;

import java.util.List;

public interface Person {

    Person withBroke(boolean broke);
    String getFirstName();
    String getLastName();
    Country getCountry();
    int getAge();
    float getHeight();
    boolean isProgrammer();
    boolean isBroke();
    List<Contact> getContacts();
    default String getName() {
        return String.format("%s %s", getFirstName(), getLastName());
    }
}
