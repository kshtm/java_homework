package com.epam.java.spring1;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;

@Value
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class ContactImpl implements Contact {

    long id;
    String value;

    @Builder.Default
    String type;
}