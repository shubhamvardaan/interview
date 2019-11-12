package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologocalSort {
	static class Graph {
		int V;
		List<Integer>[] adj;

		Graph(int V) {
			this.V = V;
			adj = new List[V];
			for (int i = 0; i < this.V; i++) {
				adj[i] = new ArrayList<>();
			}
		}

		void addEdge(int source, int destination) {
			adj[source].add(destination);
		}

		private void topologicalUtil(boolean[] visited, Stack<Integer> s, int v) {
			visited[v] = true;
			for (int i = 0; i < adj[v].size(); i++) {
				if (!visited[i])
					topologicalUtil(visited, s, i);
			}
			s.push(v);
		}

		void topologicalSort() {
			Stack<Integer> s = new Stack<>();
			boolean visited[] = new boolean[V];
			for (int i = 0; i < V; i++)
				topologicalUtil(visited, s, i);
			while (!s.isEmpty()) {
				System.out.print(s.pop() + "  ");
			}
		}

	}

	public static void main(String args[]) {
		Graph g = new Graph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.topologicalSort();
	}

}
