import static org.junit.Assert.*;

import org.junit.Test;

public class DAGtests {

	DAG dag = new DAG();

	
	@Test
	public void testEdges() 
	{
		DagNode A = new DagNode("A", dag);
		DagNode B = new DagNode("B", dag);
		DagNode C = new DagNode("C", dag);
		DagNode D = new DagNode("D", dag);
		
		dag.addEdge(B, A);
		dag.addEdge(C, B);
		dag.addEdge(C, D);
		
		assertEquals("There are 3 edges in this DAG", 3, dag.E());
		
		DagNode F = new DagNode("F", dag);
		dag.addEdge(F,C);
		
		assertEquals("There are now 4 edges in this DAG", 4, dag.E());
		
		assertTrue("There is an edge from A to B with B as the parent of A",dag.validateEdges(B, A));
		assertTrue("There is an edge from B to C with C as the parent of B",dag.validateEdges(C, B));
		assertFalse("There is no edge from B to D",dag.validateEdges(D, B));
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
		
		dag.addEdge(B, A);
		dag.addEdge(C, B);
		dag.addEdge(C, D);
		
		assertEquals("The LCA of this DAG is..", "C", dag.LCA(bfs, dag, A, D));
		
		
	}

}