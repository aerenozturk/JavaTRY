# Java Multithreading Experiments

This repository contains various Java programs demonstrating the usage of multithreading and synchronization mechanisms. Each example explores different concepts such as thread synchronization, Reentrant Locks, and Read-Write Locks.

## Files and Descriptions

### 1. `ReentrantLockEx.java`
- Demonstrates the usage of `ReentrantLock` for controlled access to shared resources.
- Includes methods for reading, writing, and appending to shared data in a thread-safe manner.

### 2. `SoccerGame.java`
- Simulates a soccer game where players pass the ball to each other using threads.
- Implements thread synchronization using `wait()` and `notify()`.

### 3. `SynchronizedCounter.java`
- A synchronized counter example that increments or decrements a shared counter.
- Features multiple threads making concurrent requests with controlled access.

### 4. `firstExp.java`
- A simple example using `ReentrantLock` to increment a shared counter across multiple threads.
- Ensures thread safety while incrementing the counter.

### 5. `secondExp.java`
- Explores the `ReentrantReadWriteLock` for read-write synchronization.
- Simulates concurrent read and write operations on a shared variable.

## How to Run

1. Clone the repository:
    ```bash
    git clone https://github.com/aerenozturk/JavaTRY.git
    cd JavaTRY
    ```

2. Compile the desired file:
    ```bash
    javac <filename>.java
    ```

3. Run the compiled file:
    ```bash
    java JavaTRY.<ClassName>
    ```

## Key Concepts Covered

- Thread synchronization (`synchronized`, `ReentrantLock`, `ReentrantReadWriteLock`)
- Thread creation and management
- Inter-thread communication (`wait()`, `notify()`)
- Handling race conditions in concurrent programs

## License

This project is open-source and available under the [MIT License](LICENSE).
