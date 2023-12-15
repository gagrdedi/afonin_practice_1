package concurrent;

import functions.TabulatedFunction;

public class WriteTask implements Runnable{
    private TabulatedFunction function;
    private double value;
    public WriteTask(TabulatedFunction fun, double val) {
        function = fun;
        value = val;
    }
    @Override
    public void run() {
        for (int i = 0; i < function.getCount(); i++) {
            function.setY(i, value);
            String string = String.format("Writing for index %d complete", i);
            System.out.println(string);
        }
    }
}
