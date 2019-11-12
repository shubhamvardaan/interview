package dynamicprogramming;

public class CheckStringInterLeaving {
	static boolean checkInterLeaving(String a, String b, String ab) {
		int lenA = a.length();
		int lenB = b.length();
		int lenAB = ab.length();
		if (lenA + lenB != lenAB)
			return false;
		boolean[][] shubham = new boolean[lenA + 1][lenB + 1];
		shubham[0][0] = true;
		for (int i = 1; i <= lenA; i++) {
			if (a.charAt(i - 1) != ab.charAt(i - 1))
				shubham[i][0] = false;
			else
				shubham[i][0] = shubham[i - 1][0];
		}

		for (int j = 1; j <= lenB; j++) {
			if (b.charAt(j - 1) != ab.charAt(j - 1))
				shubham[0][j] = false;
			else
				shubham[0][j] = shubham[0][j - 1];
		}

		for (int i = 1; i <= lenA; i++) {
			for (int j = 1; j <= lenB; j++) {
				if (a.charAt(i - 1) == ab.charAt(i + j - 1) && b.charAt(j - 1) != ab.charAt(i + j - 1)) {
					shubham[i][j] = shubham[i - 1][j];
				} else if (a.charAt(i - 1) != ab.charAt(i + j - 1) && b.charAt(j - 1) == ab.charAt(i + j - 1)) {
					shubham[i][j] = shubham[i][j - 1];
				} else if (a.charAt(i - 1) == ab.charAt(i + j - 1) && b.charAt(j - 1) == ab.charAt(i + j - 1)) {
					shubham[i][j] = shubham[i - 1][j] || shubham[i][j - 1];
				} else
					shubham[i][j] = false;
			}
		}

		return shubham[lenA][lenB];
	}

	public static void main(String[] args) {
		String a = "abc";
		String b = "xy2";
		String ab = "xabyc1";
		System.out.println("String are interleaving :" + checkInterLeaving(a, b, ab));
	}
}
