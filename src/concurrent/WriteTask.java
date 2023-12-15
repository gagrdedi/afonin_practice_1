package concurrent;

import functions.TabulatedFunction;

public class WriteTask implements Runnable{
    private final TabulatedFunction function;
    private final double value;
    public WriteTask(TabulatedFunction fun, double val) {
        function = fun;
        value = val;
    }
    @Override
    public void run() {
        synchronized (function) {
            for (int i = 0; i < function.getCount(); i++) {
                function.setY(i, value);
                String string = String.format("Writing for index %d complete", i);
                System.out.println(string);
            }
        }
    }
}
