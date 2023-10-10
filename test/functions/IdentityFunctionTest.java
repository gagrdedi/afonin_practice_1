package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IdentityFunctionTest {

    @Test
    void apply() {
        IdentityFunction fun = new IdentityFunction();
        assertEquals(1, fun.apply(1));
    }
    @Test
    void apply2() {
        IdentityFunction fun = new IdentityFunction();
        assertEquals(38.18, fun.apply(38.18));
    }
    @Test
    void apply3() {
        IdentityFunction fun = new IdentityFunction();
        assertEquals(74.064, fun.apply(74.064));
    }
}