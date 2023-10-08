package function;

import java.lang.Math;
public class CtgFunction implements MathFunction{
    @Override
    public double apply(double x) {
        return Math.cos(x)/Math.sin(x);
    }
}
