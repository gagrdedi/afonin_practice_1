package operations;

import functions.Point;
import functions.TabulatedFunction;
import functions.factory.TabulatedFunctionFactory;

public class TabulatedFunctionOperationService {

    public static Point[] asPoints(TabulatedFunction tabulatedFunction){
        int i = 0;
        Point[] p = new Point[tabulatedFunction.getCount()];
        for(Point itVar : tabulatedFunction){
            p[i] = itVar;
            i++;
        }
        return p;
    }

}
