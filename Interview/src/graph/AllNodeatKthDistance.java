package graph;

import java.util.ArrayList;
import java.util.List;

class Graph5 {
	int V;
	List<Integer> adj[];

	Graph5(int V) {
		this.V = V;
		this.adj = new List[V];
		for (int i = 0; i < V; i++)
			adj[i] = new ArrayList<>();
	}

	void addEdge(int source, int destination) {
		adj[source].add(destination);
	}

	void printKthNodeUtil(int source, int k, boolean[] visited) {
		if (k < 0)
			return;
		visited[source] = true;
		System.out.print(source + "  ");
		
		for (int i = 0; i < adj[source].size(); i++) {
			if (!visited[adj[source].get(i)])
				printKthNodeUtil(adj[source].get(i), k - 1, visited);
		}
	}

	void printKthNode(int source, int k) {
		boolean[] visited = new boolean[V];
		printKthNodeUtil(source, k, visited);
	}
}

public class AllNodeatKthDistance {
	public static void main(String[] args) {
		Graph5 g = new Graph5(5);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 0);
		g.printKthNode(0, 3);
	}

}
