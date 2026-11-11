//Implement Producer Consumer problem using Threads in Java.

class SharedMemory {
    int data;
    boolean available = false;

    public synchronized int consume() throws InterruptedException {
        while (!available) {
            wait();
        }
        available = false;
        notify();
        return data;
    }

    public synchronized void produce(int value) throws InterruptedException {
        while (available) {
            wait();
        }
        data = value;
        available = true;
        notify();
    }
}
class Producer extends Thread {
    private SharedMemory s;

    public Producer(SharedMemory s) {
        this.s = s;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("\nProducing: " + i);
            try {
                s.produce(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            
        }
    }
}
class Consumer extends Thread {
    private SharedMemory s;

    public Consumer(SharedMemory s) {
        this.s = s;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            int value;
            try {
                value = s.consume();
                System.out.println("Consuming: " + value);
                Thread.sleep(150);
            } catch (InterruptedException e) {
            }
        }
    }
}
public class PG32ProducerConsumerMain {
    public static void main(String[] args) {
        SharedMemory s = new SharedMemory();
        Producer producer = new Producer(s);
        Consumer consumer = new Consumer(s);

        producer.start();
        consumer.start();
    }
}