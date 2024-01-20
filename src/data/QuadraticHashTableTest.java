package data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import algo.Constants;

class QuadraticHashTableTest {
	static int [] res1, res2, res3, res4, res5;

	@BeforeAll
	static void setUpBeforeClass()  {			
		// quadratic insert
		res1 = new int [11];
		Arrays.fill(res1, Constants.EMPTY);
		res1[0] = 5; 
		res1[1] = 3; 
		res1[5] = 7; 
		
		res2 = new int [23];
		Arrays.fill(res2, Constants.EMPTY);
		res2[5] = 7; 
		res2[6] = 13; 
		res2[7] = 35; 
		res2[12] = 3; 
		res2[20] = 5; 
		res2[21] = 11; 
		
		// delete
		res3 = new int [23];
		Arrays.fill(res3, Constants.EMPTY);
		res3[5] = Constants.DIRTY; 
		res3[6] = 13; 
		res3[7] = 35; 
		res3[12] = Constants.DIRTY; 
		res3[20] = Constants.DIRTY; 
		res3[21] = 11; 
		
		res4 = new int [23];
		Arrays.fill(res4, Constants.EMPTY);
		res4[5] = 7; 
		res4[6] = 13; 
		res4[7] = 35; 
		res4[12] = 3; 
		res4[20] = 5; 
		res4[21] = 11; 
		
		// clear
		res5 = new int [5];
		Arrays.fill(res5, Constants.EMPTY);
	}
	
	@Test
	void quadraticInsert_AnyValue_AddsAValue() {
		AbstractTable ht = new QuadraticHashTable(5);
		
		ht.insert(3);
		ht.insert(5);
		ht.insert(7);
		
		assertArrayEquals(res1, ht.getTable());
		
		ht.insert(11);
		ht.insert(13);
		ht.insert(35);
		
		assertArrayEquals(res2, ht.getTable());
	}
	
	@Test
	void quadraticInsertRecursive_AnyValue_AddsAValue() {
		AbstractTable ht = new QuadraticHashTable(5, true);
		
		ht.insert(3);
		ht.insert(5);
		ht.insert(7);

		assertArrayEquals(res1, ht.getTable());
		
		ht.insert(11);
		ht.insert(13);
		ht.insert(35);
		
		assertArrayEquals(res2, ht.getTable());
	}
	
	@Test
	void quadraticDelete_AnyValue_RemovesAValue() {
		AbstractTable ht = new QuadraticHashTable(5);
		
		ht.insert(3);
		ht.insert(5);
		ht.insert(7);
		ht.insert(11);
		ht.insert(13);
		ht.insert(35);
		
		ht.delete(3);
		ht.delete(5);
		ht.delete(7);
		
		assertArrayEquals(res3, ht.getTable());
		
		ht.insert(3);
		ht.insert(5);
		ht.insert(7);
		
		assertArrayEquals(res2, ht.getTable());
	}
	
	@Test
	void quadraticDeleteRecursive_AnyValue_RemovesAValue() {
		AbstractTable ht = new QuadraticHashTable(5, true);
		
		ht.insert(3);
		ht.insert(5);
		ht.insert(7);
		ht.insert(11);
		ht.insert(13);
		ht.insert(35);
		
		ht.delete(3);
		ht.delete(5);
		ht.delete(7);
		
		assertArrayEquals(res3, ht.getTable());
		
		ht.insert(3);
		ht.insert(5);
		ht.insert(7);
		
		assertArrayEquals(res2, ht.getTable());
	}
	
	@Test
	void quadraticSearch_ValueInTable_True() {
		AbstractTable ht = new QuadraticHashTable(5);
		
		ht.insert(3);
		ht.insert(5);
		ht.insert(7);
		ht.insert(11);
		ht.insert(13);
		ht.insert(35);
		
		assertTrue(ht.search(3));
		assertTrue(ht.search(11));
		assertTrue(ht.search(35));
	}
	
	@Test
	void quadraticSearchRecursive_ValueInTable_True() {
		AbstractTable ht = new QuadraticHashTable(5, true);
		
		ht.insert(3);
		ht.insert(5);
		ht.insert(7);
		ht.insert(11);
		ht.insert(13);
		ht.insert(35);
		
		assertTrue(ht.search(3));
		assertTrue(ht.search(11));
		assertTrue(ht.search(35));
	}
	
	
	@Test
	void quadraticSearch_ValueNotInTable_False() {
		AbstractTable ht = new QuadraticHashTable(5);
		
		ht.insert(3);
		ht.insert(5);
		ht.insert(7);
		ht.insert(11);
		ht.insert(13);
		ht.insert(35);
		
		assertFalse(ht.search(2));
		assertFalse(ht.search(15));
		assertFalse(ht.search(40));
	}
	
	@Test
	void quadraticSearchRecursive_ValueNotInTable_False() {
		AbstractTable ht = new QuadraticHashTable(5, true);
		
		ht.insert(3);
		ht.insert(5);
		ht.insert(7);
		ht.insert(11);
		ht.insert(13);
		ht.insert(35);
		
		assertFalse(ht.search(2));
		assertFalse(ht.search(15));
		assertFalse(ht.search(40));
	}
}
