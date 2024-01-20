package data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SeparateChainingHashTableTest {
	static int [] res1, res2, res3, res4;

	@BeforeAll
	static void setUpBeforeClass()  {		
		// insert
		res1 = new int [] {1, 0, 1, 1, 0};
		res2 = new int [] {1, 0, 3, 1, 1};
		
		// delete
		res3 = new int [] {0, 0, 2, 0, 1};
		
		// clear
		res4 = new int [5];
		Arrays.fill(res4, 0);
	}
	
	@Test
	void separateChainingInsert_AnyValue_AddsAValue() {
		SeparateChainingHashTable<Integer> ht = new SeparateChainingHashTable<>(5);
		
		ht.insert(3);
		ht.insert(5);
		ht.insert(7);

		assertArrayEquals(res1, ht.storeList());
		
		ht.insert(11);
		ht.insert(13);
		ht.insert(35);
		
		assertArrayEquals(res2, ht.storeList());
	}
	
	@Test
	void separateChainingDelete_AnyValue_RemovesAValue() {
		SeparateChainingHashTable<Integer> ht = new SeparateChainingHashTable<>(5);
		
		ht.insert(3);
		ht.insert(5);
		ht.insert(7);
		ht.insert(11);
		ht.insert(13);
		ht.insert(35);
		
		ht.delete(3);
		ht.delete(5);
		ht.delete(7);
		
		assertArrayEquals(res3, ht.storeList());
		
		ht.insert(3);
		ht.insert(5);
		ht.insert(7);
		
		assertArrayEquals(res2, ht.storeList());
	}
	
	@Test
	void separateChainingSearch_ValueInList_True() {
		SeparateChainingHashTable<Integer> ht = new SeparateChainingHashTable<>(5);
		
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
	void separateChainingSearch_ValueNotInList_False() {
		SeparateChainingHashTable<Integer> ht = new SeparateChainingHashTable<>(5);
		
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
	void clear_ValuesInOrList_RemovesAllValues() {
		SeparateChainingHashTable<Integer> ht = new SeparateChainingHashTable<>(5);
		LinkedList<LinkedList<Integer>> out1 = new LinkedList<>();
		
		int i = 0;
		while (i < 5) {
			out1.add(new LinkedList<>());
			i++;
		}
		
		assertArrayEquals(res4, ht.storeList());
		
		ht.insert(3);
		ht.insert(5);
		ht.insert(7);
		ht.insert(11);
		ht.insert(13);
		ht.insert(35);
		
		ht.clear();
		
		assertEquals(0, ht.getSize());
		assertEquals(out1, ht.getBuckets());
	}
	
	@Test
	void separateChainingInsert_NoValuesInListAfterClear_AddsAValue() {
		SeparateChainingHashTable<Integer> ht = new SeparateChainingHashTable<>(5);
		LinkedList<LinkedList<Integer>> out1 = new LinkedList<>();
		
		int i = 0;
		while (i < 5) {
			out1.add(new LinkedList<>());
			i++;
		}
		
		assertArrayEquals(res4, ht.storeList());
		
		ht.insert(3);
		ht.insert(5);
		ht.insert(7);
		ht.insert(11);
		ht.insert(13);
		ht.insert(35);
		
		ht.clear();
		
		assertEquals(0, ht.getSize());
		assertEquals(out1, ht.getBuckets());
		
		ht.insert(3);
		ht.insert(5);
		ht.insert(7);

		assertArrayEquals(res1, ht.storeList());
	}
}
