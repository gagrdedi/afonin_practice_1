package operations;

import functions.ArrayTabulatedFunction;
import functions.LinkedListTabulatedFunction;
import functions.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TabulatedFunctionOperationServiceTest {
    @Test
    void asPointTest1(){
        double[] x = {0, 1, 2};
        double[] y = {3, 4, 5};
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(x, y);
        Point[] p = TabulatedFunctionOperationService.asPoints(fun);
        for (int i = 0; i < p.length; i++){
            assertEquals(p[i].x, x[i]);
            assertEquals(p[i].y, y[i]);
        }
    }
@Test
    void asPointTest2(){
        double[] x = {0, 1, 2};
        double[] y = {7, 8, 9};
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
        Point[] p = TabulatedFunctionOperationService.asPoints(fun);
        for (int i = 0; i < p.length-1; i++){
            assertEquals(p[i].x, x[i]);
            assertEquals(p[i].y, y[i]);
        }
    }

}
