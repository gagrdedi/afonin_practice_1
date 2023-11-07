package operations;

import exceptions.InconsistentFunctionException;
import functions.Point;
import functions.TabulatedFunction;
import functions.factory.ArrayTabulatedFunctionFactory;
import functions.factory.TabulatedFunctionFactory;


public class TabulatedFunctionOperationService {
private interface BiOperation {double apply(double u, double v);}

    TabulatedFunctionFactory factory;
    public TabulatedFunctionOperationService(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }
    public TabulatedFunctionOperationService() {
        factory = new ArrayTabulatedFunctionFactory();
    }
    public void setFactory(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    public TabulatedFunctionFactory getFactory() {
        return factory;
    }

    private TabulatedFunction doOperation(TabulatedFunction fun1, TabulatedFunction fun2, BiOperation operation){
        if(fun1.getCount() != fun2.getCount()) throw new InconsistentFunctionException();

        Point[] p1 = asPoints(fun1);
        Point[] p2 = asPoints(fun2);
        double[] xValues = new double[fun1.getCount()];
        double[] yValues = new double[fun1.getCount()];
        for(int i = 0; i < fun1.getCount(); i++){

            if(p1[i].x != p2[i].x) throw new InconsistentFunctionException();
            xValues[i] = p1[i].x;
            yValues[i] = operation.apply(p1[i].y, p2[i].y);

        }
        return factory.create(xValues, yValues);
    }

    public static Point[] asPoints(TabulatedFunction tabulatedFunction){
        int i = 0;
        Point[] p = new Point[tabulatedFunction.getCount()];
        for(Point itVar : tabulatedFunction){
            p[i] = itVar;
            i++;
        }
        return p;
    }

    public TabulatedFunction plus(TabulatedFunction fun1, TabulatedFunction fun2) throws InconsistentFunctionException{
        BiOperation B = new BiOperation() {
            @Override
            public double apply(double p1, double p2) {
                return p1+p2;
            }
        };
        return doOperation(fun1, fun2, B);

    }

    public TabulatedFunction minus(TabulatedFunction fun1, TabulatedFunction fun2) throws InconsistentFunctionException{
       BiOperation B = new BiOperation() {
           @Override
           public double apply(double p1, double p2) {
               return p1-p2;
           }
       };
        return doOperation(fun1, fun2, B);

    }

    public TabulatedFunction multiply(TabulatedFunction fun1, TabulatedFunction fun2) throws InconsistentFunctionException{
        BiOperation B = new BiOperation() {
            @Override
            public double apply(double p1, double p2) {
                return p1*p2;
            }
        };
        return doOperation(fun1, fun2, B);

    }
    public TabulatedFunction divide(TabulatedFunction fun1, TabulatedFunction fun2) throws InconsistentFunctionException{
        BiOperation B = new BiOperation() {
            @Override
            public double apply(double p1, double p2) {
                return (double)p1/p2;
            }
        };
        return doOperation(fun1, fun2, B);

    }

}
