//Implement readers writers problem using Threads in java

class SharedResource {
    int readers = 0;
    boolean writing = false;

    public synchronized void startReading() throws InterruptedException {
        while (writing) {
            wait();
        }
        readers++;
    }

    public synchronized void stopReading() {
        readers--;
        if (readers == 0) {
            notify();
        }
    }

    public synchronized void startWriting() throws InterruptedException {
        while (readers > 0 || writing) {
            wait();
        }
        writing = true;
    }

    public synchronized void stopWriting() {
        writing = false;
        notify();
    }
}
class Reader extends Thread {
    private SharedResource resource;

    public Reader(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        try {
            resource.startReading();
            System.out.println("Reader " + Thread.currentThread().getId() + " is reading.");
            Thread.sleep(1000);
            resource.stopReading();
            System.out.println("Reader " + Thread.currentThread().getId() + " has finished reading.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Writer extends Thread {
    private SharedResource resource;

    public Writer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        try {
            resource.startWriting();
            System.out.println("Writer " + Thread.currentThread().getId() + " is writing.");
            Thread.sleep(1000);
            resource.stopWriting();
            System.out.println("Writer " + Thread.currentThread().getId() + " has finished writing.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class PG32ReadersWritersProblem {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        for (int i = 0; i < 5; i++) {
            new Reader(resource).start();
            new Writer(resource).start();
        }
    }
}