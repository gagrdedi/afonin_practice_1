package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompositeFunctionTest {
    @Test
    void apply() {
        IdentityFunction fun1 = new IdentityFunction();
        SqrFunction fun2 = new SqrFunction();
        CompositeFunction fun = new CompositeFunction(fun1, fun2);
        assertEquals(25, fun.apply(5));
    }

    @Test
    void apply2() {
        IdentityFunction fun1 = new IdentityFunction();
        SqrFunction fun2 = new SqrFunction();
        CompositeFunction fun = new CompositeFunction(fun1, fun2);
        fun = new CompositeFunction(fun, fun2);
        assertEquals(625, fun.apply(5));
    }
}