package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SqrFunctionTest {

    @Test
    void apply() {
        SqrFunction fun = new SqrFunction();
        double num = 2;
        assertEquals(num * num, fun.apply(num));
    }
    @Test
    void apply2() {
        SqrFunction fun = new SqrFunction();
        double num = .64;
        assertEquals(num * num, fun.apply(num));
    }
    @Test
    void apply3() {
        SqrFunction fun = new SqrFunction();
        double num = 168.27;
        assertEquals(num * num, fun.apply(num));
    }
}