package MutliThreading;

class DataWorker extends Thread {
	
	private String chunkName;

	DataWorker(String chunkName) {
		this.chunkName = chunkName;
		this.setName("Worker-Thread-" + this.getChunkName());
	}

	public String getChunkName() {
		return chunkName;
	}

	public void setChunkName(String chunkName) {
		this.chunkName = chunkName;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " processing chunk " + this.chunkName + "\n");

		try {
			// Simulating DB/file processing
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class MultiThreadingDemo {
	public static void main(String[] args) {

		System.out.println("Main thread: " + Thread.currentThread().getName());
		// Suppose 20 chunks
		for (int i = 1; i <= 20; i++) {
			DataWorker worker = new DataWorker(String.valueOf(i));
			//worker.run(); // new thread created here
			worker.start();//the methods here runs on the same main method
		}
		System.out.println("Main thread finished submitting work");
	}
}
