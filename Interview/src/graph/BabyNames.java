package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BabyNames {

	static class shubham {
		HashMap<String, Integer> result;
		String last;

		shubham() {
			result = new HashMap<>();
		}
	}

	static class Graph {
		Map<String, List<String>> map;

		Graph() {
			map = new HashMap<>();
		}

		void addEdge(String source, String destination) {
			if (map.get(source) == null)
				map.put(source, new ArrayList<>());
			map.get(source).add(destination);
			if (map.get(destination) == null)
				map.put(destination, new ArrayList<>());
			map.get(destination).add(source);
		}
	}

	static void getList(Graph g, String source, shubham s, List<String> visited, HashMap<String, Integer> hashMap) {
		visited.add(source);
		if (s.result.get(s.last) == null) {
			s.result.put(s.last, hashMap.get(source));
		} else {
			int count = s.result.get(s.last) + hashMap.get(source);
			s.result.put(s.last, count);
		}
		if (g.map.get(source) != null) {
			for (int i = 0; i < g.map.get(source).size(); i++) {
				String str = g.map.get(source).get(i);
				if (!visited.contains(str)) {
					getList(g, str, s, visited, hashMap);
				}
			}
		}

	}

	public static void main(String[] args) {
		String[][] names = { { "Jonathan", "John" }, { "Jon", "Johnny" }, { "Johnny", "John" }, { "Kari", "Carrie" },
				{ "Carleton", "Carlton" } };
		HashMap<String, Integer> hashMap = new HashMap<>();
		hashMap.put("John", 10);
		hashMap.put("Jon", 3);
		hashMap.put("Davis", 2);
		hashMap.put("Kari", 3);
		hashMap.put("Johnny", 11);
		hashMap.put("Carlton", 8);
		hashMap.put("Carleton", 2);
		hashMap.put("Jonathan", 9);
		hashMap.put("Carrie", 5);
		Graph g = new Graph();
		for (int i = 0; i < names.length; i++) {
			g.addEdge(names[i][0], names[i][1]);
		}
		List<String> visited = new ArrayList<>();
		shubham s = new shubham();

		for (Map.Entry<String, Integer> temp : hashMap.entrySet()) {
			if (!visited.contains(temp.getKey())) {
				s.last = temp.getKey();
				getList(g, temp.getKey(), s, visited, hashMap);
			}
		}

		for (Map.Entry<String, Integer> temp : s.result.entrySet()) {
			System.out.println(temp.getKey() + " " + temp.getValue());
		}

	}
}
