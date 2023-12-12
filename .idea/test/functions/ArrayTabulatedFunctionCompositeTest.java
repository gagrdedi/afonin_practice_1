package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTabulatedFunctionCompositeTest {
    @Test
    void compositeTest(){
        double[] x = {0, 1, 2, 3, 4};
        double[] y = {5, 6, 7, 8, 9};
        SqrFunction fun1 = new SqrFunction();
        ArrayTabulatedFunction fun2 = new ArrayTabulatedFunction(x, y);
        CompositeFunction fun = new CompositeFunction(fun1, fun2);
        assertEquals(9, fun.apply(2));
    }
    @Test
    void compositeTest2() {
        double[] x1 = {0, 1, 2, 3, 4};
        double[] y1 = {5, 6, 7, 8, 9};
        ArrayTabulatedFunction fun1 = new ArrayTabulatedFunction(x1, y1);
        double[] x2 = {3, 4, 8, 9, 10};
        double[] y2 = {.945, .3465, .097, .124, .72453};
        ArrayTabulatedFunction fun2 = new ArrayTabulatedFunction(x2, y2);
        CompositeFunction fun = new CompositeFunction(fun1, fun2);
        assertEquals(.097, fun.apply(3));
    }
}