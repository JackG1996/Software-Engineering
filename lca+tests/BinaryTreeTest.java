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

		BST.put(1, 1);   //  /     \

		BST.put(2, 2);   // 1       6

		BST.put(6, 6);   //  \     /

		BST.put(4, 4);   //   2   4

		assertEquals("Checking the LCA of 1 and 6","3", BST.lca(1,6));

		assertEquals("Cheking the LCA of 1 and 2","1", BST.lca(1,2));
	}
}
