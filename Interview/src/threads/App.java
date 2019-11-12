package threads;

public class App {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ReentrantLock r = new ReentrantLock();
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				try {
					r.firstThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				try {
					r.secondThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();

		r.finished();
	}

}
