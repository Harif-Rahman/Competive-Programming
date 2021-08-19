package multithreading;

public class ProducerConsumer1 {

    public static void main(String[] args) {
        Data data = new Data();
        new Thread(new Producer(data)).start();
        new Thread(new Consumer(data)).start();
    }

    static class Data {
        int val;
        boolean isProducer = true;

        public synchronized void setData(int val) {
            while (!isProducer) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.val = val;
            isProducer = false;
            notify();
        }
        public synchronized int getData(){
           while (isProducer){
               try {
                   wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
           isProducer = true;
           notify();
           return val;
        }
    }
   static class Producer implements Runnable{
       Data data;

       public Producer(Data data) {
           this.data = data;
       }
       @Override
       public void run(){
           int i=1;
           while (true){
               System.out.println("produced -->> "+i);
               data.setData(i++);
               try {
                   Thread.sleep(500L);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }
   }
    static class Consumer implements Runnable{
        Data data;

        public Consumer(Data data) {
            this.data = data;
        }
        @Override
        public void run(){
            while (true){
                System.out.println("consumed -->> "+data.getData());
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
