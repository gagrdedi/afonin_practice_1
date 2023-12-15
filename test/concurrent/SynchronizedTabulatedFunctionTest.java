package concurrent;

import functions.LinkedListTabulatedFunction;
import functions.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SynchronizedTabulatedFunctionTest {
    double[] x = {0, 1, 2};
    double[] y = {3, 4, 5};

    LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
    SynchronizedTabulatedFunction function = new SynchronizedTabulatedFunction(fun);
    @Test
    void apply() {
        assertEquals(3, function.apply(0));
        assertEquals(4, function.apply(1));
        assertEquals(5, function.apply(2));
    }

    @Test
    void getCount() {
        assertEquals(3, function.getCount());
    }

    @Test
    void getX() {
        assertEquals(0, function.getX(0));
        assertEquals(1, function.getX(1));
        assertEquals(2, function.getX(2));
    }

    @Test
    void getY() {
        assertEquals(3, function.getY(0));
        assertEquals(4, function.getY(1));
        assertEquals(5, function.getY(2));
    }

    @Test
    void setY() {
        function.setY(0, 6);
        function.setY(1, 7);
        function.setY(2, 8);
        assertEquals(6, function.getY(0));
        assertEquals(7, function.getY(1));
        assertEquals(8, function.getY(2));
    }

    @Test
    void indexOfX() {
        assertEquals(0, function.indexOfX(0));
        assertEquals(1, function.indexOfX(1));
        assertEquals(2, function.indexOfX(2));
    }

    @Test
    void indexOfY() {
        assertEquals(0, function.indexOfY(3));
        assertEquals(1, function.indexOfY(4));
        assertEquals(2, function.indexOfY(5));
    }

    @Test
    void leftBound() {
        assertEquals(0, function.leftBound());
    }

    @Test
    void rightBound() {
        assertEquals(2, function.rightBound());
    }

    @Test
    void iterator() {
        int i = 0;
        for (Point p: function) {
            assertEquals(x[i], p.x);
            assertEquals(y[i], p.y);
            i++;
        }
    }
}