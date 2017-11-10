import java.util.*;

public class DAG 
{
	private int Edges; // number of edges in this didag
	public ArrayList<DagNode> allVertices;

	public DAG() 
	{
		this.Edges = 0;
		allVertices = new ArrayList<DagNode>();
	}

	public int numberOfVerts() 
	{
		return allVertices.size();
	}

	public int numberOfEdges() 
	{
		return Edges;
	}

	private boolean validateVertex(DagNode v2) 
	{
		return allVertices.contains(v2);
	}
	
	public boolean validateEdges(DagNode v1, DagNode v2)
	{
		if (v2.parents.contains(v1)) 
		{
			return true;
		} else

			return false;
		
	}

	public void addEdge(DagNode v, DagNode w)//w VERTEX POINTS TO v VERTEX 
	{
		if (validateVertex(v) == true && validateVertex(w) == true) {
			w.parents.add(v);
			Edges++;
		}
	}

	public Object LCA(BFS bfs, DAG g, DagNode x, DagNode y) 
	{
		bfs.colourChangeBlue(g, x);
		bfs.blueChangeRed(g, y);

		for (int i = 0; i < allVertices.size(); i++) 
		{
			if(allVertices.get(i).count == 0 && allVertices.get(i).color == "Red") 
			{
				System.out.println("The LCA is " + allVertices.get(i).val);
				return allVertices.get(i).val;
			}
		}
		
		return null;
	}
}
