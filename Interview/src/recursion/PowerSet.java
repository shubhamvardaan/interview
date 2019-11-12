package recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PowerSet {

	static void generateStringUtil(Character[] ch, int n, int k, Set<String> list) {
		if (k == n) {
			list.add(Arrays.toString(ch));
			return;
		}
		if (ch[n - 1] == '0') {
			ch[n] = '0';
			generateStringUtil(ch, n + 1, k, list); 
			ch[n] = '1';
			generateStringUtil(ch, n + 1, k, list);
		}
		if (ch[n - 1] == '1') {
			ch[n] = '1';
			generateStringUtil(ch, n + 1, k, list);
			ch[n] = '0';
			generateStringUtil(ch, n + 1, k, list);
		}
	}

	static Set<String> generateString(int k) {
		if (k <= 0)
			return null;
		Character[] ch = new Character[k];
		int n = 1;
		Set<String> list = new HashSet<>();
		ch[0] = '0';
		generateStringUtil(ch, n, k, list);
		ch[0] = '1';
		generateStringUtil(ch, n, k, list);
		return list;

	}

	static void printPowerSet(String str) {
		Set<String> set = generateString(str.length());
		StringBuilder str2 = new StringBuilder("");
		for (String str1 : set) {
			for (int i = 0; i < str1.length(); i = i + 2) {
				if (str1.charAt(i) == 1) {
					str2 = str2.append(new StringBuilder(str.charAt(i)));
				}
			}
			System.out.print(str2 + "  ");
			str2 = new StringBuilder("");
		}
	}

	public static void main(String[] args) {
		printPowerSet("abc");
	}
}
