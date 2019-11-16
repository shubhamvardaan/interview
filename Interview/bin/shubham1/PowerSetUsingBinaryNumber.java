package shubham1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PowerSetUsingBinaryNumber {

	static List<String> generatePowerSet(List<String> list, String str) {
		String s = "";
		List<String> powerSet = new LinkedList<>();
		for (String t : list) {
			for (int i = 0; i < t.length(); i++) {
				if (t.charAt(i) == '1') {
					s = s + str.charAt(i);
				}
			}
			if (s.isEmpty())
				powerSet.add("{}");
			else
				powerSet.add(s);
			s = "";
		}
		return powerSet;
	}

	static void print(List<String> results) {
		//Collections.sort(results);
		for (String s : results) {
			System.out.print(s+"  ");
		}
	}

	public static void main(String[] args) {
		String str = "ABCD";
		List<String> ll = GenerateAllBinaryNumber.generate(str.length());
		print(generatePowerSet(ll, str));
	}
}
