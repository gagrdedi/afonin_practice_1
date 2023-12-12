package functions;

import functions.ConstantFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConstantFunctionTest {

    @Test
    void getC() {
        double c = .3563;
        ConstantFunction fun = new ConstantFunction(c);
        assertEquals(c,fun.getC());
    }
    @Test
    void getC2() {
        double c = 3569.24635;
        ConstantFunction fun = new ConstantFunction(c);
        assertEquals(c,fun.getC());
    }
    @Test
    void getC3() {
        double c = 345.23524;
        ConstantFunction fun = new ConstantFunction(c);
        assertEquals(c,fun.getC());
    }

    @Test
    void apply() {
        double c = 1;
        ConstantFunction fun = new ConstantFunction(c);
        assertEquals(c, fun.apply(100));
    }
    @Test
    void apply2() {
        double c = 456.346;
        ConstantFunction fun = new ConstantFunction(c);
        assertEquals(c, fun.apply(.456346));
    }
    @Test
    void apply3() {
        double c = 345746.3565;
        ConstantFunction fun = new ConstantFunction(c);
        assertEquals(c, fun.apply(235.35747));
    }
}