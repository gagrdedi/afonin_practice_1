package functions;

import exceptions.ArrayIsNotSortedException;
import exceptions.DifferentLengthOfArraysException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        double[] x1 = {0, 1, 2, 5};
        double[] y1 = {4, 5, 7, 5};

        double[] x2 = {0, 1, 2, 5};
        double[] y2 = {4, 5, 7, 5};

        ArrayTabulatedFunction fun1 = new ArrayTabulatedFunction(x1, y1);
        ArrayTabulatedFunction fun2 = new ArrayTabulatedFunction(x2, y2);
        assertEquals(true, fun1.equals(fun2));
    }

    @Test
    void equals2() {
        double[] x1 = {0, 1, 2, 3};
        double[] y1 = {4, 6, 7, 5};

        double[] x2 = {0, 1, 2, 4};
        double[] y2 = {4, 5, 7, 5};

        ArrayTabulatedFunction fun1 = new ArrayTabulatedFunction(x1, y1);
        ArrayTabulatedFunction fun2 = new ArrayTabulatedFunction(x2, y2);
        assertEquals(false, fun1.equals(fun2));
    }

    @Test
    void hashCode1() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 5};
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(x, y);
        assertEquals(281768835, fun.hashCode());
    }

    @Test
    void clone1() throws CloneNotSupportedException{
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 5};
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(x, y);
        assertEquals(fun, fun.clone());
    }

    void checkLengthIsTheSamePT() throws DifferentLengthOfArraysException {
        double[] x = {0, 1, 2, 1};
        double[] y = {4, 5, 6, 5};
        AbstractTabulatedFunction.checkLengthIsTheSame(x, y);
    }

@Test
    void checkLengthIsTheSameNT() throws DifferentLengthOfArraysException {
        double[] x = {0, 1, 2, 1};
        double[] y = {4, 5, 6};
        DifferentLengthOfArraysException Ex = assertThrows( DifferentLengthOfArraysException.class, () -> {AbstractTabulatedFunction.checkLengthIsTheSame(x, y);});
        assertEquals("Length is not equal", Ex.getMessage());
    }
@Test
    void checkSortedNT() throws ArrayIsNotSortedException {
        double[] x = {0, 1, 5, 3};
        ArrayIsNotSortedException Ex = assertThrows(ArrayIsNotSortedException.class, () -> {AbstractTabulatedFunction.checkSorted(x);});
        assertEquals("Not sorted", Ex.getMessage());
    }

    @Test
    void iteratorT1() throws UnsupportedOperationException
    {
        double[] x = {0, 1, 2};
        double[] y = {3, 4, 5};
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(x, y);
        Iterator<Point> iterator = fun.iterator();
        int i = 0;
        while(iterator.hasNext()) {
            Point point = iterator.next();
            assertEquals(point.x, x[i]);
            assertEquals(point.y, y[i]);
            i++;
        }
    }

    @Test
    void iteratorT2() {
        double[] x = {0, 1, 2};
        double[] y = {3, 4, 5};
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(x, y);
        int i = 0;
        for (Point point : fun) {
            assertEquals(point.x, x[i]);
            assertEquals(point.y, y[i]);
            i++;
        }
    }
}