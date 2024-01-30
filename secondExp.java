package KurwaCoTam;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class secondExp {
    private int number = 0;
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    // Method to increment the number
    public void incrementNumber() {
        rwLock.writeLock().lock(); // Acquire the write lock
        try {
            number++;
            System.out.println("Number incremented to: " + number);
        } finally {
            rwLock.writeLock().unlock(); // Release the write lock
        }
    }

    // Method to get the number
    public int getNumber() {
        rwLock.readLock().lock(); // Acquire the read lock
        try {
            System.out.println("Number read as: " + number);
            return number;
        } finally {
            rwLock.readLock().unlock(); // Release the read lock
        }
    }

    public static void main(String[] args) {
        secondExp example = new secondExp();

        // Thread for incrementing the number
        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                example.incrementNumber();
                try {
                    Thread.sleep(100); // Sleep to simulate some processing
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Thread for reading the number
        Thread readThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                example.getNumber();
                try {
                    Thread.sleep(50); // Sleep to simulate some processing
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        incrementThread.start();
        readThread.start();
    }
}

