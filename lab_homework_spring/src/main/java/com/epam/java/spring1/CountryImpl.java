package com.epam.java.spring1;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Builder
@Getter
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = "id")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component("country")
public class CountryImpl implements Country {

    long id;
    String name;
    String codeName;
}
