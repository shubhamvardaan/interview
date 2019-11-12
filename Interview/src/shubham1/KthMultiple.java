package shubham1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthMultiple {

	static List<Integer> getList(int k) {
		List<Integer> list = new ArrayList<>();
		int value;

		for (int a = 0; a <= k; a++) {
			int A = (int) Math.pow(3, a);
			for (int b = 0; b <= k; b++) {
				int B = (int) Math.pow(5, b);
				for (int c = 0; c <= k; c++) {
					int C = (int) Math.pow(7, c);
					value = A * B * C;
					if (value < 0 || A == Integer.MAX_VALUE || B == Integer.MAX_VALUE || C == Integer.MAX_VALUE)
						value = Integer.MAX_VALUE;
					list.add(value);
				}

			}
		}
		Collections.sort(list);
		return list;
	}

	static void printList(List<Integer> list) {
		for (int x : list) {
			System.out.print(x + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printList(getList(5));
	}

}
