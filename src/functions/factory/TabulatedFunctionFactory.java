package functions.factory;

import functions.MathFunction;
import functions.TabulatedFunction;

public interface TabulatedFunctionFactory {
    TabulatedFunction create(double[] xValues, double[] yValues);
    public TabulatedFunction create(MathFunction function, double xFrom, double xTo, int count);
}
