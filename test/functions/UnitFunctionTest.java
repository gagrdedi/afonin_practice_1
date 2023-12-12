package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnitFunctionTest {

    @Test
    void getC() {
        UnitFunction fun = new UnitFunction();
        assertEquals(1, fun.getC());
    }

    @Test
    void apply() {
        UnitFunction fun = new UnitFunction();
        assertEquals(1, fun.apply(0));
    }
    @Test
    void apply2() {
        UnitFunction fun = new UnitFunction();
        assertEquals(1, fun.apply(.346456));
    }
    @Test
    void apply3() {
        UnitFunction fun = new UnitFunction();
        assertEquals(1, fun.apply(135.23464685));
    }
}