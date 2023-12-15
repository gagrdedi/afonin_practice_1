package concurrent;

import functions.TabulatedFunction;

public class ReadTask implements Runnable{
    private TabulatedFunction function;
    public ReadTask(TabulatedFunction fun) {
        function = fun;
    }
    @Override
    public void run() {
        for (int i = 0; i < function.getCount(); i++)
            System.out.format("After read: i = %d, x = %f, y = %f", i, function.getX(i), function.getY(i));
    }
}
