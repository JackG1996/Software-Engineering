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
											
		BST.put(2, 2);   // 1       6		_12_

		BST.put(6, 6);   //  \     /	   /   \

		BST.put(4, 4);   //   2   4		 11      13
		
		BST.put(12, 12);
		
		BST.put(11,11);
		
		BST.put(13, 13);
		
		assertEquals("Checking the LCA of root and left node","7", BST.lca(7,3));
		
		assertEquals("Checking the LCA of root and right node","7", BST.lca(7,8));
		
		assertEquals("Checking the LCA of 1 and 6","3", BST.lca(1,6)); // checks for standard lca of a subtree 

		assertEquals("Cheking the LCA of 1 and 2","1", BST.lca(1,2)); // if only 1 child return the parent
		
		assertEquals("Checking the LCA of 11 and 13", "12", BST.lca(11,13)); // checks rhs lca of a subtree
		
		assertEquals("Checking the LCA of 12 and 4", "7", BST.lca(12,4)); // checks rhs and lhs lca both of which are in subtrees
		
		
		BST = new BinaryTree<Integer, Integer>();
		BST.put(7, 7);
		BST.put(8, 8);
		
		assertEquals("Checking the LCA of a tree with one child", "7", BST.lca(8,7));
		
		
	}
	
	
	@Test
	public void testPut()
	{
		BinaryTree<Integer, Integer> BST = new BinaryTree<Integer, Integer>();
		
		BST = new BinaryTree<Integer, Integer>();
		
		BST.put(7, 7);
		assertNull("Checking the LCA of a tree with no children", BST.lca(7,7)); // passing in the root twice will return null
		assertNull("Checking the LCA on a tree with one node", BST.lca(7,null)); // passing in null will return null also
		
		BST = new BinaryTree<Integer, Integer>();
		
		BST.put(null, 1);
		assertEquals("Testing when null key and valid value inserted", 0, BST.size());
		
		BST.put(1, null);
		assertEquals("Testing when valid key and null value inserted", 0, BST.size());

		BST.put(7, 7);   //        _7_
        BST.put(7, 8);   //        _7_
        assertEquals("Check if code properly insert nodes based upon key", 1, BST.size()); // size is one and not 2 despite two puts as keys are the same
        
  /*      BST.put(7, 7);   //        _7_
        BST.put(8, 7);   //        _7_
        assertEquals("Check if code properly registers that the same value has been inputted", 1, BST.size()); // size is one and not 2 despite two puts as value is same*/
      
		BST = new BinaryTree<Integer, Integer>();
		BST.put(7, 7);
		BST.put(10, 10);
		BST.put(12, 12);
		BST.put(6, 6);
		BST.put(3, 3);
		BST.put(5, 5);
	
		assertNull("Checking LCA of a node that is not present", BST.lca(4, 6));
		assertNull("Checking LCA of two nodes that are not present", BST.lca(4, 2));
		
    	BST = new BinaryTree<Integer, Integer>();
        BST.put(7, 7);   //        _7_
        BST.put(8, 8);   //      /     \
        BST.put(3, 3);   //    _3_      8
        BST.put(1, 1);   //  /     \
        BST.put(2, 2);   // 1       6
        BST.put(6, 6);   //  \     /
        BST.put(4, 4);   //   2   4
        BST.put(5, 5);   //  /     \
                         //         5
        assertEquals("Check if the nodes are inserted in the correct order", "(((()1(()2()))3((()4(()5()))6()))7(()8()))", BST.printKeysInOrder());
		
	}
	
	@Test
	public void testLcaNegative()
	{
		BinaryTree<Integer, Integer> BST = new BinaryTree<Integer, Integer>();  
		BST = new BinaryTree<Integer, Integer>();

		BST.put(7, 7);  
		BST.put(-8, -8);   
		BST.put(-6, -6);
		BST.put(-9, -9);   
		BST.put(10, 10);
		
		assertEquals("Checking the lca of negative nodes", "-8", BST.lca(-6, -9));
		
		assertEquals("Checking the lca of a negative node and a positive node", "7", BST.lca(10, -9));
		
	}
		
}