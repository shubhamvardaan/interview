package comparable_comparator;

import java.util.HashSet;

public class Set {

	static int findAllPrem(String source, String input) {
		HashSet<Character> set = new HashSet<>();
		int sourceLen = source.length();
		int inputLen = input.length();

		for (int i = 0; i < inputLen; i++)
			set.add(input.charAt(i));
		int allPerm = 0;
		int wordCount;
		for (int i = 0; i <= sourceLen - inputLen; i++) {
			wordCount = 0;
			for (int j = 0; j < inputLen; j++) {
				if (set.contains(source.charAt(i + j)))
					wordCount = wordCount + 1;
			}
			if (wordCount == inputLen)
				allPerm = allPerm + 1;
		}
		return allPerm;
	}

	public static void main(String args[]) {
		String source = "adbcabcad";
		String input = "abc";
		System.out.println(findAllPrem(source, input));
	}
}
