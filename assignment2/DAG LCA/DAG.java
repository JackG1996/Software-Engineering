import java.util.*;

public class DAG {

	private static final String NEWLINE = System.getProperty("line.separator");
	private int Edges; // number of edges in this digraph
	public ArrayList<DagNode> allVertices;

	public DAG() {
		this.Edges = 0;

		allVertices = new ArrayList<DagNode>();
	}

	public int numberOfVerts() {
		return allVertices.size();
	}

	public int E() {
		return Edges;
	}

	private boolean validateVertex(DagNode v2) {
		return allVertices.contains(v2);
	}

	public void addEdge(DagNode v, DagNode w) {
		if (validateVertex(v) == true && validateVertex(w) == true) {
			w.parents.add(v);
			Edges++;
		}
	}

	public void output() {
		// prints out all the parents of the DagNodes
		for (int i = 0; i < allVertices.size(); i++) {
			System.out.print(allVertices.get(i).val + ": ");
			for (int j = 0; j < allVertices.get(i).parents.size(); j++) {
				System.out.print(allVertices.get(i).parents.get(j).val + ",");
			}
			System.out.println("");
		}
	}

	public void LCA(BFS bfs, DAG g, DagNode x, DagNode y) {
		bfs.colourChangeBlue(g, x);
		bfs.blueChangeRed(g, y);

		for (int i = 0; i < allVertices.size(); i++) {
			if (allVertices.get(i).count == 0 && allVertices.get(i).color == "Red") {
				System.out.println("The LCA is " + allVertices.get(i).val);
			}
		}
	}

/*	public static void main(String[] args) {
		DAG g = new DAG();
		BFS bfs = new BFS();

		Dagnode A = new Dagnode("A", g);
		Dagnode B = new Dagnode("B", g);
		Dagnode C = new Dagnode("C", g);
		Dagnode D = new Dagnode("D", g);

		g.addEdge(B, A);
		g.addEdge(C, B);
		g.addEdge(C, D);

		g.output();
		g.LCA(bfs, g, A, D);

	}*/
}