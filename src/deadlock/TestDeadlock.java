package deadlock;

class DeadlockThread extends Thread {

    private Thread otherThread;

    public void setOtherThread(Thread otherThread) {
        this.otherThread = otherThread;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " started");
            
            // DEADLOCK POINT 🔥
            otherThread.join();

            System.out.println(Thread.currentThread().getName() + " ended");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class TestDeadlock {

    public static void main(String[] args) {

        DeadlockThread t1 = new DeadlockThread();
        DeadlockThread t2 = new DeadlockThread();

        t1.setName("T1");
        t2.setName("T2");

        // Circular dependency 🔁
        t1.setOtherThread(t2);
        t2.setOtherThread(t1);

        t1.start();
        t2.start();

        System.out.println("Main thread finished");
    }
}
