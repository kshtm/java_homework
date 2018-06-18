package com.epam.java.spring_aop.model;

import com.epam.java.spring_aop.model.Person;

@FunctionalInterface
public interface Bar {
    Drink sellDrink(Person person);

}
