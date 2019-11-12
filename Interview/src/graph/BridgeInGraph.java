package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Graph4 {
	int V;
	List<Integer> adj[];

	Graph4(int v) {
		super();
		V = v;
		this.adj = new List[V];
		for (int i = 0; i < V; i++)
			adj[i] = new ArrayList<>();
	}

	void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	void bridge() {
		boolean[] visited = new boolean[V];
		int[] disc = new int[V];
		int[] low = new int[V];
		int[] parent = new int[V];
		Arrays.fill(parent, -1);
		Arrays.fill(visited, false);

		for (int i = 0; i < V; i++) {
			if (visited[i] == false)
				bridgeUtil(i, visited, disc, low, parent);
		}

	}
}

public class BridgeInGraph {

}
