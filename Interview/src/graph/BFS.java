package graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class graph {
	int V;
	private List<Integer> adj[];

	@SuppressWarnings("unchecked")
	graph(int V) {
		this.V = V;
		adj = new List[V];
		for (int i = 0; i < V; i++)
			adj[i] = new LinkedList<>();
	}

	public void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	private void BFSUtil(int source, List<Integer> visited) {
		Deque<Integer> queue = new LinkedList<>();
		queue.addLast(source);
		visited.add(source);
		while (!queue.isEmpty()) {
			int temp = queue.pollFirst();
			System.out.print(temp + " ");
			for (int i = 0; i < adj[temp].size(); i++) {
				if (!visited.contains(adj[temp].get(i))) {
					visited.add(adj[temp].get(i));
					queue.addLast(adj[temp].get(i));
				}
			}
		}
	}

	public void BFS(int source) {
		List<Integer> visited = new LinkedList<>();
		BFSUtil(source, visited);
	}
}

public class BFS {
	public static void main(String[] args) {
		graph g = new graph(5);
		g.addEdge(0, 4);
		g.addEdge(1, 4);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 2);
		g.addEdge(0, 3);
		g.addEdge(2, 1);
		System.out.println("BFS of given graph :");
		g.BFS(1);
	}
}
