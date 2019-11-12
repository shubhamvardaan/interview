package graph;

import java.util.ArrayList;
import java.util.List;

import graph.CheckUndirectedGraphCyclic.Graph;

class temp {
	int length = 0;
}

public class CheckGraphBipartite {
	static class Graph {
		int V;
		List<Integer> adj[];

		@SuppressWarnings("unchecked")
		Graph(int V) {
			this.V = V;
			adj = new List[V];
			for (int i = 0; i < this.V; i++) {
				adj[i] = new ArrayList<>();
			}
		}

		public void addEdge(int source, int destination) {
			adj[source].add(destination);
			adj[destination].add(source);
		}

		private boolean getCycleLength(List<Integer> visited, int source, int parent, temp t) {
			visited.add(source);
			t.length = t.length + 1;
			for (int i = 0; i < adj[source].size(); i++) {
				if (!visited.contains(adj[source].get(i)))
					return getCycleLength(visited, adj[source].get(i), source, t);
				else if (parent != adj[source].get(i))
					return true;
			}
			return false;
		}

		boolean checkBiparTite() {
			List<Integer> visited = new ArrayList<>();
			temp t = new temp();
			for (int i = 0; i < V; i++) {
				if (!visited.contains(i)) {
					if (getCycleLength(visited, i, -1, t))
						break;
				}
			}

			if (t.length % 2 == 0)
				return true;
			return false;
		}

	}

	public static void main(String[] args) {
		Graph g1 = new Graph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 3);
		g1.addEdge(3, 1);
		g1.addEdge(3, 4);
		System.out.println(g1.checkBiparTite());
	}

}
