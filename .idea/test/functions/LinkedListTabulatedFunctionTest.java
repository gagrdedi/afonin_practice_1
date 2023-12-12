package functions;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LinkedListTabulatedFunctionTest {
    @Test
    void apply() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
        assertEquals(6, fun.apply(2));
    }

    @Test
    void apply2() {
        SqrFunction fun1 = new SqrFunction();
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(fun1, 0, 1, 20);
        assertEquals(0.64, fun.apply(0.8), 0.001);
    }
    @Test
    void floorIndexOfX() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
        assertEquals(1, fun.floorIndexOfX(1.5467634));
    }

    @Test
    void extrapolateLeft() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
        assertEquals(-10.36346, fun.apply(-14.36346));
    }

    @Test
    void extrapolateRight() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
        assertEquals(8, fun.apply(4));
    }

    @Test
    void interpolate() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
        assertEquals(5.75, fun.apply(1.75));
    }

    @Test
    void getCount() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
        assertEquals(4, fun.getCount());
    }

    @Test
    void getX() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
        assertEquals(1, fun.getX(1));
    }

    @Test
    void getY() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
        assertEquals(7, fun.getY(3));
    }

    @Test
    void setY() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
        assertEquals(7, fun.getY(3));
        fun.setY(3, 8);
        assertEquals(8, fun.getY(3));
    }

    @Test
    void indexOfX() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
        assertEquals(1, fun.indexOfX(1));
    }

    @Test
    void indexOfY() {
        double[] x = {0, 1, 2, 3};
        double[] y = {4, 5, 6, 7};
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
        assertEquals(1, fun.indexOfY(5));
    }

    @Test
    void leftBound() {
        SqrFunction fun1 = new SqrFunction();
        LinkedListTabulatedFunction fun2 = new LinkedListTabulatedFunction(fun1, 0, 1, 10 );
        assertEquals(0, fun2.leftBound());
    }

    @Test
    void rightBound() {
        SqrFunction fun1 = new SqrFunction();
        LinkedListTabulatedFunction fun2 = new LinkedListTabulatedFunction(fun1, 0, 1, 10 );
        assertEquals(1, fun2.rightBound());
    }

    @Test
    void compositeTest(){
        double[] x = {3, 4, 7, 8, 9};
        double[] y = {5, 6, 3, 8, 9};
        IdentityFunction fun1 = new IdentityFunction();
        LinkedListTabulatedFunction fun2 = new LinkedListTabulatedFunction(x, y);
        CompositeFunction fun = new CompositeFunction(fun1, fun2);
        assertEquals(5, fun.apply(3));
    }
    @Test
    void compositeTest2() {
        double[] x1 = {3, 4, 5, 8};
        double[] y1 = {1, 3, 5, 7};
        ArrayTabulatedFunction fun1 = new ArrayTabulatedFunction(x1, y1);
        double[] x2 = {3, 4, 6, 9};
        double[] y2 = {.945, .3213, .09, .14};
        LinkedListTabulatedFunction fun2 = new LinkedListTabulatedFunction(x2, y2);
        CompositeFunction fun = new CompositeFunction(fun1, fun2);
        assertEquals(.945, fun.apply(4));
    }

    @Test
    void NodeToString() {
        LinkedListTabulatedFunction.Node node = new LinkedListTabulatedFunction.Node(1.1, 25.3);
        assertEquals("(1.1; 25.3)", node.toString());
    }
    @Test
    void NodeEquals() {
        LinkedListTabulatedFunction.Node node1 = new LinkedListTabulatedFunction.Node(1.1, 25.3);
        LinkedListTabulatedFunction.Node node2 = new LinkedListTabulatedFunction.Node(1.1, 25.3);
        assertEquals(node1, node2);
    }
    @Test
    void NodeHashCode() {
        LinkedListTabulatedFunction.Node node = new LinkedListTabulatedFunction.Node(1.1, 25.3);
        assertEquals(24, node.hashCode());
    }

    @Test
    void NodeClone() throws CloneNotSupportedException {
        LinkedListTabulatedFunction.Node node1 = new LinkedListTabulatedFunction.Node(1.1, 25.3);
        assertEquals(node1, node1.clone());
    }

    /*@Test
    void ListToString() {
        double[] x = {1, 2, 3};
        double[] y = {4, 5, 6};
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
        assertEquals("(1.0; 4.0)(2.0; 5.0)(3.0; 6.0)", fun.toString());
    }*/
    @Test
    void ListEquals() {
        double[] x = {1, 2, 3};
        double[] y = {4, 5, 6};
        LinkedListTabulatedFunction fun1 = new LinkedListTabulatedFunction(x, y);
        LinkedListTabulatedFunction fun2 = new LinkedListTabulatedFunction(x, y);
        assertEquals(fun1, fun2);
    }
    @Test
    void ListHashCode() {
        double[] x = {1, 2, 3};
        double[] y = {4, 5, 6};
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
        assertEquals(7, fun.hashCode());
    }
    @Test
    void ListClone() throws CloneNotSupportedException {
        double[] x = {1, 2, 3};
        double[] y = {4, 5, 6};
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
        assertEquals(fun, fun.clone());
    }
    @Test
    void constructorExceptionTest() {
        double[] x = {1};
        double[] y = {2};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
           LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
        });
        assertEquals("Not enough points", exception.getMessage());
    }
    @Test
    void constructorExceptionSecondTest() {
        SqrFunction fun1 = new SqrFunction();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            LinkedListTabulatedFunction fun2 = new LinkedListTabulatedFunction(fun1, 0, 10, 1);
        });
        assertEquals("Not enough points", exception.getMessage());
    }
    @Test
    void floorIndexOfXExceptionTest() {
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(new SqrFunction(), 0, 1, 5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            fun.floorIndexOfX(-1);
        });
        assertEquals("Out of bounds", exception.getMessage());
    }
    @Test
    void getXExceptionTest() {
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(new SqrFunction(), 0, 1, 5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
           fun.getX(-1);
        });
        assertEquals("Out of bounds", exception.getMessage());
    }
    @Test
    void getXExceptionSecondTest() {
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(new SqrFunction(), 0, 1, 5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            fun.getX(6);
        });
        assertEquals("Out of bounds", exception.getMessage());
    }
    @Test
    void getYExceptionTest() {
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(new SqrFunction(), 0, 1, 5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            fun.getY(-1);
        });
        assertEquals("Out of bounds", exception.getMessage());
    }
    @Test
    void getYExceptionSecondTest() {
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(new SqrFunction(), 0, 1, 5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            fun.getY(6);
        });
        assertEquals("Out of bounds", exception.getMessage());
    }

    @Test
    void iterator() {
        double[] x = {0, 1, 2};
        double[] y = {3, 4, 5};
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
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
    void iterator2() {
        double[] x = {0, 1, 2};
        double[] y = {3, 4, 5};
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
        int i = 0;
        for (Point point : fun) {
            assertEquals(point.x, x[i]);
            assertEquals(point.y, y[i]);
            i++;
        }
    }
}
