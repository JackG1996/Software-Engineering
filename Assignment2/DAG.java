import java.io.*;
import java.util.*;

public class DAG 
{
   private static final String NEWLINE = System.getProperty("line.separator");

   private final int V;           // number of vertices in this digraph
    private int E;                 // number of edges in this digraph
    private ArrayList <ArrayList<Integer>> adj;
    private int[] indegree;        // indegree[v] = indegree of vertex v
    
    /**
     * Initializes an empty digraph with <em>V</em> vertices.
     *
     * @param  V the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public DAG(int V) 
    {
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be greater than zero");
        
        this.V = V;
        this.E = 0;
        
        indegree = new int[V]; // indegree is number of edges pointing to vertices
        
        adj = new ArrayList <ArrayList<Integer>>();
        
        for (int x = 0; x <= V; x++) 
        {
        	ArrayList <Integer> innerList = new ArrayList <Integer> ();
        	adj.add(innerList);
        }
    }
    
    public int V() 
    {
        return V;
    }

    public int E() 
    {
        return E;
    }
    
    private void validateVertex(int v) 
    {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
    
    public void addEdge(int v, int w) 
    {
        validateVertex(v);
        validateVertex(w);
        adj.get(v).add(w); 
        indegree[w]++;
        E++;
    }
    
    public String toString() 
    {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(String.format("%d: ", v));
            for (int w : adj.get(v)) {
                s.append(String.format("%d ", w));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
    
    public static void main(String[] args) 
    {
    	DAG g = new DAG(13);
    	
    	g.addEdge(4, 2);
    	g.addEdge(2,3);
    	g.addEdge(3, 2);
    	g.addEdge(6,0);
    	g.addEdge(0, 1);
    	g.addEdge(2,0);
    	g.addEdge(11, 12);
    	g.addEdge(12,9);
    	
    	System.out.println(g.toString());
    }
}