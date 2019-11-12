package threads;

public class ThreadD extends Thread {
	ResourceLock lock;

	ThreadD(ResourceLock lock) {
		this.lock = lock;
	}

	public void run() {
		synchronized (lock) {
			try {
				for (int i = 0; i < 100; i++) {
					while (lock.flag != 4)
						lock.wait();
					System.out.print("D ");
					Thread.sleep(1000);
					lock.flag = 1;
					lock.notify();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
