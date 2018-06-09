package com.epam.java.spring1;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.experimental.Wither;
import org.springframework.stereotype.Component;

import java.util.List;

@Builder
@AllArgsConstructor
@Value
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
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
