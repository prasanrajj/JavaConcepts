package MutliThreading;

class MyThread extends Thread {

    @Override
    public void run() {
        // Code executed by this thread
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                Thread.currentThread().getName() + " is running - " + i
            );
        }
    }
}

class test{
	// Main thread
    System.out.println("Main thread: " + Thread.currentThread().getName());

    // Creating multiple threads
    MyThread t1 = new MyThread();
    MyThread t2 = new MyThread();
    MyThread t3 = new MyThread();

    // Starting threads (new threads are created here)
    t1.start();
    t2.start();
    t3.start();

    // Main thread work
    for (int i = 1; i <= 5; i++) {
        System.out.println(
            Thread.currentThread().getName() + " executing - " + i
        );
    }
}

public class MultiThreadDemo {

    public static void main(String[] args) {

        // Main thread
        System.out.println("Main thread: " + Thread.currentThread().getName());

        // Creating multiple threads
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        // Starting threads (new threads are created here)
        t1.start();
        t2.start();
        t3.start();

        // Main thread work
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                Thread.currentThread().getName() + " executing - " + i
            );
        }
    }
}

