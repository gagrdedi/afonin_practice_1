package functions;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayTabulatedFunctionTest {

    @Test
    void apply() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(x, y);
        assertEquals(6, fun.apply(2));
    }

    @Test
    void apply2() {
        SqrFunction fun1 = new SqrFunction();
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(fun1, 0, 1, 20);
        assertEquals(0.64, fun.apply(0.8), 0.001);
    }

    @Test
    void floorIndexOfX() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(x, y);
        assertEquals(1, fun.floorIndexOfX(1.5467634));
    }

    @Test
    void extrapolateLeft() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(x, y);
        assertEquals(-0.25, fun.apply(-4.25));
    }

    @Test
    void extrapolateRight() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(x, y);
        assertEquals(361.4574, fun.apply(357.4574));
    }

    @Test
    void interpolate() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(x, y);
        assertEquals(6.5, fun.apply(2.5));
    }

    @Test
    void getCount() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(x, y);
        assertEquals(4, fun.getCount());
    }

    @Test
    void getX() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(x, y);
        assertEquals(1, fun.getX(1));
    }

    @Test
    void getY() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(x, y);
        assertEquals(7, fun.getY(3));
    }

    @Test
    void setY() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(x, y);
        assertEquals(7, fun.getY(3));
        fun.setY(3, 8);
        assertEquals(8, fun.getY(3));
    }

    @Test
    void indexOfX() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(x, y);
        assertEquals(1, fun.indexOfX(1));
    }

    @Test
    void indexOfY() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(x, y);
        assertEquals(1, fun.indexOfY(5));
    }

    @Test
    void leftBound() {
        SqrFunction fun1 = new SqrFunction();
        ArrayTabulatedFunction fun2 = new ArrayTabulatedFunction(fun1, 0, 1, 10 );
        assertEquals(0, fun2.leftBound());
    }

    @Test
    void rightBound() {
        SqrFunction fun1 = new SqrFunction();
        ArrayTabulatedFunction fun2 = new ArrayTabulatedFunction(fun1, 0, 1, 10 );
        assertEquals(1, fun2.rightBound());
    }

    @Test
    void toString1() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(x, y);
        assertEquals("ArrayTabulatedFunction{xValues=[0.0, 1.0, 2.0, 3.0], yValues=[4.0, 5.0, 6.0, 7.0], count=4}", fun.toString());
    }
    @Test
    void equals1() {
        double[] x1 = {0, 1, 2, 1};
        double[] y1 = {4, 5, 7, 5};

        double[] x2 = {0, 1, 2, 1};
        double[] y2 = {4, 5, 7, 5};

        ArrayTabulatedFunction fun1 = new ArrayTabulatedFunction(x1, y1);
        ArrayTabulatedFunction fun2 = new ArrayTabulatedFunction(x2, y2);
        assertEquals(true, fun1.equals(fun2));
    }

    @Test
    void equals2() {
        double[] x1 = {0, 1, 2, 1};
        double[] y1 = {4, 6, 7, 5};

        double[] x2 = {0, 1, 2, 1};
        double[] y2 = {4, 5, 7, 5};

        ArrayTabulatedFunction fun1 = new ArrayTabulatedFunction(x1, y1);
        ArrayTabulatedFunction fun2 = new ArrayTabulatedFunction(x2, y2);
        assertEquals(false, fun1.equals(fun2));
    }

    @Test
    void hashCode1() {
        double[] x = {0, 1, 2, 1};
        double[] y = {4, 5, 6, 5};
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(x, y);
        assertEquals(233010051, fun.hashCode());
    }

    @Test
    void clone1() throws CloneNotSupportedException{
        double[] x = {0, 1, 2, 1};
        double[] y = {4, 5, 6, 5};
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(x, y);
        assertEquals(fun, fun.clone());
    }
}