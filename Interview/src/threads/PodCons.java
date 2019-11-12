package threads;

import java.util.concurrent.Semaphore;

class test7 {
	int n;
	static Semaphore con = new Semaphore(0);
	static Semaphore prod = new Semaphore(1);

	void get() {
		try {
			con.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Got : " + n);
		prod.release();
	}

	void put(int n) {
		try {
			prod.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.n = n;
		System.out.println("Put : " + n);
		con.release();
	}
}

class consumer implements Runnable {
	test7 t;

	consumer(test7 t) {
		this.t = t;
		new Thread(this, "consumer").start();
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			t.get();
		}
	}
}

class producer implements Runnable {
	test7 t;

	producer(test7 t) {
		this.t = t;
		new Thread(this, "producer").start();
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			t.put(i);
		}
	}
}

public class PodCons {

	public static void main(String[] args) {
		test7 t = new test7();
		new producer(t);
		new consumer(t);
	}
}