

package threads;

import java.util.Scanner;

class test5 {
	public void producer() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer thread running....");
			wait();
			System.out.println("Resumed.");
		}
	}

	public void consumer() throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Thread.sleep(5000);
		synchronized (this) {
			System.out.println("Waiting for return key.");
			scanner.nextLine();
			
			System.out.println("Return key pressed.");
			notify();
		}
	}
}

public class WaitNotify {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		test5 test = new test5();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					test.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					test.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();

	}

}
