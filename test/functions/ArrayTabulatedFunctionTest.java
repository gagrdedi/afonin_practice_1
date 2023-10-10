package functions;

import org.junit.jupiter.api.Test;

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
}