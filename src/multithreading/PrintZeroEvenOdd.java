package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class PrintZeroEvenOdd {
    class ZeroEvenOdd {
        private int n;
        Semaphore zero = new Semaphore(1);
        Semaphore even = new Semaphore(0);
        Semaphore odd = new Semaphore(0);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i<=n; i++) {
                zero.acquire();
                printNumber.accept(0);
                if (i % 2 == 0) {
                    even.release();
                } else {
                    odd.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i<=n; i=i+2) {
                even.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i<=n; i=i+2) {
                odd.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }
    }
}
