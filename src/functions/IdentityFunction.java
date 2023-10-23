package functions;

public class IdentityFunction implements MathFunction{
    @Override
    public double apply(double x) {
        return x;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof IdentityFunction;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
