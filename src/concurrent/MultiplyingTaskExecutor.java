package concurrent;

import functions.LinkedListTabulatedFunction;
import functions.UnitFunction;

import java.util.ArrayList;
import java.util.Iterator;

public class MultiplyingTaskExecutor {
    public static void main(String[] args) throws InterruptedException {

        LinkedListTabulatedFunction funL = new LinkedListTabulatedFunction(new UnitFunction(), 1, 1024, 1024);

        ArrayList<Thread> AL = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            MultiplyingTask task = new MultiplyingTask(funL);
            Thread thread = new Thread(task, "Thread №" + i);
            AL.add(thread);
        }

        for (Thread thread1 : AL) {
            thread1.start();
        }


        while (!AL.isEmpty()) {
            Iterator<Thread> it = AL.iterator();
            while (it.hasNext()) {
                if (!it.next().isAlive()) it.remove();
            }
        }
        System.out.println(funL);
    }
}
