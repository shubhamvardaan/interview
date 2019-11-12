package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class graphDFS {
	Map<Integer, List<Integer>> shubham;

	graphDFS() {
		shubham = new HashMap<>();
	}

	public void addEdge(int source, int destination) {
		if (shubham.get(source) == null)
			shubham.put(source, new ArrayList<>());
		shubham.get(source).add(destination);
	}

	private void DFSUtil(int source, List<Integer> visited, Stack<Integer> s) {
		visited.add(source);
		s.push(source);
		if (shubham.get(source) != null) {
			for (int i = 0; i < shubham.get(source).size(); i++) {
				int temp = shubham.get(source).get(i);
				if (!visited.contains(temp)) {
					DFSUtil(temp, visited, s);
				}
			}
		}
	}

	public void DFS(int source) {
		Stack<Integer> s = new Stack<>();
		List<Integer> visited = new LinkedList<>();
		DFSUtil(source, visited, s);
		while(!s.isEmpty())
			System.out.print(s.pop()+" ");
	}
}

public class DFS {
	public static void main(String[] args) {
		graphDFS g = new graphDFS();
		g.addEdge(0, 4);
		g.addEdge(1, 4);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 2);
		g.addEdge(0, 3);
		g.addEdge(2, 1);
		System.out.println("DFS of given graph :");
		g.DFS(0);
	}
}
