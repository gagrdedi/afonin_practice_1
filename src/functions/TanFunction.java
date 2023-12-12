package functions;

public class TanFunction implements MathFunction{
    @Override
    public double apply(double x) {
        return Math.tan(x);
    }
}

