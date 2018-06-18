package spring_aop.aspects;

import com.epam.java.spring_aop.model.Bar;
import com.epam.java.spring_aop.model.Person;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring_aop.TestUtils;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = spring_aop.configuration.ApplicationTestConfiguration.class)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class LoggingAspectTest {
    Bar bar;
    Person person;

    @NonFinal
    String fromSystemOut;

    @BeforeEach
    void beforeEach() {
        fromSystemOut = TestUtils.fromSystemOut(() -> bar.sellDrink(person));

    }

    @Test
    void loggingAroundTest() {
        assertTrue(fromSystemOut.contains("Call method"), "Around advice is not good");
        assertTrue(fromSystemOut.contains("has returned"), "Around advice is not good");
    }

}