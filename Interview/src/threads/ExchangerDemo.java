package threads;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<String>();
		new Thread(new UseString(exchanger)).start();
		new Thread(new MakeString(exchanger)).start();
	}
}

class MakeString implements Runnable {
	Exchanger<String> exchanger;
	String str;

	MakeString(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
		str = new String();
	}

	@Override
	public void run() {
		char ch = 'A';
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++)
				str += ch++;
			try {
				str = exchanger.exchange(str);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

class UseString implements Runnable {
	Exchanger<String> exchanger;
	String str;

	public UseString(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			try {
				str = exchanger.exchange(new String());
				System.out.println("Got : " + str);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}