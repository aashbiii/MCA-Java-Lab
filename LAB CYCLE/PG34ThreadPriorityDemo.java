// Thread class
class PriorityThread extends Thread {

    PriorityThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() +
                    " | Priority: " + getPriority() +
                    " | Count: " + i);
        }
    }
}

// Main class
class PG34ThreadPriorityDemo {
    public static void main(String[] args) {

        PriorityThread t1 = new PriorityThread("Low Priority Thread");
        PriorityThread t2 = new PriorityThread("Normal Priority Thread");
        PriorityThread t3 = new PriorityThread("High Priority Thread");

        // Setting priorities
        t1.setPriority(Thread.MIN_PRIORITY);   // 1
        t2.setPriority(Thread.NORM_PRIORITY);  // 5
        t3.setPriority(Thread.MAX_PRIORITY);   // 10

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }
}

