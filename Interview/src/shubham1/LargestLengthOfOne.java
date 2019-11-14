package shubham1;

import java.util.ArrayList;
import java.util.List;

public class LargestLengthOfOne {

	static String getBinaryNumber(int number) {
		String result = "";
		while (number > 0) {
			result = +number % 2 + result;
			number = number / 2;
		}
		return result;
	}

	static int largestLength(int number) {
		String bn = getBinaryNumber(number);
		int count = 0;
		List<Integer> index = new ArrayList<>();
		for (int i = 0; i < bn.length(); i++) {
			if (bn.charAt(i) == '0')
				index.add(i);
		}
		if (bn.length() == 1)
			return 1;
		int maxLength = Integer.MIN_VALUE;
		int length = -1;
		int i;
		for (i = 1; i < index.size(); i++) {
			if (count == 0) {
				length = index.get(i);
				count++;
			} else {
				if (i + 1 < index.size() && 0 <= i - 1)
					length = index.get(i + 1) - index.get(i - 1) - 1;
			}
			if (maxLength < length)
				maxLength = length;
		}
		i--;
		if (index.size() == 1)
			return bn.length();
		int lastLength = bn.length() - index.get(i - 1) - 1;

		return lastLength > maxLength ? lastLength : maxLength;
	}

	public static void main(String[] args) {
		System.out.println(largestLength(1));
	}
}
