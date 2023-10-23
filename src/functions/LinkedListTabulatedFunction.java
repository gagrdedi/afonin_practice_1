package functions;

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
            if (!(o instanceof LinkedListTabulatedFunction.Node)) return false;
            if (((Node) o).x != x) return false;
            if (((Node) o).y != y) return false;
            if (((Node) o).next != next) return false;
            if (((Node) o).prev != prev) return false;
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
    public LinkedListTabulatedFunction(double[] xValues, double[] yValues){
        for (int i = 0; i < xValues.length; i++)
            this.addNode(xValues[i], yValues[i]);
    }
    public LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count){
        double step = (xTo-xFrom)/(count-1);
        if (step < 0) step *= -1;
        for (int i = 0; i < count; i++) {
            double x = xFrom + step * i;
            addNode(x, source.apply(x));
        }
    }

    @Override
    protected int floorIndexOfX(double x) {
        int i;
        Node node = head;
        for (i = 0; x > node.x && i < count; i++, node = node.next);
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
    public double getX(int index) {
        int i;
        Node node = head;
        for (i = index; i != 0; i--){
            node = node.next;
        }
        return node.x;
    }

    @Override
    public double getY(int index) {
        int i;
        Node node = head;
        for (i = index; i != 0; i--){
            node = node.next;
        }
        return node.y;
    }

    @Override
    public void setY(int index, double value) {
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
}
