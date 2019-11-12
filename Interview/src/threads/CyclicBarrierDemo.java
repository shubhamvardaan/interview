package threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class MyThread1 implements Runnable {

	CyclicBarrier cyclic;
	String name;

	public MyThread1(CyclicBarrier cyclic, String name) {
		this.cyclic = cyclic;
		this.name = name;
	}

	public void run() {
		try {
			System.out.println(name);
			cyclic.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Action implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("this is shubham vardaan");
	}

}

public class CyclicBarrierDemo {
	public static void main(String[] args) {
		CyclicBarrier cyclic = new CyclicBarrier(3, new Action());
		System.out.println("Start......");
		new Thread(new MyThread1(cyclic, "A")).start();
		new Thread(new MyThread1(cyclic, "B")).start();
		new Thread(new MyThread1(cyclic, "C")).start();
		new Thread(new MyThread1(cyclic, "A1")).start();
		new Thread(new MyThread1(cyclic, "B1")).start();
		new Thread(new MyThread1(cyclic, "C1")).start();
		new Thread(new MyThread1(cyclic, "A2")).start();
		new Thread(new MyThread1(cyclic, "B2")).start();
		new Thread(new MyThread1(cyclic, "C2")).start();
		new Thread(new MyThread1(cyclic, "A3")).start();
	}
}
