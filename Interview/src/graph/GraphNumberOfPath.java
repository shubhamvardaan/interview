package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphNumberOfPath {
	static class Shubham {
		int numberOfPath = 0;
	}

	static class Graph {
		Map<Integer, List<Integer>> graph;

		Graph() {
			graph = new HashMap<>();
		}

		void addEdge(int s, int d) {
			if (graph.get(s) == null)
				graph.put(s, new ArrayList<>());
			graph.get(s).add(d);
		}

	}

	static void numberOfPath(Graph g, List<Integer> visited, int source, int destination, Shubham shubham) {
		visited.add(source);
		if (source == destination) {
			shubham.numberOfPath = shubham.numberOfPath + 1;
			visited.remove(new Integer(source));
			return;
		}
		List<Integer> list = g.graph.get(source);
		if (list != null && list.size() > 0) {
			for (int x : list) {
				if (!visited.contains(x)) {
					numberOfPath(g, visited, x, destination, shubham);
				}
			}
		}
		visited.remove(new Integer(source));
	}

	static int countPath(Graph g, int s, int d) {
		Shubham shubham = new Shubham();
		List<Integer> visited = new ArrayList<>();
		numberOfPath(g, visited, s, d, shubham);
		return shubham.numberOfPath;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(2, 0);
		g.addEdge(3, 1);
		System.out.println(countPath(g, 5, 0));

	}

}
