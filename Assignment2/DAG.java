
import java.io.*;
import java.util.*;

// This class represents a directed graph using adjacency
// list representation
public class DAG {

	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency List

	// Constructor
	DAG(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
}
