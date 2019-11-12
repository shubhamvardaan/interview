package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class test4 extends Thread {
	int id;

	test4(int id) {
		this.id = id;
	}

	public void run() {
		System.out.println("started .." + id);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed .." + id);
	}
}

public class ThreadPool {
	public static void main(String args[]) {

		ExecutorService executer = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 5; i++) {
			executer.submit(new test4(i));
		}
		executer.shutdown();
	}

}
