package threads;

class test3 {
	int count = 0;

	public  void increment() {
		count++;
	}
}

public class SychronizeKey {

	public static void main(String[] args) throws Exception {
		test3 test = new test3();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					test.increment();
				}
			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					test.increment();
				}
			}

		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Value of count is " + test.count);
	}
}
