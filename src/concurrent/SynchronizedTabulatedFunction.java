package concurrent;

import functions.Point;
import functions.TabulatedFunction;
import operations.TabulatedFunctionOperationService;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SynchronizedTabulatedFunction implements TabulatedFunction {
    private final TabulatedFunction function;
    public SynchronizedTabulatedFunction(TabulatedFunction fun) {
        function = fun;
    }

    @Override
    public double apply(double x) {
        synchronized (function) {
            return function.apply(x);
        }
    }

    @Override
    public int getCount() {
        synchronized (function) {
            return function.getCount();
        }
    }

    @Override
    public double getX(int index) {
        synchronized (function) {
            return function.getX(index);
        }
    }

    @Override
    public double getY(int index) {
        synchronized (function) {
            return function.getY(index);
        }
    }

    @Override
    public void setY(int index, double value) {
        synchronized (function) {
            function.setY(index, value);
        }
    }

    @Override
    public int indexOfX(double x) {
        synchronized (function) {
            return function.indexOfX(x);
        }
    }

    @Override
    public int indexOfY(double y) {
        synchronized (function) {
            return function.indexOfY(y);
        }
    }

    @Override
    public double leftBound() {
        synchronized (function) {
            return function.leftBound();
        }
    }

    @Override
    public double rightBound() {
        synchronized (function) {
            return function.rightBound();
        }
    }

    @Override
    public Iterator<Point> iterator() {
        synchronized (function) {
            Point[] points = TabulatedFunctionOperationService.asPoints(function);
            return new Iterator<Point>() {
                int i = 0;
                @Override
                public boolean hasNext() {
                    return (i < points.length);
                }

                @Override
                public Point next() {
                    Point p = points[i];
                    if (!hasNext()) throw new NoSuchElementException();
                    i++;
                    return p;
                }
            };
        }
    }

    public interface Operation<T> {
        T apply(SynchronizedTabulatedFunction func);
    }

    public <T> T doSynchronously(Operation<T> operation) {
        synchronized (function) {
            return operation.apply(this);
        }
    }
}
