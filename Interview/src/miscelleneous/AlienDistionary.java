package miscelleneous;

import java.util.LinkedList;
import java.util.List;

public class AlienDistionary {

	static void alienOrder(String[] dist) {
		List<Character> temp = new LinkedList<>();
		Integer index = null;
		for (String word : dist) {
			for (int i = 0; i < word.length(); i++) {
				if (temp.contains(word.charAt(i)))
					continue;
				if (i < word.length() - 1 && temp.contains(word.charAt(i + 1)))
					index = word.indexOf(word.charAt(i + 1));
				if (index == null)
					temp.add(word.charAt(i));
				else
					temp.add(index, word.charAt(i));
			}
		}
		System.out.println(temp.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] dist = { "baa", "abcd", "abca", "cab", "cad" };
		alienOrder(dist);

	}

}
