package data;

import static org.junit.jupiter.api.Assertions.*; 

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircularLinkedListTest {
	static CircularLinkedList<Integer> cl1, cl2, cl3;
	static Integer [] in1, in2, in3, in4, in5, in6, in7, in8, in9, in10;
	static Integer [] res1, res2, res3, res4, res5, res6, res7, res8, 
	res9, res10, res11, res12, res13, res14, res15, res16, res17,
	res18, res19, res20, res21, res22, res23, res24, res25, res26,
	res27, res28, res29, res30, res31, res32, res33, res34, res35; 
	static Integer [] out1, out2, out3, out4, out5, out6, out7, out8, out9, out10;

	@BeforeEach
	void setUp()  {
		// head insert
		res1 = new Integer [] {3};
		res2 = new Integer [] {4, 3};
		res3 = new Integer [] {7, 4, 3};
		
		// tail insert
		res4 = new Integer [] {3};
		res5 = new Integer [] {3, 5}; 
		res6 = new Integer [] {3, 5, 7}; 
		
		// insert
		res7 = new Integer [] {7};
		res8 = new Integer [] {3, 7}; 
		res9 = new Integer [] {2, 3, 7}; 
		
		res10 = new Integer [] {1};
		res11 = new Integer [] {1, 4}; 
		res12 = new Integer [] {1, 4, 6}; 
		
		res13 = new Integer [] {6};
		res14 = new Integer [] {6, 8}; 
		res15 = new Integer [] {3, 6, 8}; 
		
		res16 = new Integer [] {11};
		res17 = new Integer [] {9, 11}; 
		res18 = new Integer [] {9, 11, 15}; 
		
		// head delete
		res19 = new Integer [] {3, 9, 1};
		res20 = new Integer [] {9, 1}; 
		res21 = new Integer [] {1}; 
		
		// tail delete
		res22 = new Integer [] {8, 3, 6};
		res23 = new Integer [] {8, 3};
		res24 = new Integer [] {8};
		
		// delete
		res25 = new Integer [] {11, 3, 5};
		res26 = new Integer [] {11, 3};
		res27 = new Integer [] {3, 5};
		res28 = new Integer [] {11, 5};
		res29 = new Integer [] {11, 3};
		res30 = new Integer [] {11};
		
		// search
		res31 = new Integer [] {-33, -13, 0, 2, 8, 16, 18};
		res32 = new Integer [] {-33, -33, -13, 0, 2, 8, 8, 16, 18, 18};
		
		cl1 = new CircularLinkedList<>();
		cl2 = new CircularLinkedList<>();
		cl3 = new CircularLinkedList<>();
		
		cl1.arrayToLinkedList(res31);
		cl2.arrayToLinkedList(res32);
		cl3.insert(3);
		
		// reverse
		res33 = new Integer [] {2, 7, 9, 4};
		res34 = new Integer [] {4, 9, 7, 2};
		
		// merge sort 
		in1 = new Integer [] {4, -2, -6, 5, 2, 1}; // mixed numbers, even length
		out1 = new Integer [] {-6, -2, 1, 2, 4, 5};
		in2 = new Integer [] {9, 2, 0, 3, 5, 1}; // positive numbers, even length
		out2 = new Integer [] {0, 1, 2, 3, 5, 9};
		in3 = new Integer [] {-9, -2, -7, -3, -5, -1}; // negative numbers, even length
		out3 = new Integer [] {-9, -7, -5, -3, -2, -1};
		in4 = new Integer [] {-9, 2, -7, 3, -5, 1, 2}; // duplicate numbers, even length
		out4 = new Integer [] {-9, -7, -5, 1, 2, 2, 3};
		in5 = new Integer [] {-9, 2, -7, 3, -5, 1, 2}; // duplicate numbers, odd length
		out5 = new Integer [] {-9, -7, -5, 1, 2, 2, 3};
		in6 = new Integer [] {-9, -2, -7, -3, -5}; // negative numbers, odd length
		out6 = new Integer [] {-9, -7, -5, -3, -2};
		in7 = new Integer [] {9, 2, 0, 3, 5}; // positive numbers, odd length
		out7 = new Integer [] {0, 2, 3, 5, 9};
		in8 = new Integer [] {4, -2, -6, 5, 2}; // mixed numbers, odd length
		out8 = new Integer [] {-6, -2, 2, 4, 5};
		in9 = new Integer [] {-6, -2, 1, 2, 4, 5}; // sorted
		out9 = new Integer [] {-6, -2, 1, 2, 4, 5};
		in10 = new Integer [] {5, 4, 2, 1, -2, -6}; // reverse sorted
		out10 = new Integer [] {-6, -2, 1, 2, 4, 5};
	}

	@Test
	void headInsert_AnyValue_AddsANodeToFront() {
		CircularLinkedList<Integer> cl = new CircularLinkedList<>();
		
		cl.headInsert(3);
		Integer [] arr1 = cl.storeList();
		
		cl.headInsert(4);
		Integer [] arr2 = cl.storeList();
	
		cl.headInsert(7);
		Integer [] arr3 = cl.storeList();
		
		assertArrayEquals(res1, arr1);
		assertArrayEquals(res2, arr2);
		assertArrayEquals(res3, arr3);
	}
	
	@Test
	void tailInsert_AnyValue_AddsANodeToBack() {
		CircularLinkedList<Integer> cl = new CircularLinkedList<>();

		cl.tailInsert(3);
		Integer [] arr1 = cl.storeList();
		
		cl.tailInsert(5);
		Integer [] arr2 = cl.storeList();
	
		cl.tailInsert(7);
		Integer [] arr3 = cl.storeList();	
		
		assertArrayEquals(res4, arr1);
		assertArrayEquals(res5, arr2);
		assertArrayEquals(res6, arr3);
	}
	
	@Test
	void insert_AnyValue_AddsANodeInSortedOrder() {
		CircularLinkedList<Integer> cl = new CircularLinkedList<>();
		
		cl.insert(7);
		Integer [] arr1 = cl.storeList();
		
		cl.insert(3);
		Integer [] arr2 = cl.storeList();
	
		cl.insert(2);
		Integer [] arr3 = cl.storeList();

		cl.clear();
		cl.insert(1);
		Integer [] arr4 = cl.storeList();
		
		cl.insert(4);
		Integer [] arr5 = cl.storeList();
	
		cl.insert(6);
		Integer [] arr6 = cl.storeList();
		
		cl.clear();
		cl.insert(6);
		Integer [] arr7 = cl.storeList();
		
		cl.insert(8);
		Integer [] arr8 = cl.storeList();
	
		cl.insert(3);
		Integer [] arr9 = cl.storeList();
		
		cl.clear();
		cl.insert(11);
		Integer [] arr10 = cl.storeList();
		
		cl.insert(9);
		Integer [] arr11 = cl.storeList();
	
		cl.insert(15);
		Integer [] arr12 = cl.storeList();
		
		assertArrayEquals(res7, arr1);
		assertArrayEquals(res8, arr2);
		assertArrayEquals(res9, arr3);
		assertArrayEquals(res10, arr4);
		assertArrayEquals(res11, arr5);
		assertArrayEquals(res12, arr6);
		assertArrayEquals(res13, arr7);
		assertArrayEquals(res14, arr8);
		assertArrayEquals(res15, arr9);
		assertArrayEquals(res16, arr10);
		assertArrayEquals(res17, arr11);
		assertArrayEquals(res18, arr12);
	}
	
	@Test
	void insertRecursive_AnyValue_AddsANodeInSortedOrder() {
		CircularLinkedList<Integer> cl = new CircularLinkedList<>();
		
		cl.insertRecursive(7);
		Integer [] arr1 = cl.storeList();
		
		cl.insertRecursive(3);
		Integer [] arr2 = cl.storeList();
	
		cl.insertRecursive(2);
		Integer [] arr3 = cl.storeList();

		cl.clear();
		cl.insertRecursive(1);
		Integer [] arr4 = cl.storeList();
		
		cl.insertRecursive(4);
		Integer [] arr5 = cl.storeList();
	
		cl.insertRecursive(6);
		Integer [] arr6 = cl.storeList();
		
		cl.clear();
		cl.insertRecursive(6);
		Integer [] arr7 = cl.storeList();
		
		cl.insertRecursive(8);
		Integer [] arr8 = cl.storeList();
	
		cl.insertRecursive(3);
		Integer [] arr9 = cl.storeList();
		
		cl.clear();
		cl.insertRecursive(11);
		Integer [] arr10 = cl.storeList();
		
		cl.insertRecursive(9);
		Integer [] arr11 = cl.storeList();
	
		cl.insertRecursive(15);
		Integer [] arr12 = cl.storeList();
		
		assertArrayEquals(res7, arr1);
		assertArrayEquals(res8, arr2);
		assertArrayEquals(res9, arr3);
		assertArrayEquals(res10, arr4);
		assertArrayEquals(res11, arr5);
		assertArrayEquals(res12, arr6);
		assertArrayEquals(res13, arr7);
		assertArrayEquals(res14, arr8);
		assertArrayEquals(res15, arr9);
		assertArrayEquals(res16, arr10);
		assertArrayEquals(res17, arr11);
		assertArrayEquals(res18, arr12);
	}
	
	@Test
	void headDelete_NodeInList_RemovesANodeFromFront() {
		CircularLinkedList<Integer> cl = new CircularLinkedList<>();

		cl.tailInsert(3);
		cl.tailInsert(9);
		cl.tailInsert(1);
		Integer [] arr1 = cl.storeList();
		
		cl.headDelete();
		Integer [] arr2 = cl.storeList();
		
		cl.headDelete();
		Integer [] arr3 = cl.storeList();
		
		cl.headDelete();
		Integer [] arr4 = cl.storeList();
		
		cl.headDelete();
		Integer [] arr5 = cl.storeList();
		
		assertArrayEquals(res19, arr1); // 3 9 1 
		assertArrayEquals(res20, arr2); // 9 1
		assertArrayEquals(res21, arr3); // 1
		assertNull(arr4); 
		assertNull(arr5); 
	}
	
	@Test
	void tailDelete_NodeInList_RemovesANodeFromBack() {
		CircularLinkedList<Integer> cl = new CircularLinkedList<>();

		cl.tailInsert(8);
		cl.tailInsert(3);
		cl.tailInsert(6);
		Integer [] arr1 = cl.storeList();
		
		cl.tailDelete();
		Integer [] arr2 = cl.storeList();
		
		cl.tailDelete();
		Integer [] arr3 = cl.storeList();
		
		cl.tailDelete();
		Integer [] arr4 = cl.storeList();
		
		cl.tailDelete();
		Integer [] arr5 = cl.storeList();
		
		assertArrayEquals(res22, arr1); // 8 3 6
		assertArrayEquals(res23, arr2); // 8 3 
		assertArrayEquals(res24, arr3); // 8
		assertNull(arr4); 
		assertNull(arr5);  
	}
	
	@Test
	void delete_NodeInList_RemovesANodeInSortedOrder() {
		CircularLinkedList<Integer> cl = new CircularLinkedList<>();
		
		cl.tailInsert(11);
		cl.tailInsert(3);
		cl.tailInsert(5);
		Integer [] arr1 = cl.storeList();
		
		cl.delete(7);
		Integer [] arr2 = cl.storeList();
		
		cl.delete(5);
		Integer [] arr3 = cl.storeList();
		
		cl.tailInsert(5);
		cl.delete(11);
		Integer [] arr4 = cl.storeList();
		
		cl.headInsert(11);
		cl.delete(3);
		Integer [] arr5 = cl.storeList();	
		
		cl.delete(11);
		cl.headInsert(3);
		cl.headInsert(11);
		cl.delete(5);
		Integer [] arr6 = cl.storeList();
		
		cl.delete(3);
		Integer [] arr7 = cl.storeList();
		
		cl.delete(11);
		Integer [] arr8 = cl.storeList();
		
		assertArrayEquals(res25, arr1); // 11 3 5
		assertArrayEquals(res25, arr2); // 11 3 5
		assertArrayEquals(res26, arr3); // 11 3
		assertArrayEquals(res27, arr4); // 3 5
		assertArrayEquals(res28, arr5); // 11 5 
		assertArrayEquals(res29, arr6); // 11 3 
		assertArrayEquals(res30, arr7); // 11 
		assertNull(arr8);  
	}
	
	@Test
	void deleteRecursive_NodeInList_RemovesANodeInSortedOrder() {
		CircularLinkedList<Integer> cl = new CircularLinkedList<>();
		
		cl.tailInsert(11);
		cl.tailInsert(3);
		cl.tailInsert(5);
		Integer [] arr1 = cl.storeList();
		
		cl.deleteRecursive(7);
		Integer [] arr2 = cl.storeList();
		
		cl.deleteRecursive(5);
		Integer [] arr3 = cl.storeList();
		
		cl.tailInsert(5);
		cl.deleteRecursive(11);
		Integer [] arr4 = cl.storeList();
		
		cl.headInsert(11);
		cl.deleteRecursive(3);
		Integer [] arr5 = cl.storeList();	
		
		cl.deleteRecursive(11);
		cl.headInsert(3);
		cl.headInsert(11);
		cl.deleteRecursive(5);
		Integer [] arr6 = cl.storeList();
		
		cl.deleteRecursive(3);
		Integer [] arr7 = cl.storeList();
		
		cl.deleteRecursive(11);
		Integer [] arr8 = cl.storeList();
		
		assertArrayEquals(res25, arr1); // 11 3 5
		assertArrayEquals(res25, arr2); // 11 3 5
		assertArrayEquals(res26, arr3); // 11 3
		assertArrayEquals(res27, arr4); // 3 5
		assertArrayEquals(res28, arr5); // 11 5 
		assertArrayEquals(res29, arr6); // 11 3 
		assertArrayEquals(res30, arr7); // 11 
		assertNull(arr8);
	}
	
	
	@Test
	void search_NodeInList_True() {
		assertTrue(cl1.search(-33)); // first item 
		assertTrue(cl1.search(0)); // item in between
		assertTrue(cl1.search(18)); // last item
		
		assertTrue(cl2.search(-33)); // first item 
		assertTrue(cl2.search(8)); // item in between
		assertTrue(cl2.search(18)); // last item
		
		assertTrue(cl3.search(3)); // one item 
	}
	
	@Test
	void search_NodeNotInList_False() {	
		assertFalse(cl1.search(-35)); // smaller than the first item 
		assertFalse(cl1.search(15)); // item in between
		assertFalse(cl1.search(24)); // larger than the last item 
		
		cl1.clear();
		assertFalse(cl1.search(24)); // null
	}	
	
	@Test
	void searchRecursive_NodeInList_True() {
		assertTrue(cl1.searchRecursive(-33)); // first item 
		assertTrue(cl1.searchRecursive(0)); // item in between 
		assertTrue(cl1.searchRecursive(18)); // last item 
		
		assertTrue(cl2.searchRecursive(-33)); // first item 
		assertTrue(cl2.searchRecursive(8)); // item in between 
		assertTrue(cl2.searchRecursive(18)); // last item
		
		assertTrue(cl3.searchRecursive(3)); // one item 
	}
	
	@Test
	void searchRecursive_NodeNotInList_False() {
		assertFalse(cl1.searchRecursive(-35)); // smaller than the first item 
		assertFalse(cl1.searchRecursive(15)); // item in between 
		assertFalse(cl1.searchRecursive(24)); // larger than the last item 
		
		cl1.clear();
		assertFalse(cl1.searchRecursive(24)); // null 
	}
	
	@Test
	void reverse_ListWithNodes_TurnsListBackward() {
		CircularLinkedList<Integer> cl = new CircularLinkedList<>();
		
		cl.reverse();
		
		cl.tailInsert(2);
		cl.reverse();
		
		cl.tailInsert(7);
		cl.tailInsert(9);
		cl.tailInsert(4);
		Integer [] arr1 = cl.storeList();
		
		cl.reverse();
		Integer [] arr2 = cl.storeList();
		
		cl.clear();
		Integer [] arr3 = cl.storeList();
		
		assertArrayEquals(res33, arr1); 
		assertArrayEquals(res34, arr2); 
		assertNull(arr3);
		
		cl.tailInsert(2);
		cl.tailInsert(7);
		cl.tailInsert(9);
		cl.reverse();
		Integer [] arr4 = cl.storeList();
		
		assertArrayEquals(new Integer [] {9, 7, 2},  arr4);
	}
	
	@Test
	void reverseRecursive_ListWithNodes_TurnsListBackward() {
		CircularLinkedList<Integer> cl = new CircularLinkedList<>();
		
		cl.reverseRecursive();
		
		cl.tailInsert(2);
		cl.reverseRecursive();
		
		cl.tailInsert(7);
		cl.tailInsert(9);
		cl.tailInsert(4);
		Integer [] arr1 = cl.storeList();
		
		cl.reverseRecursive();
		Integer [] arr2 = cl.storeList();
		
		cl.clear();
		Integer [] arr3 = cl.storeList();
		
		assertArrayEquals(res33, arr1); 
		assertArrayEquals(res34, arr2); 
		assertNull(arr3); 
		
		cl.tailInsert(2);
		cl.tailInsert(7);
		cl.tailInsert(9);
		cl.reverseRecursive();
		Integer [] arr4 = cl.storeList();
		
		assertArrayEquals(new Integer [] {9, 7, 2},  arr4);
	}
	
	@Test
	void clear_NodesInList_RemovesAllNodes() { 
		CircularLinkedList<Integer> cl = new CircularLinkedList<>();
		
		Integer [] arr0 = cl.storeList();
		
		assertNull(cl.getHead()); 
		assertNull(cl.getTail()); 
		
		cl.tailInsert(2);
		cl.tailInsert(7);
		cl.tailInsert(9);
		cl.tailInsert(4);
		cl.clear();
		Integer [] arr1 = cl.storeList();
		
		cl.clear();
		Integer [] arr2 = cl.storeList();
		
		assertNull(cl.getHead()); 
		assertNull(cl.getTail()); 
		
		assertNull(arr0); 
		assertNull(arr1); 
		assertNull(arr2); 
		assertEquals(0, cl.getSize());
	}
	
	@Test
	void headInsert_NoNodesInListAfterClear_AddsANode() { 
		CircularLinkedList<Integer> cl = new CircularLinkedList<>();
		
		Integer [] arr0 = cl.storeList();
		
		assertNull(cl.getHead()); 
		assertNull(cl.getTail()); 
		
		cl.tailInsert(2);
		cl.tailInsert(7);
		cl.tailInsert(9);
		cl.tailInsert(4);
		cl.clear();
		Integer [] arr1 = cl.storeList();
		
		cl.clear();
		Integer [] arr2 = cl.storeList();
		
		assertNull(cl.getHead()); 
		assertNull(cl.getTail()); 
		
		assertNull(arr0); 
		assertNull(arr1); 
		assertNull(arr2); 
		assertEquals(0, cl.getSize());
		
		cl.headInsert(3);
		Integer [] arr3 = cl.storeList();
		
		assertArrayEquals(res1, arr3);
	}
}
