package threads;

public class ThreadTest {
	private static boolean ready;
	private static int number;

	private static class shubham extends Thread {
		public void run() {
			while (!ready)
				Thread.yield();
			System.out.println(number);
		}
	}

	public static void main(String[] args) {
		new shubham().start();
		number = 42;
		ready = true;
	}

}
