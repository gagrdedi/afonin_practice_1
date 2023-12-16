package functions.factory;

import functions.ArrayTabulatedFunction;
import functions.LinkedListTabulatedFunction;
import functions.MathFunction;
import functions.TabulatedFunction;

public class ArrayTabulatedFunctionFactory implements TabulatedFunctionFactory{

    @Override
    public TabulatedFunction create(double[] xValues, double[] yValues) {
        return new ArrayTabulatedFunction(xValues, yValues);
    }
    @Override
    public TabulatedFunction create(MathFunction function, double xFrom, double xTo, int count) {
        return new LinkedListTabulatedFunction( function,  xFrom,  xTo,  count);
    }
}
