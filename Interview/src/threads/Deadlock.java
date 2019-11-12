package threads;

public class Deadlock {
	public static Object lock1 = new Object();
	public static Object lock2 = new Object();

	public static void main(String[] a) {
		Thread t1 = new Thread1();
		Thread t2 = new Thread2();
		t1.start();
		t2.start();
	}

	private static class Thread1 extends Thread {
		public void run() {
			synchronized (lock1) {
				System.out.println("Thread 1 : holding lock 1....");
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				synchronized (lock2) {
					System.out.println("Thread 2 : holding lock 1 & 2.... ");
				}
			}

		}
	}

	private static class Thread2 extends Thread {
		public void run() {
			synchronized (lock2) {
				System.out.println("Thread 2 : holding lock 2....");
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				synchronized (lock1) {
					System.out.println("Thread 2 : holding lock 1 & 2.... ");
				}
			}
		}
	}

}
