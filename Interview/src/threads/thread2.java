package threads;

class test extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(i++);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class thread2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		test t = new test();
		test t1 = new test();
		t.start();
		t1.start();
	}

}
