package shubham1;

import java.util.HashMap;

public class NumberOfSolutionforbooleanexpr {
	static boolean stringtoBoolean(String str) {
		if (str.equals("1"))
			return true;
		return false;
	}

	static int getTotalNumber(String str, boolean result, HashMap<String, Integer> memo) {
		if (str.length() == 0)
			return 0;
		if (str.length() == 1)
			return result == stringtoBoolean(str) ? 1 : 0;
		if (memo.containsKey(result + str))
			return memo.get(result + str);
		int ways = 0;
		for (int i = 1; i < str.length(); i += 2) {
			char c = str.charAt(i);
			String left = str.substring(0, i);
			String right = str.substring(i + 1, str.length());
			int leftTrue = getTotalNumber(left, true, memo);
			int leftFalse = getTotalNumber(left, false, memo);
			int rightTrue = getTotalNumber(right, true, memo);
			int rightFalse = getTotalNumber(right, false, memo);

			int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

			int trueTotal = 0;
			if (c == '&') {
				trueTotal = leftTrue * rightTrue;
			} else if (c == '|')
				trueTotal = leftTrue * rightTrue + rightTrue * leftFalse + leftTrue * rightFalse;
			else if (c == '^')
				trueTotal = rightTrue * leftFalse + leftTrue * rightFalse;
			int tempTotal = result ? trueTotal : total - trueTotal;
			ways += tempTotal;

		}
		memo.put(result + str, ways);

		return ways;
	}

	public static void main(String[] args) {
		HashMap<String, Integer> shubham = new HashMap<String, Integer>();
		System.out.println(getTotalNumber("0&0&0&1^1|0", true, shubham));
	}
}
