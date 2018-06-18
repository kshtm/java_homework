package com.epam.java.spring_aop.model;

import com.epam.java.spring_aop.model.Contact;
import com.epam.java.spring_aop.model.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.experimental.Wither;
import org.springframework.stereotype.Component;

import java.util.List;

@Builder
@AllArgsConstructor
@Value
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component("person")
public class PersonImpl implements Person {

    long id;
    String firstName;
    String lastName;
    Country country;
    int age;
    float height;
    boolean isProgrammer;

    @Wither
    boolean broke;

    @Singular
    List<Contact> contacts;
}
