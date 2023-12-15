package concurrent;

import functions.ConstantFunction;
import functions.LinkedListTabulatedFunction;

public class ReadWriteTaskExecutor {
    public static void main(String[] args) {
        LinkedListTabulatedFunction fun = new LinkedListTabulatedFunction(new ConstantFunction(-1), 1, 1000, 1000);
        Thread thread1 = new Thread(new ReadTask(fun));
        Thread thread2 = new Thread(new WriteTask(fun, 0.5));
        thread1.start();
        thread2.start();
    }
}
