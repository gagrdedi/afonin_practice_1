package functions;

import java.util.Iterator;

public class LinkedListTabulatedFunction extends AbstractTabulatedFunction{
    static class Node{
        double x;
        double y;
        Node next;
        Node prev;
        public Node(double x, double y){
            this.x = x;
            this.y = y;
            next = this;
            prev = this;
        }
        @Override
        public String toString() {
            return "(" + x + "; " + y + ")";
        }
        @Override
        public int hashCode() {
            return (int)x^(int)y;
        }
        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof LinkedListTabulatedFunction.Node)) return false;
            if (this.hashCode() != o.hashCode()) return false;
            Node node = (Node) o;
            if (node.x != x) return false;
            if (node.y != y) return false;
            return true;
        }

        @Override
        public Object clone() {
            Node node = new Node(x, y);
            node.next = next;
            node.prev = prev;
            return node;
        }
    }
    private Node head;
    private int count;
    private void addNode(double x, double y){
        Node node = new Node(x, y);
        if (head == null) {
            head = node;
            count = 1;
        }
        else {
            node.prev = head.prev;
            node.next = head;
            head.prev.next = node;
            head.prev = node;
            count++;
        }
    }
    public LinkedListTabulatedFunction(double[] xValues, double[] yValues) throws IllegalArgumentException {
        if (xValues.length < 2) throw new IllegalArgumentException("Not enough points");
        for (int i = 0; i < xValues.length; i++)
            this.addNode(xValues[i], yValues[i]);
    }
    public LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) throws IllegalArgumentException {
        if (count < 2) throw new IllegalArgumentException("Not enough points");
        double step = (xTo-xFrom)/(count-1);
        if (step < 0) step *= -1;
        for (int i = 0; i < count; i++) {
            double x = xFrom + step * i;
            addNode(x, source.apply(x));
        }
    }

    @Override
    protected int floorIndexOfX(double x) throws IllegalArgumentException {
        int i;
        Node node = head;
        for (i = 0; x > node.x && i < count; i++, node = node.next);
        if (i == 0) throw new IllegalArgumentException("Out of bounds");
        return i-1;
    }

    @Override
    protected double extrapolateLeft(double x) {
        return interpolate(x, head.x, head.next.x, head.y, head.next.y);
    }

    @Override
    protected double extrapolateRight(double x) {
        return interpolate(x, head.prev.prev.x, head.prev.x, head.prev.prev.y, head.prev.y);
    }

    @Override
    protected double interpolate(double x, int floorIndex) {
        return interpolate(x, getX(floorIndex), getX(floorIndex+1), getY(floorIndex), getY(floorIndex+1));
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public double getX(int index) throws IllegalArgumentException {
        if (index > count || index < 0) throw new IllegalArgumentException("Out of bounds");
        int i;
        Node node = head;
        for (i = index; i != 0; i--){
            node = node.next;
        }
        return node.x;
    }

    @Override
    public double getY(int index) throws IllegalArgumentException {
        if (index > count || index < 0) throw new IllegalArgumentException("Out of bounds");
        int i;
        Node node = head;
        for (i = index; i != 0; i--){
            node = node.next;
        }
        return node.y;
    }

    @Override
    public void setY(int index, double value) throws IllegalArgumentException {
        if (index > count || index < 0) throw new IllegalArgumentException("Out of bounds");
        int i;
        Node node = head;
        for (i = index; i != 0; i--){
            node = node.next;
        }
        node.y = value;
    }

    @Override
    public int indexOfX(double x) {
        Node node = head;
        for (int i = 0; i < count; i++, node = node.next)
            if (x == node.x) return i;
        return -1;
    }

    @Override
    public int indexOfY(double y) {
        Node node = head;
        for (int i = 0; i < count; i++, node = node.next)
            if (y == node.y) return i;
        return -1;
    }

    @Override
    public double leftBound() {
        return head.x;
    }

    @Override
    public double rightBound() {
        return head.prev.x;
    }

    @Override
    public String toString() {
        String out = head.toString();
        for (Node node = head.next; node != head; node = node.next)
            out += node.toString();
        return out;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedListTabulatedFunction)) return false;
        if (this.hashCode() != o.hashCode()) return false;
        LinkedListTabulatedFunction list = (LinkedListTabulatedFunction) o;
        if (list.count != count) return false;
        Node node1 = head;
        Node node2 = list.head;
        do {
            if (!node1.equals(node2)) return false;
            node1 = node1.next;
            node2 = node2.next;
        } while (node1 != head);
        return true;
    }
    @Override
    public int hashCode() {
        int hash = head.hashCode();
        for (Node node = head.next; node != head; node = node.next) {
            hash = hash ^ node.hashCode();
        }
        return hash;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        double[] x = new double[count];
        double[] y = new double[count];
        Node node = head;
        for (int i = 0; i < count; i++, node = node.next) {
            x[i] = node.x;
            y[i] = node.y;
        }
        return new LinkedListTabulatedFunction(x, y);
    }
    @Override
    public Iterator<Point> iterator() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
