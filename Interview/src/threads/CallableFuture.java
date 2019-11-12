package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class shubham1 implements Callable<Integer> {
	int val;

	shubham1(int val) {
		this.val = val;
	}

	public Integer call() {
		int fact = 1;
		for (int i = 1; i <= val; i++)
			fact = fact * i;
		return fact;
	}
}

class shubham2 implements Callable<StringBuilder> {
	String str;

	shubham2(String str) {
		this.str = str;
	}

	public StringBuilder call() {
		return new StringBuilder(str).reverse();
	}
}

class area implements Callable<Double> {
	Double side;

	area(Double side) {
		this.side = side;
	}

	public Double call() {
		return side * side;
	}
}

public class CallableFuture {

	public static void main(String[] args) {
		Future<Integer> f;
		Future<StringBuilder> f1;
		Future<Double> f2;

		ExecutorService executer = Executors.newFixedThreadPool(0);
		System.out.println("Starting...");
		f = executer.submit(new shubham1(10));
		f1 = executer.submit(new shubham2("shubham"));
		f2 = executer.submit(new area(10.0));
		try {
			System.out.println(f.get());
			System.out.println(f1.get());
			System.out.println(f2.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		executer.shutdown();
	}
}
