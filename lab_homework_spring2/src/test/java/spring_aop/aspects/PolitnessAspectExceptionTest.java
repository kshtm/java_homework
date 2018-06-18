package spring_aop.aspects;

import com.epam.java.spring_aop.model.Bar;
import com.epam.java.spring_aop.model.CustomerBrokenException;
import com.epam.java.spring_aop.model.Person;
import lombok.NonNull;
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

import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = spring_aop.configuration.ApplicationTestConfiguration.class)
@FieldDefaults(level = PRIVATE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PolitnessAspectExceptionTest {

    @NonNull
    Bar bar;

    @NonNull
    Person person;

    String fromSystemOut;

    @BeforeEach
    void beforeEach() {
        person = person.withBroke(true);
    }

    @Test
    void beforeAdviceTest() {
        fromSystemOut = TestUtils.fromSystemOut(() -> assertThrows(CustomerBrokenException.class, () -> bar.sellDrink(person)));
        assertTrue(fromSystemOut.contains("Hmmm..."), "Before advice is not good");
    }
}
