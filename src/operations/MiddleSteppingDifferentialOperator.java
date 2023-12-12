package operations;

import functions.MathFunction;

public class MiddleSteppingDifferentialOperator extends SteppingDifferentialOperator{

    public MiddleSteppingDifferentialOperator(double step) {
        super(step);
    }

    @Override
    public MathFunction derive(MathFunction fun) {
        return new MathFunction() {
            @Override
            public double apply(double x) {
                return (fun.apply(x + step) - fun.apply(x - step)) / (2 * step);
            }
        };
    }
}
