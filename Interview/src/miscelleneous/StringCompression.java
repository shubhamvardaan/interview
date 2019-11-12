package miscelleneous;

public class StringCompression {

	static String stringCompress(String s) {
		String str = "";
		int len = s.length();
		int count = 1;

		int noOfChar = 1;

		while (count < len) {
			if (s.charAt(count - 1) == s.charAt(count)) {
				noOfChar = noOfChar + 1;
			} else {

				str = str + s.charAt(count - 1) + noOfChar;
				noOfChar = 1;
			}
			count++;
		}
		str = str + s.charAt(count - 1) + noOfChar;
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabcccccaaab";
		System.out.println(stringCompress(s));
	}

}
