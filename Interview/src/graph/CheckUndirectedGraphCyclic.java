package graph;

import java.util.ArrayList;
import java.util.List;

public class CheckUndirectedGraphCyclic {
	static class Graph {
		int V;
		List<Integer> adj[];

		Graph(int V) {
			this.V = V;
			adj = new List[V];
			for (int i = 0; i < V; ++i)
				adj[i] = new ArrayList<>();
		}

		void addEdge(int source, int destination) {
			adj[source].add(destination);
			adj[destination].add(source);
		}

		private boolean isCyclicUtil(int v, List<Integer> visited, int p) {
			visited.add(v);
			for (int i = 0; i < adj[v].size(); i++) {
				if (!visited.contains(adj[v].get(i)))
					return isCyclicUtil(adj[v].get(i), visited, v);
				else if (adj[v].get(i) != p)
					return true;
			}

			return false;
		}

		boolean isCyclic() {
			List<Integer> visited = new ArrayList<>();
			for (int i = 0; i < V; i++) {
				if (!visited.contains(i))
					if (isCyclicUtil(i, visited, -1))
						return true;

			}
			return false;
		}
	}

	public static void main(String[] args) {
		Graph g1 = new Graph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		System.out.println(g1.isCyclic());
	}

}
