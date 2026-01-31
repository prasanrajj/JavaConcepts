package threadcreationviarunnable;

class FileProcessingTask implements Runnable {

	private final String taskName;

	FileProcessingTask(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public void run() {
		System.out.println("Task: " + taskName + " running on thread: " + 
		Thread.currentThread().getName());

		try {
			Thread.sleep(1000); // simulate heavy work
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Task: " + taskName + " completed on thread: " + 
		Thread.currentThread().getName());
	}
}

public class RunnableThreadDemo {
	public static void main(String[] args) {

		// Creating tasks (logic only)
		Runnable task1 = new FileProcessingTask("Chunk-1");
		Runnable task2 = new FileProcessingTask("Chunk-2");
		Runnable task3 = new FileProcessingTask("Chunk-3");

		// Creating threads (execution only)
		Thread t1 = new Thread(task1, "Worker-1");
		Thread t2 = new Thread(task2, "Worker-2");
		Thread t3 = new Thread(task3, "Worker-3");

		// Starting threads
		t1.start();
		t2.start();
		t3.start();
	}
}
