package threads;

import java.util.concurrent.CountDownLatch;

class MyThread implements Runnable {
	CountDownLatch latch;

	MyThread(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			latch.countDown();
		}
	}

}

public class CountDownLatchDemo {
	public static void main(String[] args) {
		CountDownLatch cd1 = new CountDownLatch(5);
		System.out.println("Starting.");
		new Thread(new MyThread(cd1)).start();
		try {
			cd1.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done");
	}
}
