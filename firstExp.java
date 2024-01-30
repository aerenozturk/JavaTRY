package KurwaCoTam;
import java.util.concurrent.locks.ReentrantLock;

public class firstExp {

    private final ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    // Method to increment count
    public void increment() {
        lock.lock(); // Acquire the lock
        try {
            count++;
        } finally {
            lock.unlock(); // Ensure the lock is released
        }
    }

    public static void main(String[] args) {
        firstExp example = new firstExp();

        // Creating two threads that increment the count
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                example.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                example.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            // Waiting for threads to finish
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Threads interrupted");
        }

        // Displaying the final count value
        System.out.println("Final count is: " + example.count);
    }
}

