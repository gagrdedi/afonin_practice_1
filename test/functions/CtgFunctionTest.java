package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CtgFunctionTest {

    @Test
    void apply() {
        CtgFunction fun = new CtgFunction();
        double num = 1;
        assertEquals((1/Math.tan(num)), fun.apply(num));
    }
    @Test
    void apply2() {
        CtgFunction fun = new CtgFunction();
        double num = .73457;
        assertEquals((1/Math.tan(num)), fun.apply(num));
    }
    @Test
    void apply3() {
        CtgFunction fun = new CtgFunction();
        double num = 125.753;
        assertEquals((1/Math.tan(num)), fun.apply(num));
    }
}