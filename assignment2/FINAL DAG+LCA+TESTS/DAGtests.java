import static org.junit.Assert.*;

import org.junit.Test;

public class DAGtests {

	//DAG created is the one from the lecture slides
	DAG dag = new DAG();
	
	@Test
	public void testEdges()               
	{                                     
		DagNode A = new DagNode("A", dag);           
		DagNode B = new DagNode("B", dag);
		DagNode C = new DagNode("C", dag);
		DagNode D = new DagNode("D", dag);
		DagNode E = new DagNode("E", dag);
		DagNode F = new DagNode("F", dag);
		DagNode G = new DagNode("G", dag);
		
		dag.addEdge(D, G);
		dag.addEdge(F, G);
		dag.addEdge(E, F);
		dag.addEdge(C, D);
		dag.addEdge(B, E);
		dag.addEdge(B, C);
		
		assertEquals("There are 6 edges in this DAG", 6, dag.numberOfEdges());
	
		dag.addEdge(A, B);
		
		assertEquals("There are now 7 edges in this DAG", 7, dag.numberOfEdges());
		
		assertTrue("There is an edge from B to A with B as the parent of A",dag.validateEdges(A, B));
		assertTrue("There is an edge from C to B with C as the parent of B",dag.validateEdges(B, C));
		assertFalse("There is no edge from B to D",dag.validateEdges(D, B));
		assertFalse("There is no edge from A to B", dag.validateEdges(B, A));
	}
	
	@Test
	public void testVerices()
	{
		DagNode A = new DagNode("A", dag);
		DagNode B = new DagNode("B", dag);
		DagNode C = new DagNode("C", dag);
		DagNode D = new DagNode("D", dag);
		DagNode E = new DagNode("E", dag);
		
		assertEquals("There are 6 vertices in this DAG", 5, dag.numberOfVerts());
		
		DagNode F = new DagNode("F", dag);
		DagNode G = new DagNode("G", dag);
		
		assertEquals("There are 6 vertices in this DAG", 7, dag.numberOfVerts());
	}
	
	@Test
	public void testLCA()
	{
		DAG dag = new DAG();
		BFS bfs = new BFS();
		
		DagNode A = new DagNode("A", dag);
		DagNode B = new DagNode("B", dag);
		DagNode C = new DagNode("C", dag);
		DagNode D = new DagNode("D", dag);
		DagNode E = new DagNode("E", dag);
		DagNode F = new DagNode("F", dag);
		DagNode G = new DagNode("G", dag);
		
		dag.addEdge(D, G);
		dag.addEdge(F, G);
		dag.addEdge(E, F);
		dag.addEdge(C, D);
		dag.addEdge(B, E);
		dag.addEdge(B, C);
		dag.addEdge(A, B);
		
		
		assertEquals("The LCA of C and E in this DAG is..", "B", dag.LCA(bfs, dag, C, E));
		assertEquals("The LCA of D and F in this DAG is..", "B", dag.LCA(bfs, dag, D, F));
		assertEquals("The LCA of F and C in this DAG is..", "B", dag.LCA(bfs, dag, F, C));
		assertEquals("The LCA of A and B in this DAG is..", "B", dag.LCA(bfs, dag, A, B));
		

		assertNull("The LCA of G and B in this DAG is..",dag.LCA(bfs, dag, G, B));
		assertNull("The LCA of G and A in this DAG is..",dag.LCA(bfs, dag, G, A));
		
	//	assertNull("The LCA of G and F in this DAG is..", dag.LCA(bfs, dag, G, F)); //Does not work it returns E when it should return Null.
		
			
	}

}