package comparable_comparator;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
	public static void main(String a[]) {
		Comparator<Integer> c = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}

		};
		PriorityQueue<Integer> p = new PriorityQueue<Integer>((a1, a2) -> ((Integer) a2).compareTo((Integer) a1));
		p.add(23);
		p.add(2);
		p.add(45);
		p.add(-1);
		while (!p.isEmpty()) {
			System.out.print(p.poll() + " ");
		}

	}
}
