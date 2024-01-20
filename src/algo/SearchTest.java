package algo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SearchTest {
	static int [] arr1, arr2, arr3, arr4; 
	
	@BeforeAll
	static void setup() {
		arr1 = new int [] {-33, -13, 0, 2, 8, 16, 18};
		arr2 = new int [] {-33, -33, -13, 0, 2, 8, 8, 16, 18, 18};
		arr3 = new int [] {};
		arr4 = null; 
	}
	
	@Test
	void linearSearch_KeyIsInArray_True() {
		assertTrue(Search.linearSearch(arr1, -33));
		assertTrue(Search.linearSearch(arr1, 0));
		assertTrue(Search.linearSearch(arr1, 18));
		assertTrue(Search.linearSearch(arr2, -33));
		assertTrue(Search.linearSearch(arr2, 8)); 
		assertTrue(Search.linearSearch(arr2, 18));
	}
	
	@Test
	void linearSearch_KeyIsNotInArray_False() {
		assertFalse(Search.linearSearch(arr1, -35));
		assertFalse(Search.linearSearch(arr1, 15));
		assertFalse(Search.linearSearch(arr1, 24));
		assertFalse(Search.linearSearch(new int [] {}, 38)); 
		assertFalse(Search.linearSearch(null, 55)); 
	}
	
	@Test
	void linearSearchRecursive_KeyIsInArray_True() {
		assertTrue(Search.linearSearchRecursive(arr1, -33));
		assertTrue(Search.linearSearchRecursive(arr1, 0));
		assertTrue(Search.linearSearchRecursive(arr1, 18));
		assertTrue(Search.linearSearchRecursive(arr2, -33));
		assertTrue(Search.linearSearchRecursive(arr2, 8));
		assertTrue(Search.linearSearchRecursive(arr2, 18));
	}
	
	@Test
	void linearSearchRecursive_KeyIsNotInArray_False() {
		assertFalse(Search.linearSearchRecursive(arr1, -35));
		assertFalse(Search.linearSearchRecursive(arr1, 15));
		assertFalse(Search.linearSearchRecursive(arr1, 24));
		assertFalse(Search.linearSearchRecursive(new int [] {}, 38)); 
		assertFalse(Search.linearSearchRecursive(null, 55));  
	}
	
	@Test
	void binarySearch_KeyIsInArray_True() {
		assertTrue(Search.binarySearch(arr1, -33));
		assertTrue(Search.binarySearch(arr1, 0));
		assertTrue(Search.binarySearch(arr1, 18));
		assertTrue(Search.binarySearch(arr2, -33));
		assertTrue(Search.binarySearch(arr2, 8));
		assertTrue(Search.binarySearch(arr2, 18));
	}
	
	@Test
	void binarySearch_KeyIsNotInArray_False() {
		assertFalse(Search.binarySearch(arr1, -35));
		assertFalse(Search.binarySearch(arr1, 15));
		assertFalse(Search.binarySearch(arr1, 24));
		assertFalse(Search.binarySearch(new int [] {}, 38)); 
		assertFalse(Search.binarySearch(null, 55)); 
	}
	
	@Test
	void binarySearchRecursive_KeyIsInArray_True() {
		assertTrue(Search.binarySearchRecursive(arr1, -33));
		assertTrue(Search.binarySearchRecursive(arr1, 0));
		assertTrue(Search.binarySearchRecursive(arr1, 18));
		assertTrue(Search.binarySearchRecursive(arr2, -33));
		assertTrue(Search.binarySearchRecursive(arr2, 8));
		assertTrue(Search.binarySearchRecursive(arr2, 18));
	}
	
	@Test
	void binarySearchRecursive_KeyIsNotInArray_False() {
		assertFalse(Search.binarySearchRecursive(arr1, -35));
		assertFalse(Search.binarySearchRecursive(arr1, 15));
		assertFalse(Search.binarySearchRecursive(arr1, 24));
		assertFalse(Search.binarySearchRecursive(new int [] {}, 38)); 
		assertFalse(Search.binarySearchRecursive(null, 55)); 
	}
	
	@Test
	void jumpSearch_KeyIsInArray_True() {
		assertTrue(Search.jumpSearch(arr1, -33));
		assertTrue(Search.jumpSearch(arr1, 0));
		assertTrue(Search.jumpSearch(arr1, 18));
		assertTrue(Search.jumpSearch(arr2, -33));
		assertTrue(Search.jumpSearch(arr2, 8));
		assertTrue(Search.jumpSearch(arr2, 18));
	}
	
	@Test
	void jumpSearch_KeyIsNotInArray_False() {
		assertFalse(Search.jumpSearch(arr1, -35));
		assertFalse(Search.jumpSearch(arr1, 15));
		assertFalse(Search.jumpSearch(arr1, 24));
		assertFalse(Search.jumpSearch(new int [] {}, 38)); 
		assertFalse(Search.jumpSearch(null, 55)); 
	}
	
	@Test
	void jumpSearchRecursive_KeyIsInArray_True() {
		assertTrue(Search.jumpSearchRecursive(arr1, -33));
		assertTrue(Search.jumpSearchRecursive(arr1, 0));
		assertTrue(Search.jumpSearchRecursive(arr1, 18));
		assertTrue(Search.jumpSearchRecursive(arr2, -33));
		assertTrue(Search.jumpSearchRecursive(arr2, 8));
		assertTrue(Search.jumpSearchRecursive(arr2, 18));
	}
	
	@Test
	void jumpSearchRecursive_KeyIsNotInArray_False() {
		assertFalse(Search.jumpSearchRecursive(arr1, -35));
		assertFalse(Search.jumpSearchRecursive(arr1, 15));
		assertFalse(Search.jumpSearchRecursive(arr1, 24));
		assertFalse(Search.jumpSearchRecursive(new int [] {}, 38)); 
		assertFalse(Search.jumpSearchRecursive(null, 55)); 
	}
	
	@Test
	void exponentialSearch_KeyIsInArray_True() {
		assertTrue(Search.exponentialSearch(arr1, -33));
		assertTrue(Search.exponentialSearch(arr1, 0));
		assertTrue(Search.exponentialSearch(arr1, 18));
		assertTrue(Search.exponentialSearch(arr2, -33));
		assertTrue(Search.exponentialSearch(arr2, 8));
		assertTrue(Search.exponentialSearch(arr2, 18));
	}
	
	@Test
	void exponentialSearch_KeyIsNotInArray_False() {
		assertFalse(Search.exponentialSearch(arr1, -35));
		assertFalse(Search.exponentialSearch(arr1, 15));
		assertFalse(Search.exponentialSearch(arr1, 24));
		assertFalse(Search.exponentialSearch(new int [] {}, 38)); 
		assertFalse(Search.exponentialSearch(null, 55)); 
	}
	
	@Test
	void exponentialSearchRecursive_KeyIsInArray_True() {
		assertTrue(Search.exponentialSearchRecursive(arr1, -33));
		assertTrue(Search.exponentialSearchRecursive(arr1, 0));
		assertTrue(Search.exponentialSearchRecursive(arr1, 18));
		assertTrue(Search.exponentialSearchRecursive(arr2, -33));
		assertTrue(Search.exponentialSearchRecursive(arr2, 8));
		assertTrue(Search.exponentialSearchRecursive(arr2, 18));
	}
	
	@Test
	void exponentialSearchRecursive_KeyIsNotInArray_False() {
		assertFalse(Search.exponentialSearchRecursive(arr1, -35));
		assertFalse(Search.exponentialSearchRecursive(arr1, 15));
		assertFalse(Search.exponentialSearchRecursive(arr1, 24));
		assertFalse(Search.exponentialSearchRecursive(new int [] {}, 38)); 
		assertFalse(Search.exponentialSearchRecursive(null, 55)); 
	}

}
