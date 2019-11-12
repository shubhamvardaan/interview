package graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Graph1 {
	Integer V;
	List<Integer> adj[];

	@SuppressWarnings("unchecked")
	Graph1(Integer V) {
		this.V = V;
		adj = new List[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
	}

	void addEdge(int source, int destination) {
		adj[source].add(destination);
	}

	boolean isCyclic() {
		int[] degree = new int[V];
		for (int i = 0; i < V; i++) {
			for (int t : adj[i]) {
				degree[t]++;
			}
		}
		Deque<Integer> q = new LinkedList<>();
		for (int i = 0; i < V; i++)
			if (degree[i] == 0)
				q.addLast(i);
		int count = 0;
		while (!q.isEmpty()) {
			int temp = q.pollFirst();
			for (int i = 0; i < adj[temp].size(); i++) {
				degree[adj[temp].get(i)]--;
				if (degree[adj[temp].get(i)] == 0)
					q.addLast(adj[temp].get(i));
			}
			count++;
		}
		if (count != V)
			return true;
		else
			return false;
	}
}

public class DGCheckCyclic {

	public static void main(String[] args) {
		Graph1 g = new Graph1(6);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		System.out.print(g.isCyclic());
	}

}
