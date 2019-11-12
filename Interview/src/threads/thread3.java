package threads;

class test2 implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(i++);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

public class thread3 {

	public static void main(String args[]) {
		Thread t1 = new Thread(new test2());
		t1.start();
	}
}
