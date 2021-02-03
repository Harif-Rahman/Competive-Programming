package multithreading;

public class DeadLockUsingJoin {

    /**
     * DEAD LOCK CASE
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hai");
                try {
                    Thread.currentThread().join();
                    System.out.println("waiting for ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("done");
    }
}
