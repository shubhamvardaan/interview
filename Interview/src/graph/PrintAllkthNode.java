package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintAllkthNode {
	static class Graph {
		Map<Integer, List<Integer>> map;

		Graph() {
			map = new HashMap<>();
		}

		void addEdge(int source, int destination) {
			if (map.get(source) == null)
				map.put(source, new ArrayList<>());
			map.get(source).add(destination);
		}

		private void printKthNode(int source, List<Integer> visited, int k) {
			if (k == 0) {
				System.out.print(source + "  ");
				return;
			}
			visited.add(source);
			if (map.get(source) != null)
				for (int i = 0; i < map.get(source).size(); i++) {
					if (!visited.contains(map.get(source).get(i)))
						printKthNode(map.get(source).get(i), visited, k - 1);
				}
		}

		void printK(int source) {
			List<Integer> visited = new ArrayList<>();
			int k = 3;
			printKthNode(source, visited, k);

		}
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 1);
		g.addEdge(1, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(3, 6);
		g.addEdge(4, 5);
		g.addEdge(4, 6);
		g.printK(0);
	}
}
