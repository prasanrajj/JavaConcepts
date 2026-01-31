package MutliThreading;
class Counter {
	int count = 0;

	public void increment() {
		count++; // NOT thread-safe
	}
}

class WorkerThread extends Thread {
	private Counter counter;

	public WorkerThread(Counter counter, String name) {
		super(name);
		this.counter = counter;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			counter.increment();
			System.out.println(Thread.currentThread().getName() + " count = " + counter.count);
		}
		System.out.println("done------------------------->" + Thread.currentThread().getName());
	}
}

public class Test {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Main started");

		Counter counter = new Counter();

		WorkerThread t1 = new WorkerThread(counter, "T1");
//		WorkerThread t2 = new WorkerThread(counter, "T2");

		t1.start();
//		t2.start();

		t1.join();
//		t2.join();

		System.out.println("Main ended");
	}
}
