package trie_dataStructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AutoComplete {

	private class Node {
		String prefix;
		HashMap<Character, Node> children;
		boolean isWord;

		Node(String prefix) {
			this.prefix = prefix;
			this.children = new HashMap<>();
		}
	}

	Node trie;

	public AutoComplete(String[] dict) {
		trie = new Node("");
		for (String str : dict) {
			insert(str);
		}
	}

	private void insert(String s) {
		Node current = trie;
		for (int i = 0; i < s.length(); i++) {
			if (!current.children.containsKey(s.charAt(i))) {
				current.children.put(s.charAt(i), new Node(s.substring(0, i + 1)));
			}
			current = current.children.get(s.charAt(i));
			if (i == s.length() - 1)
				current.isWord = true;
		}
	}

	List<String> getAllWords(String str) {
		List<String> results = new LinkedList<>();
		Node current = trie;
		for (Character c : str.toCharArray()) {
			if (current.children.containsKey(c)) {
				current = current.children.get(c);
			} else
				return results;
		}
		getResults(current, results);
		return results;
	}

	private void getResults(Node n, List<String> results) {
		if (n.isWord == true)
			results.add(n.prefix);
		for (Character c : n.children.keySet()) {
			getResults(n.children.get(c), results);
		}
	}
}
