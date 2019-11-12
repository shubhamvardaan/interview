package recursion;

import java.util.Arrays;

public class Recursion_2 {

	static void generateStringUtil(String str, Character[] ch, int k, int n) {
		if (n == k) {
			System.out.println(Arrays.toString(ch));
			return;

		}
		for (int i = 0; i < str.length(); i++) {
			if (ch[n - 1] == str.charAt(i)) {
				for (int i1 = 0; i1 < str.length(); i1++) {
					ch[n] = str.charAt(i1);
					generateStringUtil(str, ch, k, n + 1);
				}
			}
		}
	}

	static void generateString(String str, int k) {
		if (k <= 0)
			return;
		Character[] ch = new Character[k];
		for (int i = 0; i < str.length(); i++) {
			ch[0] = str.charAt(i);
			generateStringUtil(str, ch, k, 1);
		}
	}

	public static void main(String[] args) {

		String str = "abccc";
		generateString(str, 5000);
	}

}
