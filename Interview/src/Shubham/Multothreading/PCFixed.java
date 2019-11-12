package Shubham.Multothreading;

class Q1 {
	int n;
	boolean valueSet;

	synchronized int get() {
		while (!valueSet)
			try {
				wait();
			} catch (Exception e) {
				System.out.println("Exception caught");
			}
		System.out.println("Got : " + n);
		valueSet = false;
		notify();
		return n;
	}

	synchronized void put(int n) {
		while (valueSet)
			try {
				wait();
			} catch (Exception e) {
				System.out.println("Exception caught");
			}
		this.n = n;
		valueSet = true;
		System.out.println("put : " + n);
		notify();
	}
}

class Producer1 implements Runnable {
	Q1 q;

	Producer1(Q1 q) {
		this.q = q;
		new Thread(this, "Producer").start();

	}

	public void run() {
		int i = 0;
		while (true) {
			q.put(i++);
		}
	}

}

class Consumer1 implements Runnable {
	Q1 q;

	Consumer1(Q1 q) {
		this.q = q;
		new Thread(this, "Consumer").start();

	}

	public void run() {
		while (true) {
			q.get();
		}
	}

}

public class PCFixed {
	public static void main(String args[]) {
		Q1 q = new Q1();
		new Producer1(q);
		new Consumer1(q);
	}
}
