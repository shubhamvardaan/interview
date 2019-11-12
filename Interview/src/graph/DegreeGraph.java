package graph;

import java.util.LinkedList;

public class DegreeGraph {

	static class Graph {
		int V;
		LinkedList<Integer>[] adj;

		Graph(int V) {
			this.V = V;
			adj = new LinkedList[V];
			for (int i = 0; i < this.V; i++)
				adj[i] = new LinkedList<>();
		}

		void addEdge(int source, int destination) {
			adj[source].add(destination);
		}

		void printArray(int[] arr) {
			int n = arr.length;
			for (int i = 0; i < n; i++)
				System.out.print(arr[i] + " ");
		}

		void printG(int[] degree) {
			for (int i = 0; i < V; i++) {
				degree[i] = adj[i].size();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = 6;
		Graph g = new Graph(v);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		int[] degree = new int[v];
		g.printG(degree);
		g.printArray(degree);
	}

}
