package functions;

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
}
