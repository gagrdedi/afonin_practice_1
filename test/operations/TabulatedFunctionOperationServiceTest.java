package operations;

import functions.ArrayTabulatedFunction;
import functions.LinkedListTabulatedFunction;
import functions.Point;
import functions.TabulatedFunction;
import functions.factory.ArrayTabulatedFunctionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TabulatedFunctionOperationServiceTest {
    double[] x = {0, 1, 2};
    double[] y = {3, 4, 5};
    double[] z = {6, 7, 8};

    @Test
    void asPointTest1(){
        ArrayTabulatedFunction fun = new ArrayTabulatedFunction(x, y);
        Point[] p = TabulatedFunctionOperationService.asPoints(fun);
        for (int i = 0; i < p.length; i++){
            assertEquals(p[i].x, x[i]);
            assertEquals(p[i].y, y[i]);
        }
    }
@Test
    void asPointTest2(){
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(x, y);
        Point[] p = TabulatedFunctionOperationService.asPoints(fun);
        for (int i = 0; i < p.length-1; i++){
            assertEquals(p[i].x, x[i]);
            assertEquals(p[i].y, y[i]);
        }
    }

    @Test
    void plusTest1(){
        LinkedListTabulatedFunction fun1 = new LinkedListTabulatedFunction(x, y);
        ArrayTabulatedFunction fun2 = new ArrayTabulatedFunction(x, z);
        TabulatedFunctionOperationService service = new TabulatedFunctionOperationService(new ArrayTabulatedFunctionFactory());
        TabulatedFunction fun3 = service.plus(fun1, fun2);
        double[] yz = new double[3];
        for (int i = 0; i < 3; i++)
            yz[i] = y[i] + z[i];
        ArrayTabulatedFunction fun4 = new ArrayTabulatedFunction(x, yz);
        assertEquals(fun3, fun4);
    }
    @Test
    void plusTest2(){
        LinkedListTabulatedFunction fun1 = new LinkedListTabulatedFunction(y, x);
        ArrayTabulatedFunction fun2 = new ArrayTabulatedFunction(y, z);
        TabulatedFunctionOperationService service = new TabulatedFunctionOperationService(new ArrayTabulatedFunctionFactory());
        TabulatedFunction fun3 = service.plus(fun1, fun2);
        double[] xz = new double[3];
        for (int i = 0; i < 3; i++)
            xz[i] = x[i] + z[i];
        ArrayTabulatedFunction fun4 = new ArrayTabulatedFunction(y, xz);
        assertEquals(fun3, fun4);
    }

    @Test
    void minusTest1(){
        LinkedListTabulatedFunction fun1 = new LinkedListTabulatedFunction(x, y);
        ArrayTabulatedFunction fun2 = new ArrayTabulatedFunction(x, z);
        TabulatedFunctionOperationService service = new TabulatedFunctionOperationService(new ArrayTabulatedFunctionFactory());
        TabulatedFunction fun3 = service.minus(fun1, fun2);
        double[] yz = new double[3];
        for (int i = 0; i < 3; i++)
            yz[i] = y[i] - z[i];
        ArrayTabulatedFunction fun4 = new ArrayTabulatedFunction(x, yz);
        assertEquals(fun3, fun4);
    }
    @Test
    void minusTest2(){
        LinkedListTabulatedFunction fun1 = new LinkedListTabulatedFunction(y, x);
        ArrayTabulatedFunction fun2 = new ArrayTabulatedFunction(y, z);
        TabulatedFunctionOperationService service = new TabulatedFunctionOperationService(new ArrayTabulatedFunctionFactory());
        TabulatedFunction fun3 = service.minus(fun1, fun2);
        double[] xz = new double[3];
        for (int i = 0; i < 3; i++)
            xz[i] = x[i] - z[i];
        ArrayTabulatedFunction fun4 = new ArrayTabulatedFunction(y, xz);
        assertEquals(fun3, fun4);
    }

}
