import java.util.*;

public class DAG <Value> {
	
	
	private static final String NEWLINE = System.getProperty("line.separator");
	private final int V; // number of vertices in this digraph
	private int E; // number of edges in this digraph
	private ArrayList<ArrayList<Node>> adj;
	private int[] indegree; // indegree[v] = indegree of vertex v

	
	public DAG(int V) {
		if (V < 0)
			throw new IllegalArgumentException("Number of vertices in a Digraph must be greater than zero");

		this.V = V+1;
		this.E = 0;

		indegree = new int[V]; // indegree is number of edges pointing to vertices

		adj = new ArrayList<ArrayList<Node>>();

		for (int x = 0; x <= V; x++) {
			ArrayList<Node> innerList = new ArrayList<Node>();
			adj.add(innerList);
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}
	

/*	private void validateVertex(Node v2) 
	{
		if (v2.val < 0 || v2.val >= V)
			throw new IllegalArgumentException("vertex " + v2.val + " is not between 0 and " + (V - 1));
	}
*/
	public void addEdge(Node v, Node w) {
		//validateVertex();
		//validateVertex();	
		adj.get((int) v.val).add(w);
		//indegree[w.val]++;
		E++;
	}

	public ArrayList<Node> find(int w)
	{
		return adj.get(w);	
	}

	
	public String toString() {
	
		StringBuilder s = new StringBuilder();
		s.append(V + " vertices, " + E + " edges " + NEWLINE);
		for (int v = 0; v < V; v++) {
			s.append(String.format("%d: ", v));
			
			for (Node w : adj.get(v)) {
				s.append(String.format("%d %s, ", w.val, w.color));
			}

			s.append(NEWLINE);
		}

		return s.toString();
	}



	public static void main(String[] args) 
	{
		DAG g = new DAG (3);
		
		Node ver4 = new Node(4);
		Node ver2 = new Node(2);
		Node ver0 = new Node(0);
	//	Node ver1 = new Node(1);
		
		g.addEdge(ver0, ver2);
		g.addEdge(ver2, ver0);
		
		
		//g.addEdge(ver1, ver0);
		//g.addEdge(ver0, ver2);
		
		
		/*g.addEdge(2, 3);
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
		g.addEdge(7, 6);*/

		System.out.println(g.toString());
	}
}
