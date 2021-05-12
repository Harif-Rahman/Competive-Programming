package multithreading;

import java.util.concurrent.Semaphore;

/*

Suppose we have a class:

public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second()
 */
public class PrintInOrder1114 {
    class Foo {

        Semaphore sec = new Semaphore(0);
        Semaphore third = new Semaphore(0);
        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            sec.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            sec.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            third.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            third.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
