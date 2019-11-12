package threads;

public class thread1 {

	public static void main(String args[]) {
		Thread t = new Thread(new Runnable() {
			public void run() {

				try {
					for (int i = 0; i < 10; i++) {
						Thread.sleep(1000);
						System.out.println(i);
					}
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		});
		t.start();
	}
}
