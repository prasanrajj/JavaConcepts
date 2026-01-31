package threadcreationviarunnable;

//Runnable implementation 1
class FileTask implements Runnable {
	public void run() {
		System.out.println("FileTask running on " + Thread.currentThread().getName());
	}
}

//Runnable implementation 2
class NetworkTask implements Runnable {
	public void run() {
		System.out.println("NetworkTask running on " + Thread.currentThread().getName());
	}
}

//Runnable implementation 3
class DatabaseTask implements Runnable {
	public void run() {
		System.out.println("DatabaseTask running on " + Thread.currentThread().getName());
	}
}

public class RunnablePolymorphismDemo {
	public static void main(String[] args) {

		// ONE interface reference
		Runnable task;

		// Same reference → different objects (runtime polymorphism)
		task = new FileTask();
		new Thread(task, "Worker-1").start();

		task = new NetworkTask();
		new Thread(task, "Worker-2").start();

		task = new DatabaseTask();
		new Thread(task, "Worker-3").start();
		
		System.out.println("MAIN THREAD FINISHED");
	}
}
