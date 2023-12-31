package functions;

import exceptions.ArrayIsNotSortedException;
import exceptions.DifferentLengthOfArraysException;
import exceptions.InterpolationException;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ArrayTabulatedFunction extends AbstractTabulatedFunction implements Cloneable, Serializable {

    private double[] xValues, yValues;
    @Serial
    private static final long serialVersionUID = 8985759482567066046L;
    private int count;
    public ArrayTabulatedFunction(double[] xValues, double[] yValues) throws DifferentLengthOfArraysException, ArrayIsNotSortedException {
        AbstractTabulatedFunction.checkLengthIsTheSame(xValues, yValues);
        AbstractTabulatedFunction.checkSorted(xValues);
        count = xValues.length;
        this.xValues = Arrays.copyOf(xValues, count);
        this.yValues = Arrays.copyOf(yValues, count);

    }
    public ArrayTabulatedFunction(MathFunction source, double xFrom, double xTo, int count){
        this.count = count;
        xValues = new double[count];
        yValues = new double[count];
        double step = (xTo-xFrom)/(count-1);
        if (step < 0) step *= -1;
        for (int i = 0; i < count; i++){
            xValues[i] = xFrom + step * i;
            yValues[i] = source.apply(xValues[i]);
        }
    }

    @Override
    protected int floorIndexOfX(double x) {
        int i;
        for (i = 0; i < count && x > xValues[i]; i++);
        return i - 1;
    }

    @Override
    protected double extrapolateLeft(double x) {
        return interpolate(x, xValues[0], xValues[1], yValues[0], yValues[1]);
    }

    @Override
    protected double extrapolateRight(double x) {
        return interpolate(x, xValues[count-2], xValues[count-1], yValues[count-2], yValues[count-1]);
    }

    @Override
    protected double interpolate(double x, int floorIndex){
        if(x < getX(floorIndex) || x > getX(floorIndex+1)) throw new InterpolationException("Interpolation exception");
        if (count == 0) return yValues[0];
        return interpolate(x, xValues[floorIndex], xValues[floorIndex+1], yValues[floorIndex], yValues[floorIndex+1]);
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public double getX(int index) {
        return xValues[index];
    }

    @Override
    public double getY(int index) {
        return yValues[index];
    }

    @Override
    public void setY(int index, double value) {
        yValues[index] = value;
    }

    @Override
    public int indexOfX(double x) {
        for (int i = 0; i < count; i++) {
            if (x == xValues[i])
                return i;
        }
        return -1;
    }

    @Override
    public int indexOfY(double y) {
        for (int i = 0; i < count; i++) {
            if (y == yValues[i])
                return i;
        }
        return -1;
    }

    @Override
    public double leftBound() {
        return xValues[0];
    }

    @Override
    public double rightBound() {
        return xValues[count-1];
    }

    /*@Override
    public String toString() {
        return "ArrayTabulatedFunction{" +
                "xValues=" + Arrays.toString(xValues) +
                ", yValues=" + Arrays.toString(yValues) +
                ", count=" + count +
                '}';
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        ArrayTabulatedFunction that = (ArrayTabulatedFunction) o;
        return count == that.count && Arrays.equals(xValues, that.xValues) && Arrays.equals(yValues, that.yValues);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(count);
        result = 31 * result + Arrays.hashCode(xValues);
        result = 31 * result + Arrays.hashCode(yValues);
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    @Override
    public Iterator<Point> iterator() throws UnsupportedOperationException {
        return new Iterator<Point>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < count;
            }

            @Override
            public Point next() {
                Point p = new Point(xValues[i], yValues[i]);
                if (!hasNext()) throw new NoSuchElementException();
                i++;
                return p;
            }
        };

    }
}
