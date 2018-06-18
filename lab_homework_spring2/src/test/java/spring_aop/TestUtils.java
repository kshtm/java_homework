package spring_aop;

import lombok.SneakyThrows;
import lombok.val;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public interface TestUtils {

    @SneakyThrows
    static String fromSystemOut(Runnable runnable) {
        PrintStream realOut = System.out;
        try (val out = new ByteArrayOutputStream();
             val printStream = new PrintStream(out)) {
            System.setOut(printStream);
            runnable.run();
            return new String(out.toByteArray());
        } finally {
            System.setOut(realOut);
        }
    }
}
