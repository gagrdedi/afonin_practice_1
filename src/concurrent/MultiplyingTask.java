package concurrent;

import functions.TabulatedFunction;

public class MultiplyingTask implements Runnable {

    private final TabulatedFunction tabFunc;

    public MultiplyingTask(TabulatedFunction fun) {
        tabFunc = fun;
    }

    @Override
    public void run() {
        for (int i = 0; i < tabFunc.getCount(); i++) {
            synchronized (tabFunc) {
                tabFunc.setY(i, tabFunc.getY(i) * 2);
            }
        }
        System.out.println(Thread.currentThread().getName() + " has ended");
    }
}
