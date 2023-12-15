package concurrent;

import functions.TabulatedFunction;

public class ReadTask implements Runnable{
    private final TabulatedFunction function;
    public ReadTask(TabulatedFunction fun) {
        function = fun;
    }
    @Override
    public void run() {
        synchronized (function) {
            for (int i = 0; i < function.getCount(); i++) {
                String string = String.format("After read: i = %d, x = %f, y = %f", i, function.getX(i), function.getY(i));
                System.out.println(string);
            }
        }
    }
}
