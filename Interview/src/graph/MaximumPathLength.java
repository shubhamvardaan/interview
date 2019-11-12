package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumPathLength {

	static class Shubham {
		Map<Integer, Boolean> visited = new HashMap<>();
		int length = Integer.MIN_VALUE;
	}

	static class Graph {
		Map<Integer, List<Integer>> map;

		public Graph() {
			map = new HashMap<>();
		}

		void addEdge(int source, int destination, Shubham shubham) {
			if (map.get(source) == null)
				map.put(source, new ArrayList<>());
			map.get(source).add(destination);
			if (shubham.visited.get(source) == null)
				shubham.visited.put(source, false);
			if (shubham.visited.get(destination) == null)
				shubham.visited.put(destination, false);
		}
	}

	static void getPathLenUtil(Graph g, int s, int d, int len, Shubham shubham) {
		shubham.visited.put(s, true);
		if (s == d) {
			if (shubham.length < len)
				shubham.length = len;
			shubham.visited.put(s, false);
			return;
		}
		if (g.map.get(s) != null && g.map.get(s).size() > 0) {
			for (int i = 0; i < g.map.get(s).size(); i++) {
				int temp = g.map.get(s).get(i);
				if (!shubham.visited.get(temp)) {
					len = len + 1;
					getPathLenUtil(g, temp, d, len, shubham);
					len = len - 1;
				}
			}
		}
		shubham.visited.put(s, false);
	}

	static int getMaxPathLen(Graph g, int source, int destination, Shubham shubham) {
		int tempLen = 1;
		getPathLenUtil(g, source, destination, tempLen, shubham);
		return shubham.length;
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		Shubham shubham = new Shubham();
		g.addEdge(0, 1, shubham);
		g.addEdge(0, 2, shubham);
		g.addEdge(0, 3, shubham);
		g.addEdge(2, 0, shubham);
		g.addEdge(2, 1, shubham);
		g.addEdge(1, 3, shubham);
		int source = 2;
		int destination = 3;
		System.out.println(getMaxPathLen(g, source, destination, shubham));

	}

}
