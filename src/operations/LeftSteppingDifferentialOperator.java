package operations;

import functions.MathFunction;

public class LeftSteppingDifferentialOperator extends SteppingDifferentialOperator{

    public LeftSteppingDifferentialOperator(double step) {
        super(step);
    }

    @Override
    public MathFunction derive(MathFunction fun) {
        return new MathFunction() {
            @Override
            public double apply(double x) {
                return (fun.apply(x) - fun.apply(x-step))/step;
            }
        };
    }

}
