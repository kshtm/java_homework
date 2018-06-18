package com.epam.java.spring_aop.aspects;

import com.epam.java.spring_aop.model.Person;
import com.epam.java.spring_aop.model.Drink;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Politeness {

    @Pointcut("bean(bar) && execution(lab5.model.Drink sellDrink(lab4.model.Person))")
    public void sellDrink() {

    }

    @Before("sellDrink() && args(person)")
    public void sayHello(Person person) {
        System.out.printf("Hello %s. How are you doing?%n", person.getName());
    }

    @AfterReturning(pointcut = "sellDrink()", returning = "returnValue", argNames = "returnValue")
    public void askOpinion(Drink returnValue) {
        System.out.printf("Is %s Good Enough?%n", returnValue.getName());
    }

    @AfterThrowing("sellDrink()")
    public void sayYouAreNotAllowed() {
        System.out.println("Hmmm... \n");
    }

    @After("sellDrink()")
    public void sayGoodBye() {
        System.out.println("Good Bye! \n");
    }

    @Around("sellDrink()")
    public Object sayPoliteWordsAndSell(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Hi! \n");
        Object returnValue = joinPoint.proceed();
        System.out.println("See you! \n");
        return returnValue;
    }


}
