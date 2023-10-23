package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LinkedListTabulatedFunctionAdditionalTests {
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

    @Test
    void ListToString() {
        double[] x = {1, 2, 3};
        double[] y = {4, 5, 6};
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
        assertEquals("(1.0; 4.0)(2.0; 5.0)(3.0; 6.0)", fun.toString());
    }
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
}
