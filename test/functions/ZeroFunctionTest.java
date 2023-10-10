package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZeroFunctionTest {

    @Test
    void getC() {
        ZeroFunction fun = new ZeroFunction();
        assertEquals(0, fun.getC());
    }

    @Test
    void apply() {
        ZeroFunction fun = new ZeroFunction();
        assertEquals(0, fun.apply(1));
    }
    @Test
    void apply2() {
        ZeroFunction fun = new ZeroFunction();
        assertEquals(0, fun.apply(.456345));
    }
    @Test
    void apply3() {
        ZeroFunction fun = new ZeroFunction();
        assertEquals(0, fun.apply(1984.46345));
    }
}