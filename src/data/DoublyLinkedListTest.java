package data;

import static org.junit.jupiter.api.Assertions.*; 

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DoublyLinkedListTest {
	static DoublyLinkedList<Integer> sl1, sl2, sl3;
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
		
		sl1 = new DoublyLinkedList<>();
		sl2 = new DoublyLinkedList<>();
		sl3 = new DoublyLinkedList<>();
		
		sl1.arrayToLinkedList(res31);
		sl2.arrayToLinkedList(res32);
		sl3.insert(3);
		
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
		DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();
		
		dl.headInsert(3);
		Integer [] arr1 = dl.storeList();
		
		dl.headInsert(4);
		Integer [] arr2 = dl.storeList();
	
		dl.headInsert(7);
		Integer [] arr3 = dl.storeList();
		
		assertArrayEquals(res1, arr1);
		assertArrayEquals(res2, arr2);
		assertArrayEquals(res3, arr3);
	}
	
	@Test
	void tailInsert_AnyValue_AddsANodeToBack() {
		DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();

		dl.tailInsert(3);
		Integer [] arr1 = dl.storeList();
		
		dl.tailInsert(5);
		Integer [] arr2 = dl.storeList();
	
		dl.tailInsert(7);
		Integer [] arr3 = dl.storeList();	
		
		assertArrayEquals(res4, arr1);
		assertArrayEquals(res5, arr2);
		assertArrayEquals(res6, arr3);
	}
	
	@Test
	void insert_AnyValue_AddsANodeInSortedOrder() {
		DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();
		
		dl.insert(7);
		Integer [] arr1 = dl.storeList();
		
		dl.insert(3);
		Integer [] arr2 = dl.storeList();
	
		dl.insert(2);
		Integer [] arr3 = dl.storeList();

		dl.clear();
		dl.insert(1);
		Integer [] arr4 = dl.storeList();
		
		dl.insert(4);
		Integer [] arr5 = dl.storeList();
	
		dl.insert(6);
		Integer [] arr6 = dl.storeList();
		
		dl.clear();
		dl.insert(6);
		Integer [] arr7 = dl.storeList();
		
		dl.insert(8);
		Integer [] arr8 = dl.storeList();
	
		dl.insert(3);
		Integer [] arr9 = dl.storeList();
		
		dl.clear();
		dl.insert(11);
		Integer [] arr10 = dl.storeList();
		
		dl.insert(9);
		Integer [] arr11 = dl.storeList();
	
		dl.insert(15);
		Integer [] arr12 = dl.storeList();
		
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
		DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();
		
		dl.insertRecursive(7);
		Integer [] arr1 = dl.storeList();
		
		dl.insertRecursive(3);
		Integer [] arr2 = dl.storeList();
	
		dl.insertRecursive(2);
		Integer [] arr3 = dl.storeList();

		dl.clear();
		dl.insertRecursive(1);
		Integer [] arr4 = dl.storeList();
		
		dl.insertRecursive(4);
		Integer [] arr5 = dl.storeList();
	
		dl.insertRecursive(6);
		Integer [] arr6 = dl.storeList();
		
		dl.clear();
		dl.insertRecursive(6);
		Integer [] arr7 = dl.storeList();
		
		dl.insertRecursive(8);
		Integer [] arr8 = dl.storeList();
	
		dl.insertRecursive(3);
		Integer [] arr9 = dl.storeList();
		
		dl.clear();
		dl.insertRecursive(11);
		Integer [] arr10 = dl.storeList();
		
		dl.insertRecursive(9);
		Integer [] arr11 = dl.storeList();
	
		dl.insertRecursive(15);
		Integer [] arr12 = dl.storeList();
		
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
		DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();

		dl.tailInsert(3);
		dl.tailInsert(9);
		dl.tailInsert(1);
		Integer [] arr1 = dl.storeList();
		
		dl.headDelete();
		Integer [] arr2 = dl.storeList();
		
		dl.headDelete();
		Integer [] arr3 = dl.storeList();
		
		dl.headDelete();
		Integer [] arr4 = dl.storeList();
		
		dl.headDelete();
		Integer [] arr5 = dl.storeList();
		
		assertArrayEquals(res19, arr1); // 3 9 1 
		assertArrayEquals(res20, arr2); // 9 1
		assertArrayEquals(res21, arr3); // 1
		assertNull(arr4); 
		assertNull(arr5); 
	}
	
	@Test
	void tailDelete_NodeInList_RemovesANodeFromBack() {
		DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();

		dl.tailInsert(8);
		dl.tailInsert(3);
		dl.tailInsert(6);
		Integer [] arr1 = dl.storeList();
		
		dl.tailDelete();
		Integer [] arr2 = dl.storeList();
		
		dl.tailDelete();
		Integer [] arr3 = dl.storeList();
		
		dl.tailDelete();
		Integer [] arr4 = dl.storeList();
		
		dl.tailDelete();
		Integer [] arr5 = dl.storeList();
		
		assertArrayEquals(res22, arr1); // 8 3 6
		assertArrayEquals(res23, arr2); // 8 3 
		assertArrayEquals(res24, arr3); // 8
		assertNull(arr4); 
		assertNull(arr5); 
	}
	
	@Test
	void delete_NodeInList_RemovesANodeInSortedOrder() {
		DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();
		
		dl.tailInsert(11);
		dl.tailInsert(3);
		dl.tailInsert(5);
		Integer [] arr1 = dl.storeList();
		
		dl.delete(7);
		Integer [] arr2 = dl.storeList();
		
		dl.delete(5);
		Integer [] arr3 = dl.storeList();
		
		dl.tailInsert(5);
		dl.delete(11);
		Integer [] arr4 = dl.storeList();
		
		dl.headInsert(11);
		dl.delete(3);
		Integer [] arr5 = dl.storeList();	
		
		dl.delete(11);
		dl.headInsert(3);
		dl.headInsert(11);
		dl.delete(5);
		Integer [] arr6 = dl.storeList();
		
		dl.delete(3);
		Integer [] arr7 = dl.storeList();
		
		dl.delete(11);
		Integer [] arr8 = dl.storeList();
		
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
	void deleteRecursive_NodeInList_RemovesANodeInSortedOrderr() {
		DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();
		
		dl.tailInsert(11);
		dl.tailInsert(3);
		dl.tailInsert(5);
		Integer [] arr1 = dl.storeList();
		
		dl.deleteRecursive(7);
		Integer [] arr2 = dl.storeList();
		
		dl.deleteRecursive(5);
		Integer [] arr3 = dl.storeList();
		
		dl.tailInsert(5);
		dl.deleteRecursive(11);
		Integer [] arr4 = dl.storeList();
		
		dl.headInsert(11);
		dl.deleteRecursive(3);
		Integer [] arr5 = dl.storeList();	
		
		dl.deleteRecursive(11);
		dl.headInsert(3);
		dl.headInsert(11);
		dl.deleteRecursive(5);
		Integer [] arr6 = dl.storeList();
		
		dl.deleteRecursive(3);
		Integer [] arr7 = dl.storeList();
		
		dl.deleteRecursive(11);
		Integer [] arr8 = dl.storeList();
		
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
		assertTrue(sl1.search(-33)); // first item 
		assertTrue(sl1.search(0)); // item in between
		assertTrue(sl1.search(18)); // last item
		
		assertTrue(sl2.search(-33)); // first item 
		assertTrue(sl2.search(8)); // item in between
		assertTrue(sl2.search(18)); // last item
		
		assertTrue(sl3.search(3)); // one item 
	}
	
	@Test
	void search_NodeNotInList_False() {	
		assertFalse(sl1.search(-35)); // smaller than the first item 
		assertFalse(sl1.search(15)); // item in between
		assertFalse(sl1.search(24)); // larger than the last item 
		
		sl1.clear();
		assertFalse(sl1.search(24)); // null
	}	
	
	@Test
	void searchRecursive_NodeInList_True() {
		assertTrue(sl1.searchRecursive(-33)); // first item 
		assertTrue(sl1.searchRecursive(0)); // item in between 
		assertTrue(sl1.searchRecursive(18)); // last item 
		
		assertTrue(sl2.searchRecursive(-33)); // first item 
		assertTrue(sl2.searchRecursive(8)); // item in between 
		assertTrue(sl2.searchRecursive(18)); // last item
		
		assertTrue(sl3.searchRecursive(3)); // one item 
	}
	
	@Test
	void searchRecursive_NodeNotInList_False() {
		assertFalse(sl1.searchRecursive(-35)); // smaller than the first item 
		assertFalse(sl1.searchRecursive(15)); // item in between 
		assertFalse(sl1.searchRecursive(24)); // larger than the last item 
		
		sl1.clear();
		assertFalse(sl1.searchRecursive(24)); // null 
	}
	
	@Test
	void reverse_ListWithNodes_TurnsListBackward() {
		DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();
		
		// no nodes
		dl.reverse();
		
		// one node
		dl.tailInsert(2);
		dl.reverse();

		// even number of nodes
		dl.tailInsert(7);
		dl.tailInsert(9);
		dl.tailInsert(4);
		Integer [] arr1 = dl.storeList();
		
		dl.reverse();
		Integer [] arr2 = dl.storeList();
		
		dl.clear();
		Integer [] arr3 = dl.storeList();
		
		assertArrayEquals(res33, arr1); 
		assertArrayEquals(res34, arr2); 
		assertNull(arr3);
		
		// odd number of nodes
		dl.tailInsert(7);
		dl.tailInsert(9);
		dl.tailInsert(4);
		dl.reverse();
		Integer [] arr4 = dl.storeList();
		
		assertArrayEquals(new Integer [] {4, 9, 7},  arr4);
	}
	
	@Test
	void reverseRecursive_ListWithNodes_TurnsListBackward() {
		DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();
		
		dl.reverseRecursive();
		
		dl.tailInsert(2);
		dl.reverseRecursive();
		
		dl.tailInsert(7);
		dl.tailInsert(9);
		dl.tailInsert(4);
		Integer [] arr1 = dl.storeList();
		
		dl.reverseRecursive();
		Integer [] arr2 = dl.storeList();
		
		dl.clear();
		Integer [] arr3 = dl.storeList();
		
		assertArrayEquals(res33, arr1); 
		assertArrayEquals(res34, arr2); 
		assertNull(arr3);
		
		dl.tailInsert(7);
		dl.tailInsert(9);
		dl.tailInsert(4);
		dl.reverseRecursive();
		
		Integer [] arr4 = dl.storeList();
		
		assertArrayEquals(new Integer [] {4, 9, 7},  arr4);
	}

	@Test
	void mergeSort_ListWithNodes_SortsList() {
		DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();
		
		dl.arrayToLinkedList(in1);
		dl.mergeSort();
		Integer [] arr1 = dl.storeList();
		assertArrayEquals(out1, arr1); // positive and negative numbers, even length 
	
		dl.arrayToLinkedList(in2);
		dl.mergeSort();
		Integer [] arr2 = dl.storeList();
		assertArrayEquals(out2, arr2); // positive numbers, even length 
		
		dl.arrayToLinkedList(in3);
		dl.mergeSort();
		Integer [] arr3 = dl.storeList();
		assertArrayEquals(out3, arr3);  // negative numbers, even length
		
		dl.arrayToLinkedList(in4);
		dl.mergeSort();
		Integer [] arr4 = dl.storeList();
		assertArrayEquals(out4, arr4); // positive and negative numbers, duplicates, even length 
		
		dl.arrayToLinkedList(in5);
		dl.mergeSort();
		Integer [] arr5 = dl.storeList();
		assertArrayEquals(out5, arr5); // positive and negative numbers, duplicates, odd length 
		
		dl.arrayToLinkedList(in6);
		dl.mergeSort();
		Integer [] arr6 = dl.storeList();
		assertArrayEquals(out6, arr6); // negative numbers, odd length 
		
		dl.arrayToLinkedList(in7);
		dl.mergeSort();
		Integer [] arr7 = dl.storeList();
		assertArrayEquals(out7, arr7); // positive numbers, odd length 
		
		dl.arrayToLinkedList(in8);
		dl.mergeSort();
		Integer [] arr8 = dl.storeList();
		assertArrayEquals(out8, arr8); // positive and negative numbers, odd length 
		
		dl.arrayToLinkedList(in9);
		dl.mergeSort();
		Integer [] arr9 = dl.storeList();
		assertArrayEquals(out9, arr9); // sorted
		
		dl.arrayToLinkedList(in10);
		dl.mergeSort();
		Integer [] arr10 = dl.storeList();
		assertArrayEquals(out10, arr10); // reverse sorted 
		
		dl.clear();
		dl.mergeSort();
		arr1 = dl.storeList();
		assertNull(arr1); 
	}
	
	@Test
	void clear_NodesInList_RemovesAllNodes() { 
		DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();
		
		Integer [] arr0 = dl.storeList();
		
		assertNull(dl.getHead()); 
		assertNull(dl.getTail()); 
		
		dl.tailInsert(2);
		dl.tailInsert(7);
		dl.tailInsert(9);
		dl.tailInsert(4);
		dl.clear();
		Integer [] arr1 = dl.storeList();
		
		dl.clear();
		Integer [] arr2 = dl.storeList();
		
		assertNull(dl.getHead()); 
		assertNull(dl.getTail()); 
		
		assertNull(arr0); 
		assertNull(arr1); 
		assertNull(arr2); 
		assertEquals(0, dl.getSize());
	}
	
	
	@Test
	void headInsert_NoNodesInListAfterClear_AddsANode() { 
		DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();
		
		Integer [] arr0 = dl.storeList();
		
		assertNull(dl.getHead()); 
		assertNull(dl.getTail()); 
		
		dl.tailInsert(2);
		dl.tailInsert(7);
		dl.tailInsert(9);
		dl.tailInsert(4);
		dl.clear();
		Integer [] arr1 = dl.storeList();
		
		dl.clear();
		Integer [] arr2 = dl.storeList();
		
		assertNull(dl.getHead()); 
		assertNull(dl.getTail()); 
		
		assertNull(arr0); 
		assertNull(arr1); 
		assertNull(arr2); 
		assertEquals(0, dl.getSize());
		
		
		dl.headInsert(3);
		Integer [] arr3 = dl.storeList();
		
		assertArrayEquals(res1, arr3);
	}

}
