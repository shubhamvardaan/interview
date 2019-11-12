package threads;

import java.util.LinkedList;
import java.util.Random;

class test6 {
	LinkedList<Integer> list = new LinkedList<>();
	int LIST_SIZE = 10;
	Object object = new Object();
	int value = 0;

	public void producer() throws InterruptedException {
		while (true) {
			synchronized (object) {
				while (list.size() == LIST_SIZE) {
					object.wait();
				}
				list.add(value++);
				object.notify();
			}

		}
	}

	public void consumer() throws InterruptedException {
		Random random = new Random();
		while (true) {
			synchronized (object) {
				while (list.size() == 0) {
					object.wait();
				}

				System.out.println("Size of list :" + list.size());
				int value = list.removeFirst();
				System.out.println("Value :" + value);
				object.notify();
			}
			Thread.sleep(random.nextInt(1000));
		}

	}
}

public class ProCon {

	public static void main(String args[]) {
		test6 test = new test6();
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
	}
}
