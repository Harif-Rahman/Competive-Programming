package multithreading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class FizzBuzzMultiThreaded1195 {

    class FizzBuzz {
        private int n;
        Semaphore three = new Semaphore(0);
        Semaphore five = new Semaphore(0);
        Semaphore threeFive = new Semaphore(0);
        Semaphore others = new Semaphore(1);
        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for(int i=3;i<=n;i+=3){
                if(i % 5 != 0){
                    three.acquire();
                    printFizz.run();
                    others.release();
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for(int i=5;i<=n;i+=5){
                if(i % 3 != 0){
                    five.acquire();
                    printBuzz.run();
                    others.release();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for(int i=15;i<=n;i+=15){
                threeFive.acquire();
                printFizzBuzz.run();
                others.release();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for(int i=1;i<=n;i++){
                others.acquire();
                if(i % 15 == 0){
                    threeFive.release();
                }else{
                    if(i % 3 == 0){
                        three.release();
                    }else{
                        if(i % 5 == 0){
                            five.release();
                        }else{
                            printNumber.accept(i);
                            others.release();
                        }
                    }
                }
            }
        }
    }

}
