package functions;

import exceptions.ArrayIsNotSortedException;
import exceptions.DifferentLengthOfArraysException;

public abstract class AbstractTabulatedFunction implements TabulatedFunction {
    abstract protected int floorIndexOfX(double x);
    abstract protected double extrapolateLeft(double x);
    abstract protected double extrapolateRight(double x);
    abstract protected double interpolate(double x, int floorIndex);
    protected double interpolate(double x, double leftX, double rightX, double leftY, double rightY) {
        return leftY+(rightY-leftY)/(rightX-leftX)*(x-leftX);
    }

    @Override
    public double apply(double x) {
        if (x<leftBound())
            return extrapolateLeft(x);
        if (x>rightBound())
            return extrapolateRight(x);
        if (indexOfX(x) != -1)
            return getY(indexOfX(x));
        return interpolate(x, floorIndexOfX(x));
    }

    static void checkLengthIsTheSame(double[] xValues, double[] yValues) throws DifferentLengthOfArraysException{
        if(xValues.length != yValues.length) throw new DifferentLengthOfArraysException("Length is not equal");
    }
    static void checkSorted(double[] xValues) throws ArrayIsNotSortedException{
        for(int i = 0; i < xValues.length-1; i++) {
            if(xValues[i] > xValues[i+1]) throw new ArrayIsNotSortedException("Not sorted");
        }

    }
}
