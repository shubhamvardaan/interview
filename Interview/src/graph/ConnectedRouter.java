package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectedRouter {
	static class shubham {
		List<List<Integer>> path = new ArrayList<>();
		boolean exist = false;
	}

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
	}

	static void DFS(Graph g, int source, int destination, HashMap<Integer, Boolean> visited, shubham s,
			List<Integer> temp) {
		visited.put(source, true);
		if (source == destination) {
			s.exist = true;
			s.path.add(new ArrayList<>(temp));
			visited.put(source, false);
			return;
		}

		if (g.map.get(source) != null && g.map.get(source).size() != 0) {
			for (int i = 0; i < g.map.get(source).size(); i++) {
				int x = g.map.get(source).get(i);
				if (!visited.get(x)) {
					temp.add(x);
					DFS(g, x, destination, visited, s, temp);
					temp.remove(new Integer(x));
				}
			}
		}
		visited.put(source, false);

	}

	static void printPath(List<List<Integer>> paths) {
		for (List<Integer> path : paths) {
			for (Integer x : path) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(2, 0);
		g.addEdge(2, 1);
		g.addEdge(1, 3);
		shubham s = new shubham();
		HashMap<Integer, Boolean> visited = new HashMap<>();
		for (int i = 0; i <= 3; i++)
			visited.put(i, false);
		List<Integer> temp = new ArrayList<>();
		temp.add(2);
		DFS(g, 2, 3, visited, s, temp);
		System.out.println("Path exist :" + s.exist);
		printPath(s.path);
	}

}
