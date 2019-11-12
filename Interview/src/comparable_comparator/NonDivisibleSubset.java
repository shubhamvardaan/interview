package comparable_comparator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NonDivisibleSubset {

	static boolean notSum(List<Integer> list, int k) {
		int length = list.size();
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if ((list.get(i) + list.get(i)) % k == 0)
					return false;
			}
		}
		return false;
	}

	static int nonDivisibleSubset(int k, List<Integer> s) {
		HashSet<List<Integer>> set = new HashSet<>();
		List<Integer> tempList = new ArrayList<>();
		for (int i = 0; i < s.size(); i++) {
			for (int j = i; j < s.size(); j++) {
				tempList.add(s.get(j));
				if (!set.contains(tempList))
					set.add(new ArrayList(tempList));
			}
			tempList.clear();
		}
		int currLen = -1;
		int maxLen = Integer.MIN_VALUE;
		for (List<Integer> list : set) {
			if (notSum(list, k))
				currLen = list.size();
			if (maxLen < currLen)
				maxLen = currLen;
		}
		return maxLen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(7);
		list.add(2);
		list.add(4);
		System.out.println(nonDivisibleSubset(3, list));
	}
}
