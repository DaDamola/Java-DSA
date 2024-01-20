package data;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BSTTest {			
	static Integer [] res1, res2, res3, res4, res5, res6, res7, res8, res9,
	res10, res11, res12, res13, res14, res15, res16, res17, res18, res19,
	res20, res21, res22, res23, res24, res25, res26, res27, res28, res29,
	res30, res31;
	
	@BeforeAll
	static void setUp() {
		// insert 
		res1 = new Integer [] {23};
		res2 = new Integer [] {23};
		res3 = new Integer [] {23};
		
		res4 = new Integer [] {23, 30};
		res5 = new Integer [] {23, 30};
		res6 = new Integer [] {30, 23};
		
		res7 = new Integer [] {23, 7, 30};
		res8 = new Integer [] {7, 23, 30};
		res9 = new Integer [] {7, 30, 23};
		
		res10 = new Integer [] {23, 7, 3, 30};
		res11 = new Integer [] {3, 7, 23, 30};
		res12 = new Integer [] {3, 7, 30, 23};
		
		res13 = new Integer [] {23, 7, 3, 30, 35};
		res14 = new Integer [] {3, 7, 23, 30, 35};
		res15 = new Integer [] {3, 7, 35, 30, 23};
		
		// delete
		res13 = new Integer [] {23, 7, 3, 30, 35};
		res14 = new Integer [] {3, 7, 23, 30, 35};
		res15 = new Integer [] {3, 7, 35, 30, 23};
		
		res16 = new Integer [] {7, 3, 30, 35};
		res17 = new Integer [] {3, 7, 30, 35};
		res18 = new Integer [] {3, 35, 30, 7};
		
		res19 = new Integer [] {7, 2, 30, 35};
		res20 = new Integer [] {2, 7, 30, 35};
		res21 = new Integer [] {2, 35, 30, 7};
		
		res22 = new Integer [] {7, 2, 35};
		res23 = new Integer [] {2, 7, 35};
		res24 = new Integer [] {2, 35, 7};
		
		res25 = new Integer [] {7, 2};
		res26 = new Integer [] {2, 7};
		res27 = new Integer [] {2, 7};
		
		// max 
		res28 = new Integer [] {35};
		res29 = new Integer [] {23};
		
		// min 
		res30 = new Integer [] {3};
		res31 = new Integer [] {23};
	}

	@Test
	void insert_AnyValue_AddsANode() {
		BST<Integer> root = new BST<>();
		
		Integer [] out1 = root.storePreorderTree();
		
		root.insert(23);
		Integer [] pre1 = root.storePreorderTree();
		Integer [] in1 = root.storeInorderTree();
		Integer [] post1 = root.storePostorderTree();
		
		root.insert(30);
		Integer [] pre2 = root.storePreorderTree();
		Integer [] in2 = root.storeInorderTree();
		Integer [] post2 = root.storePostorderTree();
		
		root.insert(7);
		Integer [] pre3 = root.storePreorderTree();
		Integer [] in3 = root.storeInorderTree();
		Integer [] post3 = root.storePostorderTree();
		
		root.insert(3);
		Integer [] pre4 = root.storePreorderTree();
		Integer [] in4 = root.storeInorderTree();
		Integer [] post4 = root.storePostorderTree();
		
		root.insert(35);
		Integer [] pre5 = root.storePreorderTree();
		Integer [] in5 = root.storeInorderTree();
		Integer [] post5 = root.storePostorderTree();
		
		// empty
		assertNull(out1); 
		
		assertArrayEquals(res1, pre1);
		assertArrayEquals(res2, in1);
		assertArrayEquals(res3, post1);
		
		assertArrayEquals(res4, pre2);
		assertArrayEquals(res5, in2);
		assertArrayEquals(res6, post2);
		
		assertArrayEquals(res7, pre3);
		assertArrayEquals(res8, in3);
		assertArrayEquals(res9, post3);
		
		assertArrayEquals(res10, pre4);
		assertArrayEquals(res11, in4);
		assertArrayEquals(res12, post4);
		
		assertArrayEquals(res13, pre5);
		assertArrayEquals(res14, in5);
		assertArrayEquals(res15, post5);
	}
	
	@Test
	void search_NodeIsInTree_True() {
		BST<Integer> root = new BST<>();
		
		root.insert(23);
		root.insert(30);
		root.insert(7);
		root.insert(3);	
		root.insert(35);

		assertTrue(root.search(23)); // root has two children 
		assertTrue(root.search(7)); // has one left child
		assertTrue(root.search(30)); // has one right child
		assertTrue(root.search(3)); // leaf node
	}
	
	@Test
	void search_NodeIsInTree_False() {
		BST<Integer> root = new BST<>();
		
		assertFalse(root.search(1)); 
		
		root.insert(23);
		root.insert(30);
		root.insert(7);
		root.insert(3);	
		root.insert(35);

		assertFalse(root.search(1)); 
		assertFalse(root.search(4)); 
		assertFalse(root.search(9)); 
		assertFalse(root.search(25)); 
		assertFalse(root.search(33)); 
		assertFalse(root.search(38)); 
	}
	
	@Test
	void delete_AnyValue_RemovesANode() {
		BST<Integer> root = new BST<>();
		
		root.delete(33);
		Integer [] out1 = root.storePreorderTree();
		
		root.insert(23);
		root.insert(30);
		root.insert(7);
		root.insert(3);	
		root.insert(35);
		
		root.delete(33);
		Integer [] pre1 = root.storePreorderTree();
		Integer [] in1 = root.storeInorderTree();
		Integer [] post1 = root.storePostorderTree();
		
		root.delete(23);
		Integer [] pre2 = root.storePreorderTree();
		Integer [] in2 = root.storeInorderTree();
		Integer [] post2 = root.storePostorderTree();
		
		root.insert(2);
		root.delete(3);
		Integer [] pre3 = root.storePreorderTree();
		Integer [] in3 = root.storeInorderTree();
		Integer [] post3 = root.storePostorderTree();
		
		root.delete(30);
		Integer [] pre4 = root.storePreorderTree();
		Integer [] in4 = root.storeInorderTree();
		Integer [] post4 = root.storePostorderTree();
		
		root.delete(35);
		Integer [] pre5 = root.storePreorderTree();
		Integer [] in5 = root.storeInorderTree();
		Integer [] post5 = root.storePostorderTree();
		
		// empty
		assertArrayEquals(null,  out1); 
		
		// the value does not exist 
		assertArrayEquals(res13, pre1); 
		assertArrayEquals(res14, in1);
		assertArrayEquals(res15, post1);
		
		// root has two children
		assertArrayEquals(res16, pre2);
		assertArrayEquals(res17, in2);
		assertArrayEquals(res18, post2);
		
		// has one left child
		assertArrayEquals(res19, pre3);
		assertArrayEquals(res20, in3);
		assertArrayEquals(res21, post3);
		
		// has one right child
		assertArrayEquals(res22, pre4);
		assertArrayEquals(res23, in4);
		assertArrayEquals(res24, post4);
		
		// leaf node 
		assertArrayEquals(res25, pre5);
		assertArrayEquals(res26, in5);
		assertArrayEquals(res27, post5);
	}
	
	@Test
	void getMax_NodesInTree_LargestValue() {
		BST<Integer> root = new BST<>();
		
		Integer out0 = root.getMax();
		
		root.insert(23);
		root.insert(30);
		root.insert(7);
		root.insert(3);	
		root.insert(35);
		Integer out1 = root.getMax();
		
		root.delete(35);
		root.delete(30);
		Integer out2 = root.getMax();
		
		assertNull(out0); // empty
		assertEquals(res28[0], out1); // leaf node 
		assertEquals(res29[0], out2); // root  
	}
	
	@Test
	void getMaxRecursive_NodesInTree_LargestValue() {
		BST<Integer> root = new BST<>();
		
		Integer out0 = root.getMaxRecursive();
		
		root.insert(23);
		root.insert(30);
		root.insert(7);
		root.insert(3);	
		root.insert(35);
		Integer out1 = root.getMaxRecursive();
		
		root.delete(35);
		root.delete(30);
		Integer out2 = root.getMaxRecursive();
		
		assertNull(out0); // empty
		assertEquals(res28[0], out1); // leaf node 
		assertEquals(res29[0], out2); // root  
	}
	
	@Test
	void getMin_NodesInTree_SmallestValue() {
		BST<Integer> root = new BST<>();
		
		Integer out0 = root.getMin();
		
		root.insert(23);
		root.insert(30);
		root.insert(7);
		root.insert(3);	
		root.insert(35);
		Integer out1 = root.getMin();
		
		root.delete(3);
		root.delete(7);
		Integer out2 = root.getMin();
		
		assertNull(out0); // empty
		assertEquals(res30[0], out1); // leaf node 
		assertEquals(res31[0], out2); // root  
	}
	
	@Test
	void getMinRecursive_NodesInTree_SmallestValue() {
		BST<Integer> root = new BST<>();
		
		Integer out0 = root.getMinRecursive();
		
		root.insert(23);
		root.insert(30);
		root.insert(7);
		root.insert(3);	
		root.insert(35);	
		Integer out1 = root.getMinRecursive();
		
		root.delete(3);
		root.delete(7);
		Integer out2 = root.getMinRecursive();
		
		assertNull(out0); // empty
		assertEquals(res30[0], out1); // leaf node 
		assertEquals(res31[0], out2); // root 
	}
	
	@Test
	void clear_NoTree_HasAnEmptyTree() {
		BST<Integer> root = new BST<>();
		
		assertNull(root.getRoot());
		
		root.insert(23);
		root.insert(30);
		root.insert(7);
		root.insert(3);	
		root.insert(35);
		
		root.clear();
		assertNull(root.getRoot());
		
		root.clear();
		assertNull(root.getRoot());
		
		assertNull(root.storePreorderTree()); 
		assertNull(root.storeInorderTree()); 
		assertNull(root.storePostorderTree()); 
		assertEquals(0, root.getSize());
	}
	
	@Test
	void clear_NoNodesInTreeAfterClear_AddsANode() {
		BST<Integer> root = new BST<>();
		
		assertNull(root.getRoot());
		
		root.insert(23);
		root.insert(30);
		root.insert(7);
		root.insert(3);	
		root.insert(35);
		
		root.clear();
		assertNull(root.getRoot());
		
		root.clear();
		assertNull(root.getRoot());
		
		assertNull(root.storePreorderTree()); 
		assertNull(root.storeInorderTree()); 
		assertNull(root.storePostorderTree()); 
		assertEquals(0, root.getSize());
		
		root.insert(23);
		Integer [] pre1 = root.storePreorderTree();
		Integer [] in1 = root.storeInorderTree();
		Integer [] post1 = root.storePostorderTree();
		
		assertArrayEquals(res1, pre1);
		assertArrayEquals(res2, in1);
		assertArrayEquals(res3, post1);
	}
}
