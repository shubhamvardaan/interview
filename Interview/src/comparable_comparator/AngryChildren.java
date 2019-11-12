package comparable_comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AngryChildren {

	static class test {
		long sum = 0;
	}

	static long sumRecur(List<Integer> list, test t) {
		if (list.size() == 1)
			return t.sum;

		int ele = list.get(0);
		list.remove(0);
		int last = list.get(list.size() - 1);
		Iterator itr = list.iterator();
		int temp = -1;
		List<Integer> list1 = new ArrayList<>();
		while (itr.hasNext()) {
			temp = (int) itr.next();
			t.sum += Math.abs(ele - temp);
			list1.add(Math.abs(ele - temp));
			if (last == temp)
				break;
		}
		return sumRecur(list1, t);
	}

	static long sum(int[] arr, int low, int high, test t) {
		List<Integer> list = new ArrayList<>();
		for (int i = low; i <= high; i++)
			list.add(arr[i]);
		return sumRecur(list, t);

	}

	static long angryChildren(int k, int[] packets) {
		Arrays.sort(packets);
		int length = packets.length;
		long minSum = Integer.MAX_VALUE;
		test t = new test();
		for (int i = 0; i < length - k; i++) {
			long currSum = sum(packets, i, i + k - 1, t);
			if (currSum < minSum)
				minSum = currSum;
			t.sum = 0;
		}
		return minSum;
	}

	public static void main(String[] args) {
		int[] arr = { 4504, 1520, 5857, 4094, 4157, 3902, 822, 6643, 2422, 7288, 8245, 9948, 2822, 1784, 7802, 3142,
				9739, 5629, 5413, 7232 };
		int k = 10000;
		System.out.println(angryChildren(k, arr));
	}
}
