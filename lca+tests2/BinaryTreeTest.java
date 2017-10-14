import static org.junit.Assert.*;
import org.junit.Test;	  	
import org.junit.runner.RunWith;	  	
import org.junit.runners.JUnit4;

public class BinaryTreeTest 
{
	@Test	  	
	 public void testLca()
	{
		BinaryTree<Integer, Integer> BST = new BinaryTree<Integer, Integer>();  
		BST = new BinaryTree<Integer, Integer>();

		BST.put(7, 7);   //        _7_

		BST.put(8, 8);   //      /     \

		BST.put(3, 3);   //    _3_      8

		BST.put(1, 1);   //  /     \      \
											
		BST.put(2, 2);   // 1       6		12

		BST.put(6, 6);   //  \     /	   /   \

		BST.put(4, 4);   //   2   4		 11      13
		
		BST.put(12, 12);
		
		BST.put(11,11);
		
		BST.put(13, 13);
		
		assertEquals("Checking the LCA of 1 and 6","3", BST.lca(1,6)); // checks for lca 

		assertEquals("Cheking the LCA of 1 and 2","1", BST.lca(1,2)); // if only 1 child return the parent
		
		assertEquals("Checking the LCA of 11 and 13", "12", BST.lca(11,13)); // checks rhs lca
		
	}
	
	@Test
	public void testLcaNull()
	{
		BinaryTree<Integer, Integer> BST = new BinaryTree<Integer, Integer>(); 
		
		BST = new BinaryTree<Integer, Integer>();
		assertNull("Checking if the root is null", BST.lca(1,3));
		
		BST = new BinaryTree<Integer, Integer>();
		BST.put(1, 1);
		BST.put(2,null);
	
		assertNull("Checking if LCA is null when child node is null", BST.lca(1, 2));
		
		BST = new BinaryTree<Integer, Integer>();
		BST.put(1, null);
		BST.put(2,null);
		
		assertNull("Checking if LCA is null when both nodes are null", BST.lca(1, 2));
		
		BST = new BinaryTree<Integer, Integer>();
		BST.put(null, null);
		BST.put(null,null);
		
		assertNull("Checking if LCA is null when both nodes are null", BST.lca(null, null));
		
	}

	
}