package graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PrintAllPath {
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

	static boolean presentInList(List<Integer> t, int node) {
		for (int x : t) {
			if (x == node)
				return true;
		}
		return false;
	}

	static void printList(List<Integer> list) {
		for (int x : list) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
	
	void printAllPath(Graph g , int s, int d) {
		Deque<List<Integer>> queue = new LinkedList<>();
		
	}
	
	

}
