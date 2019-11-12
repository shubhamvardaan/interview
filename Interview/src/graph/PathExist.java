package graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PathExist {

	static class Shubham {
		boolean pathExist = false;
	}

	static class Graph {
		Map<Integer, List<Integer>> map;

		public Graph() {
			map = new HashMap<>();
		}

		void addEdge(int source, int destination) {
			if (map.get(source) == null)
				map.put(source, new ArrayList<>());
			map.get(source).add(destination);
		}
	}

	static boolean pathExist(Graph g, int source, int destination, Shubham shubham) {
		Deque<Integer> queue = new LinkedList<>();
		List<Integer> visited = new ArrayList<>();
		queue.addLast(source);
		visited.add(source);
		while (!queue.isEmpty()) {
			int temp = queue.pollFirst();
			if (temp == destination) {
				shubham.pathExist = true;
			}
			if (g.map.get(temp) != null && g.map.get(temp).size() > 0) {
				for (int i = 0; i < g.map.get(temp).size(); i++) {
					int node = g.map.get(temp).get(i);
					if (!visited.contains(node)) {
						visited.add(node);
						queue.addLast(node);
					}
				}
			}
		}

		return shubham.pathExist;

	}

	public static void main(String[] args) {
		Graph g = new Graph();
		Shubham shubham = new Shubham();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(2, 0);
		g.addEdge(2, 1);
		g.addEdge(1, 3);
		System.out.println(pathExist(g, 2, 3, shubham));
	}

}
