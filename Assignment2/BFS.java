/*import java.util.*;
import java.util.LinkedList;

import DAG.Node;

public class BFS {
	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean[] visited; // visited[v] = is there an s-v path
	private int[] edgeTo; // edgeTo[v] = previous edge on shortest s-v path
	private int[] distTo; // distTo[v] = number of edges on shortest s-v path

	public BFS(DAG g, int s) 
	{
		visited = new boolean[g.V()];
		distTo = new int[g.V()];
		edgeTo = new int[g.V()];
		search(g, s);
	}

	private void validateVertex(int v) {
		int V = visited.length;
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
	}

	public boolean hasPathTo(int v) {
		validateVertex(v);
		return visited[v];
	}

	public int distTo(int v) {
		validateVertex(v);
		return distTo[v];
	}

	public Iterable<Integer> pathTo(int v) {
		validateVertex(v);
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		int x;
		for (x = v; distTo[x] != 0; x = edgeTo[x])
			path.push(x);
		path.push(x);
		return path;
	}

	private void search(DAG g, int s) {
		LinkedList<Integer> q = new LinkedList<Integer>();

		for (int v = 0; v < g.V(); v++)

			distTo[v] = INFINITY;
			distTo[s] = 0;
			visited[s] = true;
			q.add(s);

		while (!q.isEmpty()) {
			Node v = q.removeFirst();
			for (int w : g.find(v.val)) {
				if (!visited[w]) {
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
					visited[w] = true;
					q.add(w);
				}
			}
		}
	}

	public static void main(String[] args) {
		DAG g = new DAG(13);
		
		
		/*g.addEdge(4, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 2);
		g.addEdge(6, 0);
		g.addEdge(0, 1);
		g.addEdge(2, 0);
		g.addEdge(11, 12);
		g.addEdge(12, 9);
		g.addEdge(9, 10);
		g.addEdge(9, 11);
		g.addEdge(7, 9);
		g.addEdge(10, 12);
		g.addEdge(11, 4);
		g.addEdge(4, 3);
		g.addEdge(3, 5);
		g.addEdge(6, 8);
		g.addEdge(8, 6);
		g.addEdge(5, 4);
		g.addEdge(0, 5);
		g.addEdge(6, 4);
		g.addEdge(6, 9);
		g.addEdge(7, 6);

		int test = 4;
		BFS testBFS = new BFS(g, test);

		for (int v = 0; v < g.V(); v++) {
			if (testBFS.hasPathTo(v)) {
				System.out.printf("%d to %d (%d):", test, v, testBFS.distTo(v));
				for (int x : testBFS.pathTo(v)) {
					if (x == test)
						System.out.print("->" + x);
					else
						System.out.print("->" + x);
				}
				System.out.println();
			}

			else {
				System.out.println(test + " and " + v + " are not connected");
			}

		}

	}
}*/
