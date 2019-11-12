package recursion;

public class CheckStringIn2dArray {
	static class test {
		int length = 0;
	}

	static final Integer len = 5;
	static char[][] table = { { 'A', 'C', 'P', 'R', 'C' }, { 'X', 'S', 'O', 'P', 'C' }, { 'V', 'O', 'V', 'N', 'I' },
			{ 'W', 'G', 'F', 'M', 'N' }, { 'Q', 'A', 'T', 'I', 'T' } };

	static boolean isSafe(char ch, int x, int y) {
		if (x >= 0 && x < len && y >= 0 && y < len)
			return ch == table[x][y];
		return false;
	}

	static private boolean findMatchUtil(String input, int x, int y, test t) {
		if (t.length == input.length())
			return true;
		if (isSafe(input.charAt(t.length), x, y)) {
			t.length = t.length + 1;
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					if (i == 0 && j == 0)
						continue;
					findMatchUtil(input, x + i, y + j, t);
				}
			}
		}
		return false;
	}

	static boolean findMatch(String input, int length) {
		boolean statuc = false;
		test t = new test();
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++)
				statuc = findMatchUtil(input, i, j, t);
		}
		return statuc;
	}

	public static void main(String[] args) {
		String input = "MICROSOFT2";
		int n = input.length();
		System.out.println(findMatch(input, n));
	}
}
