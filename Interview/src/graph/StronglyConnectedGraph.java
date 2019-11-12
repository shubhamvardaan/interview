package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Graph2 {
	int V;
	List<Integer> adj[];

	@SuppressWarnings("unchecked")
	Graph2(int V) {
		this.V = V;
		adj = new List[V];
		for (int i = 0; i < V; i++) {
			this.adj[i] = new ArrayList<>();
		}
	}

	public void addEdge(int source, int destination) {
		adj[source].add(destination);
	}

	void DFSUtil(int source, boolean[] visited) {
		visited[source] = true;
		for (int i = 0; i < adj[source].size(); i++) {
			if (!visited[adj[source].get(i)])
				DFSUtil(adj[source].get(i), visited);
		}
	}
}

public class StronglyConnectedGraph {

	static Graph2 makeTranspose(Graph2 g) {
		Graph2 g1 = new Graph2(g.V);
		for (int i = 0; i < g.V; i++) {
			int size = g.adj[i].size();
			for (int j = 0; j < size; j++) {
				g1.addEdge(g.adj[i].get(j), i);
			}
		}
		return g1;
	}

	static Boolean checkStronglyConnected(Graph2 g) {
		Graph2 g1 = makeTranspose(g);
		boolean[] visited = new boolean[g.V];
		Arrays.fill(visited, false);
		g.DFSUtil(0, visited);
		for (int i = 0; i < g.V; i++)
			if (!visited[i])
				return false;
		Arrays.fill(visited, false);
		g1.DFSUtil(0, visited);
		for (int i = 0; i < g.V; i++)
			if (!visited[i])
				return false;
		return true;

	}

	public static void main(String[] args) {
		Graph2 g2 = new Graph2(4);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.addEdge(2, 3);
		System.out.println(checkStronglyConnected(g2));
	}
}
