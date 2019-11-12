package graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class AlienLanguage {
	static class Graph {
		static Map<Character, List<Character>> mp;

		Graph() {
			mp = new LinkedHashMap<>();
		}

		void addEdge(Character source, Character destination) {
			if (mp.get(source) == null) {
				mp.put(source, new ArrayList<>());
			}

			mp.get(source).add(destination);

		}

		private static void topologicalSortUtil(Character ch, Stack<Character> s, List<Character> visited) {
			visited.add(ch);
			if (mp.get(ch) != null) {
				for (char ch1 : mp.get(ch)) {
					if (!visited.contains(ch1))
						topologicalSortUtil(ch1, s, visited);
				}
			}
			s.push(ch);
		}

		static void topologicalSort() {
			Stack<Character> s = new Stack<>();
			List<Character> visited = new ArrayList<>();
			for (Entry<Character, List<Character>> temp : mp.entrySet()) {
				if (!visited.contains(temp.getKey()))
					topologicalSortUtil(temp.getKey(), s, visited);
			}

			while (!s.isEmpty()) {
				System.out.print(s.pop() + " ");
			}
		}
	}

	static int minimum(int a, int b) {
		return a < b ? a : b;
	}

	static void printOrder(String[] dist) {
		int n = dist.length;
		Graph g = new Graph();
		for (int i = 0; i < n - 1; i++) {
			String word1 = dist[i];
			String word2 = dist[i + 1];
			for (int j = 0; j < minimum(word1.length(), word2.length()); j++) {
				if (word1.charAt(j) != word2.charAt(j)) {
					g.addEdge(word1.charAt(j), word2.charAt(j));
					break;

				}
			}
		}

		g.topologicalSort();
	}

	public static void main(String[] args) {
		String[] dist = { "baa", "abcd", "abca", "cab", "cad" };
		printOrder(dist);

	}
}
