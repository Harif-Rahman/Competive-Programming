package multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class ProducerConsumer {
    public static class Sender implements Runnable {
        private Data data;

        public Sender(Data data) {
            this.data = data;
        }

        // standard constructors

        public void run() {
            String packets[] = {
                    "First packet",
                    "Second packet",
                    "Third packet",
                    "Fourth packet",
                    "End"
            };

            for (String packet : packets) {
                data.send(packet);

                // Thread.sleep() to mimic heavy server-side processing
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
                } catch (InterruptedException e)  {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
    public static class Receiver implements Runnable {
        private Data load;

        public Receiver(Data load) {
            this.load = load;
        }
        // standard constructors

        public void run() {
            for(String receivedMessage = load.receive();
                !"End".equals(receivedMessage);
                receivedMessage = load.receive()) {

                System.out.println(receivedMessage);

                // ...
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
    public static class Data {
        private String packet;

        // True if receiver should wait
        // False if sender should wait
        private boolean transfer = true;

        public synchronized void send(String packet) {
            while (!transfer) {
                try {
                    System.out.println("waiting in sender");
                    wait();
                } catch (InterruptedException e)  {
                    Thread.currentThread().interrupt();
                }
            }
            transfer = false;

            this.packet = packet;
            notifyAll();
        }

        public synchronized String receive() {
            while (transfer) {
                try {
                    System.out.println("waiting in receiver");
                    wait();
                } catch (InterruptedException e)  {
                    Thread.currentThread().interrupt();
                }
            }
            transfer = true;

            notifyAll();
            return packet;
        }
    }
    public static void main(String[] args) {
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();
    }
}
