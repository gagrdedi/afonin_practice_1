package operations;

import concurrent.SynchronizedTabulatedFunction;
import functions.MathFunction;
import functions.Point;
import functions.TabulatedFunction;
import functions.factory.ArrayTabulatedFunctionFactory;
import functions.factory.TabulatedFunctionFactory;

public class TabulatedDifferentialOperator implements DifferentialOperator<TabulatedFunction> {
    private TabulatedFunctionFactory factory;

    public TabulatedDifferentialOperator(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }
    public TabulatedDifferentialOperator() {
        factory = new ArrayTabulatedFunctionFactory();
    }
    public TabulatedFunctionFactory getFactory() {
        return factory;
    }

    public void setFactory(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }
    @Override
    public TabulatedFunction derive(TabulatedFunction function) {
        Point[] points = TabulatedFunctionOperationService.asPoints(function);
        double[] xValues = new double[points.length];
        double[] yValues = new double[points.length];
        for (int i = 1; i < points.length; i++){
            xValues[i] = points[i].x;
            yValues[i] = (double)(points[i].y - points[i-1].y) / (double)(points[i].x - points[i-1].x);
        }
        xValues[0] = xValues[1];
        yValues[0] = yValues[1];
        return factory.create(xValues, yValues);
    }

    public SynchronizedTabulatedFunction deriveSynchronously (TabulatedFunction function){
        SynchronizedTabulatedFunction synchronizedFunction = (function instanceof SynchronizedTabulatedFunction) ?
                (SynchronizedTabulatedFunction) function :
                new SynchronizedTabulatedFunction(function);

        return synchronizedFunction.doSynchronously(func -> new SynchronizedTabulatedFunction(derive(func)));
    }
}
