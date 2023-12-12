package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractTabulatedFunctionTest {

    double[] x = {0, 1, 2};
    double[] y = {3, 4, 5};
    @Test
    void testToString() {
        ArrayTabulatedFunction fun1 = new ArrayTabulatedFunction(x, y);
        LinkedListTabulatedFunction fun2 = new LinkedListTabulatedFunction(x, y);
        assertEquals("ArrayTabulatedFunction size = 3\n[0.0; 3.0]\n[1.0; 4.0]\n[2.0; 5.0]", fun1.toString());
        assertEquals("LinkedListTabulatedFunction size = 3\n[0.0; 3.0]\n[1.0; 4.0]\n[2.0; 5.0]", fun2.toString());
    }
}