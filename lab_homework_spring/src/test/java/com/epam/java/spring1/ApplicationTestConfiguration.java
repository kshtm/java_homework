package com.epam.java.spring1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("com.epam.java")
public class ApplicationTestConfiguration {

    @Bean
    public Long id() {
        return 1L;
    }

    @Bean
    public String firstName() {
        return "John";
    }

    @Bean
    public String lastName() {
        return "Smith";
    }

    @Bean
    public Integer age() {
        return 35;
    }

    @Bean
    public Boolean isProgrammer() {
        return true;
    }

    @Bean
    public Float height() {
        return 1.78F;
    }

    @Bean
    public Boolean broke() {
        return false;
    }

    @Bean
    public String name() {
        return "Russia";
    }

    @Bean
    public String codeName() {
        return "RU";
    }

    @Bean
    public List<Contact> contacts() {
        return Arrays.asList(
                ContactImpl.builder().id(1).value("asd@asd.ru").build(),
                ContactImpl.builder().id(1).type("TELEPHONE").value("+55 11 99999-5555").build()
        );
    }
}
