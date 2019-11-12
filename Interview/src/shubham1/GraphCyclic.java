package shubham1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphCyclic {
	static class Graph {
		Map<Integer, Set<Integer>> graph;

		Graph() {
			graph = new HashMap<>();
		}

		void addEdge(int s, int d) {
			if (graph.get(s) == null) {
				graph.put(s, new HashSet<>());
			}
			graph.get(s).add(d);
		}
	}

	private static boolean isCyclicUtil(Graph g, int source, List<Integer> visited, List<Integer> alreadyPresent) {
		visited.add(source);
		alreadyPresent.add(source);
		Set<Integer> shubham = g.graph.get(source);
		if (shubham != null && shubham.size() > 0) {
			for (int x : shubham) {
				if (!visited.contains(x) && isCyclicUtil(g, x, visited, alreadyPresent))
					return true;
				if (alreadyPresent.contains(x))
					return true;
			}
		}
		alreadyPresent.remove(new Integer(source));
		return false;
	}

	public static boolean isCyclic(Graph g) {
		List<Integer> visited = new ArrayList<>();
		List<Integer> alreadyPresent = new ArrayList<>();
		for (Map.Entry<Integer, Set<Integer>> temp : g.graph.entrySet()) {
			if (isCyclicUtil(g, temp.getKey(), visited, alreadyPresent))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Graph g = new Graph();

		g.addEdge(0, 2);
		g.addEdge(2, 4);
//		g.addEdge(4, 9);
//		//g.addEdge(9, 11);
//		g.addEdge(11, 12);
//		g.addEdge(0, 7);
		System.out.println(isCyclic(g));
	}
}
