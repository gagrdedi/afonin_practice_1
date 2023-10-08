package function;

public class ConstantFunction implements MathFunction{
    private final double C;

    public ConstantFunction(double c) {
        C = c;
    }
    public double getC() {
        return C;
    }
    @Override
    public double apply(double x) {
        return C;
    }
}
