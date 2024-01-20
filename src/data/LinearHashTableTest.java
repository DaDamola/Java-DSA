package data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import algo.Constants;

class LinearHashTableTest {
	static int [] res1, res2, res3, res4;

	@BeforeAll
	static void setUpBeforeClass() {
		// insert
		res1 = new int [11];
		Arrays.fill(res1, Constants.EMPTY);
		res1[0] = 5; 
		res1[1] = 3; 
		res1[2] = 7; 
		
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
		
		// clear
		res4 = new int [5];
		Arrays.fill(res4, Constants.EMPTY);
	}
	
	@Test
	void linearInsert_AnyValue_AddsAValue() {
		AbstractTable ht = new LinearHashTable(5);
		
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
	void linearInsertRecursive_AnyValue_AddsAValue() {
		AbstractTable ht = new LinearHashTable(5, true);
		
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
	void linearDelete_AnyValue_RemovesAValue() {
		AbstractTable ht = new LinearHashTable(5);
		
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
	void linearDeleteRecursive_AnyValue_RemovesAValue() {
		AbstractTable ht = new LinearHashTable(5, true);
		
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
	void linearSearch_ValueInTable_True() {
		AbstractTable ht = new LinearHashTable(5);
		
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
	void linearSearchRecursive_ValueInTable_True() {
		AbstractTable ht = new LinearHashTable(5, true);
		
		
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
	void linearSearch_ValueNotInTable_Falsed() {
		AbstractTable ht = new LinearHashTable(5);
		
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
	void linearSearchRecursive_ValueNotInTable_False() {
		AbstractTable ht = new LinearHashTable(5, true);
		
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
	void clear_ValuesInTable_RemovesAllValues() {
		AbstractTable ht = new LinearHashTable(5);
		int [] out1 = new int [5];
		Arrays.fill(out1, Constants.EMPTY);
		
		assertArrayEquals(res4, ht.getTable());
		
		ht.insert(3);
		ht.insert(5);
		ht.insert(7);
		ht.insert(11);
		ht.insert(13);
		ht.insert(35);
		
		ht.clear();
		
		assertEquals(0, ht.getSize());
		assertArrayEquals(out1, ht.getTable());	
	}
	
	@Test
	void linearInsert_NoValuesInTableAfterClear_AddsAValue() {
		AbstractTable ht = new LinearHashTable(5);
		int [] out1 = new int [5];
		Arrays.fill(out1, Constants.EMPTY);
		
		assertArrayEquals(res4, ht.getTable());
		
		ht.insert(3);
		ht.insert(5);
		ht.insert(7);
		ht.insert(11);
		ht.insert(13);
		ht.insert(35);
		
		ht.clear();
		
		assertEquals(0, ht.getSize());
		assertArrayEquals(out1, ht.getTable());	
		
		ht.insert(3);
		ht.insert(5);
		ht.insert(7);

		assertArrayEquals(res1, ht.getTable());
	}
}
