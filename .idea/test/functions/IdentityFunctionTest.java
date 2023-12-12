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
    @Test
    void toString1(){
        IdentityFunction fun = new IdentityFunction();
        assertEquals("IdentityFunction{}", fun.toString());
    }

    @Test
    void equals(){
        IdentityFunction fun1 = new IdentityFunction();
        IdentityFunction fun2 = new IdentityFunction();
        assertEquals(true, fun1.equals(fun2));
    }

    @Test
    void hashCode1(){
        IdentityFunction fun = new IdentityFunction();
        assertEquals(1, fun.hashCode());
    }

    @Test
    void clone1() throws CloneNotSupportedException {
        IdentityFunction fun = new IdentityFunction();
        assertEquals(fun, fun.clone());
    }
}