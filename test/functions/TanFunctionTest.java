package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TanFunctionTest {

    @Test
    void apply() {
        TanFunction fun = new TanFunction();
        double num = 1;
        assertEquals(Math.tan(num), fun.apply(num));
    }
    @Test
    void apply2() {
        TanFunction fun = new TanFunction();
        double num = .469;
        assertEquals(Math.tan(num), fun.apply(num));
    }
    @Test
    void apply3() {
        TanFunction fun = new TanFunction();
        double num = 17.059;
        assertEquals(Math.tan(num), fun.apply(num));
    }
}