package recursion;

public class REcursion_7 {

	static int strLengthRecur(String str, int len) {
		try {
			if (new Character(str.charAt(len)) == null) {
			}

		} catch (StringIndexOutOfBoundsException e) {
			return len;
		}
		return strLengthRecur(str, len + 1);
	}

	static int strLength(String str) {
		int len = 0;
		return strLengthRecur(str, len);
	}

	public static void main(String[] args) {
		System.out.println(strLength("ab"));

	}

}
