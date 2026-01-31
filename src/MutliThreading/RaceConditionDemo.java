package MutliThreading;

public class RaceConditionDemo {
	// Shared resource
	static class Counter {
		private int count = 0;

		// synchronized method (critical section)
		public synchronized void increment() {
//			 synchronized (this) {
//	                count++;
//	            }
			count++; // thread-safe now
		}

		public int getCount() {
			return count;
		}
	}

	// Thread class
	static class WorkerThread extends Thread {
		private Counter counter;

		public WorkerThread(Counter counter, String name) {
			super(name);
			this.counter = counter;
		}

		@Override
		public void run() {
			for (int i = 1; i <= 10000; i++) {
				counter.increment();
			}
			System.out.println(getName() + " finished execution");
		}
	}

	// Main method
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main started");
		Counter counter = new Counter(); // ONE shared object
		// threads created
		WorkerThread t1 = new WorkerThread(counter, "Thread-1");
		WorkerThread t2 = new WorkerThread(counter, "Thread-2");
		// t1 and t2 started
		t1.start();
		t2.start();
		// main waits for both threads
		t1.join();
		t2.join();
		// main done
		System.out.println("Main ended");
		System.out.println("Final Counter Value = " + counter.getCount());
	}
}
