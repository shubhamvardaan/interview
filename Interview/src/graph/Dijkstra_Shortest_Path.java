package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra_Shortest_Path {
	static class pair {
		int destination, weight;

		pair(int destination, int weight) {
			this.destination = destination;
			this.weight = weight;
		}

	}

	static class pair1 implements Comparator<pair1> {
		int distance, node;

		pair1() {
		}

		pair1(int distance, int node) {
			this.distance = distance;
			this.node = node;
		}

		@Override
		public int compare(pair1 node1, pair1 node2) {
			if (node1.distance < node2.distance)
				return -1;
			if (node1.distance > node2.distance)
				return 1;
			return 0;
		}
	}

	static class Graph {
		static int V;
		static List<pair>[] adj;

		@SuppressWarnings("unchecked")
		Graph(int V) {
			Graph.V = V;
			adj = (List<pair>[]) new List[V];
		}

		static void addEdge(int source, int destination, int weight) {
			if (adj[source] == null) {
				adj[source] = new ArrayList<>();
			}
			if (adj[destination] == null) {
				adj[destination] = new ArrayList<>();
			}
			adj[source].add(new pair(destination, weight));
			adj[destination].add(new pair(source, weight));
		}

		static void shortestPath(int source) {
			PriorityQueue<pair1> pq = new PriorityQueue<>(V, new pair1());

			int[] dist = new int[V];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[source] = 0;
			pq.add(new pair1(0, source));

			while (!pq.isEmpty()) {
				int u = pq.poll().node;
				if (adj[u] != null) {
					for (int i = 0; i < adj[u].size(); i++) {
						int v = adj[u].get(i).destination;
						int w = adj[u].get(i).weight;
						if (dist[u] + w < dist[v]) {
							dist[v] = dist[u] + w;
							pq.add(new pair1(dist[v], v));
						}
					}
				}
			}
			System.out.println("Vertex   Distance from Source\n");
			for (int i = 0; i < V; ++i)
				System.out.println(i + "            " + dist[i]);

		}
	}

	public static void main(String[] args) {
		int V = 9;
		Graph g = new Graph(V);

		// making above shown graph
		g.addEdge(0, 1, 4);
		g.addEdge(0, 7, 8);
		g.addEdge(1, 2, 8);
		g.addEdge(1, 7, 11);
		g.addEdge(2, 3, 7);
		g.addEdge(2, 8, 2);
		g.addEdge(2, 5, 4);
		g.addEdge(3, 4, 9);
		g.addEdge(3, 5, 14);
		g.addEdge(4, 5, 10);
		g.addEdge(5, 6, 2);
		g.addEdge(6, 7, 1);
		g.addEdge(6, 8, 6);
		g.addEdge(7, 8, 7);

		g.shortestPath(0);
	}
}
