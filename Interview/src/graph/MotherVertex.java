package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Graph3 {
	int V;
	List<Integer>[] adj;

	Graph3(int v) {
		V = v;
		adj = new List[V];
		for (int i = 0; i < V; i++)
			adj[i] = new ArrayList<>();
	}

	public void addEdge(int source, int destination) {
		adj[source].add(destination);
	}

	private void DFSRecur(int source, boolean[] visited) {
		visited[source] = true;
		for (int i = 0; i < adj[source].size(); i++) {
			if (!visited[adj[source].get(i)])
				DFSRecur(adj[source].get(i), visited);
		}
	}

	int findMother() {
		boolean[] visited = new boolean[V];
		int v = -1;
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				DFSRecur(i, visited);
				v = i;
			}
		}

		Arrays.fill(visited, false);
		DFSRecur(v, visited);
		for (int i = 0; i < V; i++) {
			if (!visited[i])
				return Integer.MAX_VALUE;
		}

		return v;

	}
}

public class MotherVertex {
	public static void main(String[] args) {
		Graph3 g = new Graph3(7);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(4, 1);
		g.addEdge(6, 4);
		g.addEdge(5, 6);
		g.addEdge(5, 2);
		g.addEdge(6, 0);

		System.out.println(g.findMother());
	}
}
