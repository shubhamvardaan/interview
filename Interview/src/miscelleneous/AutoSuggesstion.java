package miscelleneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AutoSuggesstion {
	private class Node {
		String prefix;
		HashMap<Character, Node> children;
		boolean isEndOfWord;

		Node(String prefix) {
			this.prefix = prefix;
			children = new HashMap<>();
		}
	}

	Node trie;

	void insert(String[] dist) {
		trie = new Node("");
		for (String str : dist) {
			insertWord(str);
		}

	}

	void insertWord(String str) {
		Node current = trie;
		int len = str.length();
		for (int i = 0; i < len; i++) {
			if (!current.children.containsKey(str.charAt(i)))
				current.children.put(str.charAt(i), new Node(str.substring(0, i + 1)));
			current = current.children.get(str.charAt(i));
		}
		current.isEndOfWord = true;
	}

	List<String> getAllWord(String prefix) {
		List<String> results = new ArrayList<>();
		Node current = trie;
		for (char ch : prefix.toCharArray()) {
			if (current.children.containsKey(ch))
				current = current.children.get(ch);
			else
				return results;
		}
		getWord(current, results);
		return results;
	}

	void getWord(Node current, List<String> results) {
		if (current.isEndOfWord) {
			results.add(current.prefix);
		}
		for (char ch : current.children.keySet()) {
			getWord(current.children.get(ch), results);
		}

	}

	public static void main(String args[]) {
		String[] dictionary = { "shubham", "shubh", "shu" };

		AutoSuggesstion auto = new AutoSuggesstion();
		auto.insert(dictionary);
		System.out.println(auto.getAllWord("sh"));
	}
}
