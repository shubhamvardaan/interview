package threads;

import java.util.concurrent.Semaphore;

class Shubham {
	int n;
	Semaphore con = new Semaphore(0);
	Semaphore prod = new Semaphore(1);

	void get() {
		try {
			con.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Got " + n);
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
		System.out.println("Put " + n);
		con.release();
	}
}

class Producer1 implements Runnable {

	Shubham s;

	Producer1(Shubham s) {
		this.s = s;
	}

	public void run() {

		for (int i = 1; i < 15; i++)
			s.put(i);
	}

}

class Consumer1 implements Runnable {

	Shubham s;

	Consumer1(Shubham s) {
		this.s = s;
	}

	public void run() {

		for (int i = 1; i < 15; i++)
			s.get();
	}

}

public class SemaPhoreConProd {
	public static void main(String[] args) {
		Shubham s = new Shubham();
		new Thread(new Consumer1(s), "Consumer1").start();
		new Thread(new Producer1(s), "Producer1").start();
	}
}
