package functions.factory;

import functions.ArrayTabulatedFunction;
import functions.LinkedListTabulatedFunction;
import functions.TabulatedFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTabulatedFunctionFactoryTest {
    double[] x = {0, 1, 2, 3};
    double[] y = {4, 5, 6, 7};
    LinkedListTabulatedFunctionFactory listFactory = new LinkedListTabulatedFunctionFactory();
    ArrayTabulatedFunctionFactory arrayFactory = new ArrayTabulatedFunctionFactory();
    TabulatedFunction fun1 = listFactory.create(x, y);
    TabulatedFunction fun2 = arrayFactory.create(x, y);
    @Test
    void createList() {
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
        assertEquals(fun1, fun);
    }
    @Test
    void createList2() {
        assertTrue(fun1 instanceof LinkedListTabulatedFunction);
    }
    @Test
    void createArray() {
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(x, y);
        assertEquals(fun2, fun);
    }
    @Test
    void createArray2() {
        assertTrue(fun2 instanceof ArrayTabulatedFunction);
    }
}