package spring_aop.aspects;

import com.epam.java.spring_aop.model.Bar;
import com.epam.java.spring_aop.model.BarImpl;
import com.epam.java.spring_aop.model.Person;
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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = spring_aop.configuration.ApplicationTestConfiguration.class)
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PolitenessAspectTest {
    Bar bar;
    Person person;

    @NonFinal
    String fromSystemOut;

    @BeforeEach
    void beforeEach() {
        fromSystemOut = TestUtils.fromSystemOut(() -> bar.sellDrink(person));
    }

    @Test
    void beforeAdviceTest() {
        assertTrue(fromSystemOut.contains("Hello"), "Before advice is not good");
    }

    @Test
    void testAfterAdvice() {
        assertTrue(fromSystemOut.contains("Good Bye!"), "After advice is not good");
    }

    @Test
    void testAfterReturningAdvice() {
        assertTrue(fromSystemOut.contains("Good Enough?"), "Customer is broken");
    }

    @Test
    void testAroundAdvice() {
        assertTrue(fromSystemOut.contains("Hi!"), "Around advice is not good");
        assertTrue(fromSystemOut.contains("See you!"), "Around advice is not good");
    }

    @Test
    void testAllAdvices() {
        assertFalse(bar instanceof BarImpl, "barObject instanceof SimpleBar");
    }
}