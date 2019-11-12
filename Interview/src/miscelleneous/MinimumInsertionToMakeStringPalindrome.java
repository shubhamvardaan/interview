package miscelleneous;

public class MinimumInsertionToMakeStringPalindrome {
	static void lps(String str, int[] result) {
		int n = str.length();
		int len = 0;
		int i = 1;
		result[0] = 0;

		while (i < n) {
			if (str.charAt(i) == str.charAt(len)) {
				len++;
				result[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = result[len - 1];
				} else {
					i++;
				}
			}
		}

	}

	static int minimumNoOfInsertionForPalindrome(String str) {

		String rev = new StringBuilder(str).reverse().toString();
		String original = str;
		str = str + "#" + rev;
		int[] result = new int[str.length()];
		lps(str, result);
		int len = result[result.length - 1];
		rev = rev.substring(0, rev.length() - len);
		original = rev + original;
		System.out.println(original);
		return rev.length();
	}

	public static void main(String args[]) {
		String str = "aabba";
		System.out.println(minimumNoOfInsertionForPalindrome(str));
	}
}
