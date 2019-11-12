package miscelleneous;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
	public static void main(String[] args) {
		PriorityQueue<Integer> p = new PriorityQueue<>();
		p.add(1);
		p.add(23);
		p.add(100);
		p.add(102);
		p.add(21);

		while (!p.isEmpty())
			System.out.print(p.poll() + " ");
		PriorityQueue<String> p1 = new PriorityQueue<>();
		p1.add("shubham");
		p1.add("vardaan");
		p1.add("ankur");
		p1.add("hyderabad");
		System.out.println();
		while (!p1.isEmpty()) {
			System.out.println(p1.remove() + " ");
		}

	}

}
