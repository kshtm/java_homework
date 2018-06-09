package com.epam.java.spring1;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertEquals;

class ApplicationTest {

    static BeanFactory BEAN_FACTORY = new AnnotationConfigApplicationContext(ApplicationTestConfiguration.class);

    @Test
    void test() {
        assertEquals(getExpectedPerson(), BEAN_FACTORY.getBean("person"));
    }

    static Person getExpectedPerson() {
        return PersonImpl.builder()
                .id(1L)
                .age(35)
                .height(1.78F)
                .isProgrammer(true)
                .firstName("John")
                .lastName("Smith")
                .country(CountryImpl.builder().id(1L).name("Russia").codeName("RU").build())
                .contact(ContactImpl.builder().id(1L).value("asd@asd.ru").build())
                .contact(ContactImpl.builder().id(1L).type("TELEPHONE").value("+55 11 99999-5555").build())
                .build();
    }
}
