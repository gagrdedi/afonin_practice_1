package function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testClassTest {

    @Test
    void applyTest() {
        double x = 1;
        assertEquals(x, testClass.apply(x));
    }
}