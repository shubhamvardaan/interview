package graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphMapAdjList {
	static class Graph {
		static Map<Character, List<Character>> mp;

		Graph() {
			mp = new HashMap<>();
		}

		static void addEdge(char source, char destination) {
			if (mp.get(source) == null) {
				List<Character> temp = new LinkedList<>();
				mp.put(source, temp);
			}
			mp.get(source).add(destination);
			if (mp.get(destination) == null) {
				List<Character> temp1 = new LinkedList<>();
				mp.put(destination, temp1);
			}
			mp.get(destination).add(source);
		}

		static void BFS(Graph g, char source) {
			List<Character> visited = new ArrayList<>();
			Deque<Character> queue = new LinkedList<>();
			visited.add(source);
			queue.addLast(source);
			while (!queue.isEmpty()) {
				char c = queue.pollFirst();
				System.out.print(c + "  ");
				for (char c1 : g.mp.get(c)) {
					if (!visited.contains(c1)) {
						visited.add(c1);
						queue.addLast(c1);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addEdge('s', 't');
		g.addEdge('s', 'y');
		g.addEdge('s', 'o');

		g.addEdge('o', 'p');
		g.addEdge('p', 'i');
		g.BFS(g, 't');

	}
}
