package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordLadder {
	static class shubham {
		int count = Integer.MAX_VALUE;
		int temp = 1;
	}

	static class Graph {
		HashMap<String, List<String>> map;

		Graph() {
			map = new HashMap<>();
		}

		void addEdge(String source, String destination) {
			if (map.get(source) == null) {
				map.put(source, new ArrayList<>());
			}
			map.get(source).add(destination);

			if (map.get(destination) == null) {
				map.put(destination, new ArrayList<>());
			}
			map.get(destination).add(source);

		}

		void findDistance(String source, String destination, List<String> visited, shubham s) {
			visited.add(source);
			if (source == destination) {
				if (s.temp < s.count)
					s.count = s.temp;
				return;
			}
			if (map.containsKey(source)) {
				for (int i = 0; i < map.get(source).size(); i++) {
					String str = map.get(source).get(i);
					if (!visited.contains(str)) {
						s.temp++;
						findDistance(str, destination, visited, s);
					}
				}
			}
		}

	}

	static boolean isAdjacent(String str, String str1) {
		int m = str.length();
		int n = str1.length();
		if (m != n)
			return false;
		int count = 0;
		for (int i = 0; i < m; i++) {
			if (str.charAt(i) != str1.charAt(i))
				count++;
		}
		return count == 1;
	}

	public static void main(String[] args) {
		String[] dictionary = { "TOON", "POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN" };
		Graph g = new Graph();
		int length = dictionary.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				if (isAdjacent(dictionary[i], dictionary[j]))
					g.addEdge(dictionary[i], dictionary[j]);
			}
		}
		List<String> visited = new ArrayList<>();
		shubham s = new shubham();
		String source = "TOON";
		String destination = "PLEA";
		g.findDistance(source, destination, visited, s);
		System.out.println("Distance between word " + source + " and " + destination + " is " + s.count);
	}
}
