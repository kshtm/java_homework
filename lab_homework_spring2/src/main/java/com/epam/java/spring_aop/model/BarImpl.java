package com.epam.java.spring_aop.model;

import com.epam.java.spring_aop.model.Person;
import com.epam.java.spring_aop.aspects.Loggable;
import org.springframework.stereotype.Component;

@Component("bar")
public class BarImpl implements Bar {

    @Override
    @Loggable
    public Drink sellDrink(Person person) {
        if (person.isBroke()) {
            throw new CustomerBrokenException();
        }
        System.out.println("Here is your drink");
        return () -> "Usual drink";
    }
}
