package operations;

import functions.MathFunction;

public class RightSteppingDifferentialOperator extends SteppingDifferentialOperator {

    public RightSteppingDifferentialOperator(double step) {
        super(step);
    }


    @Override
    public MathFunction derive(MathFunction fun) {
        return new MathFunction() {
            @Override
            public double apply(double x) {
                return (fun.apply(x + step) - fun.apply(x)) / step;
            }
        };
    }
}