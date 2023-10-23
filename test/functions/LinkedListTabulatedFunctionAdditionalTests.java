package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
}
