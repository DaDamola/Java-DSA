package data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BloomFilterTest {
	static int [] capacities;
	static boolean [] res1, res2, res3, res4, res5, res6, res7, res8, res9, res10;
	
	@BeforeAll
	static void setUpBeforeClass() {
		capacities = new int [] {11, 13, 17, 19, 23};
		res1 = new boolean [] {true, false, false, false, false, false, false, false, 
							   true, true, false};
		res2 = new boolean [] {true, true, true, true, false, false, false, false, 
							   true, false, false, false, false};
		res3 = new boolean [] {true, true, false, false, false, false, false, false, 
							   true, false, false, false, false, false, false, true, false};
		res4 = new boolean [] {true, false, true, true, false, false, false, false, true, 
							   false, false, true, false, false, false, false, false, false, false};
		res5 = new boolean [] {false, false, false, false, true, true, false, false, false, 
							   false, false, true, false, false, true, false, false, false, false, false, false, false, true};
		res6 = new boolean [capacities[0]];
		res7 = new boolean [capacities[1]];
		res8 = new boolean [capacities[2]];
		res9 = new boolean [capacities[3]];
		res10 = new boolean [capacities[4]];
		
		Arrays.fill(res6, false);
		Arrays.fill(res7, false);
		Arrays.fill(res8, false);
		Arrays.fill(res9, false);
		Arrays.fill(res10, false);
	}

	@Test
	void add_AnyValue_AddsAValue() {
		BloomFilter<String> bf = new BloomFilter<String>(capacities);
		
		bf.add("Sean");
		bf.add("Arya");
		bf.add("Robb");
		bf.add("Bran");
		bf.add("Dany");
		
		assertTrue(bf.contains("Sean"));
		assertTrue(bf.contains("Arya"));
		assertTrue(bf.contains("Robb"));
		assertTrue(bf.contains("Bran"));
		assertTrue(bf.contains("Dany"));
		
		assertArrayEquals(res1, bf.getHashTables()[0]);
		assertArrayEquals(res2, bf.getHashTables()[1]);
		assertArrayEquals(res3, bf.getHashTables()[2]);
		assertArrayEquals(res4, bf.getHashTables()[3]);
		assertArrayEquals(res5, bf.getHashTables()[4]);
	}
	
	@Test
	void addRecursive_AnyValue_AddsAValue() {
		BloomFilter<String> bf = new BloomFilter<String>(capacities);
		
		bf.addRecursive("Sean");
		bf.addRecursive("Arya");
		bf.addRecursive("Robb");
		bf.addRecursive("Bran");
		bf.addRecursive("Dany");
		
		assertTrue(bf.contains("Sean"));
		assertTrue(bf.contains("Arya"));
		assertTrue(bf.contains("Robb"));
		assertTrue(bf.contains("Bran"));
		assertTrue(bf.contains("Dany"));
		
		assertArrayEquals(res1, bf.getHashTables()[0]);
		assertArrayEquals(res2, bf.getHashTables()[1]);
		assertArrayEquals(res3, bf.getHashTables()[2]);
		assertArrayEquals(res4, bf.getHashTables()[3]);
		assertArrayEquals(res5, bf.getHashTables()[4]);
	}
	
	@Test
	void contains_ValueInTable_True() {
		BloomFilter<String> bf = new BloomFilter<String>(capacities);
		
		bf.add("Sean");
		bf.add("Arya");
		bf.add("Robb");
		bf.add("Bran");
		bf.add("Dany");
		
		assertTrue(bf.contains("Sean"));
		assertTrue(bf.contains("Arya"));
		assertTrue(bf.contains("Robb"));
		assertTrue(bf.contains("Bran"));
		assertTrue(bf.contains("Dany"));
	}
	
	@Test
	void containsRecursive_ValueInTable_True() {
		BloomFilter<String> bf = new BloomFilter<String>(capacities);
		
		bf.add("Sean");
		bf.add("Arya");
		bf.add("Robb");
		bf.add("Bran");
		bf.add("Dany");
		
		assertTrue(bf.contains("Sean"));
		assertTrue(bf.contains("Arya"));
		assertTrue(bf.contains("Robb"));
		assertTrue(bf.contains("Bran"));
		assertTrue(bf.contains("Dany"));
	}
	
	
	@Test
	void contains_ValueNotInTable_False() {
		BloomFilter<String> bf = new BloomFilter<String>(capacities);
		
		bf.add("Sean");
		bf.add("Arya");
		bf.add("Robb");
		bf.add("Bran");
		bf.add("Dany");
		
		assertFalse(bf.contains("Dapo"));
		assertFalse(bf.contains("Dayo"));
		assertFalse(bf.contains("Damola"));
	}
	
	@Test
	void containsRecursive_ValueNotInTable_False() {
		BloomFilter<String> bf = new BloomFilter<String>(capacities);
		
		bf.add("Sean");
		bf.add("Arya");
		bf.add("Robb");
		bf.add("Bran");
		bf.add("Dany");
		
		assertFalse(bf.containsRecursive("Dapo"));
		assertFalse(bf.containsRecursive("Dayo"));
		assertFalse(bf.containsRecursive("Damola"));
	}
	
	@Test
	void expectedFalsePositiveRate_ValuesInTable_Number() {
		BloomFilter<String> bf = new BloomFilter<String>(capacities);
		double out1 = .14119680292785688;
		
		bf.add("Sean");
		bf.add("Arya");
		bf.add("Robb");
		bf.add("Bran");
		bf.add("Dany");
		
		assertArrayEquals(res1, bf.getHashTables()[0]);
		assertArrayEquals(res2, bf.getHashTables()[1]);
		assertArrayEquals(res3, bf.getHashTables()[2]);
		assertArrayEquals(res4, bf.getHashTables()[3]);
		assertArrayEquals(res5, bf.getHashTables()[4]);
		
		assertEquals(out1, bf.expectedFalsePositiveRate());
	}
	
	
	@Test
	void clear_ValuesInTable_RemovesAllValues() {
		BloomFilter<String> bf = new BloomFilter<String>(capacities);
		
		bf.add("Sean");
		bf.add("Arya");
		bf.add("Robb");
		bf.add("Bran");
		bf.add("Dany");
		
		bf.clear();
		
		assertFalse(bf.contains("Sean"));
		assertFalse(bf.contains("Arya"));
		assertFalse(bf.contains("Robb"));
		assertFalse(bf.contains("Bran"));
		assertFalse(bf.contains("Dany"));
		
		assertArrayEquals(res6, bf.getHashTables()[0]);
		assertArrayEquals(res7, bf.getHashTables()[1]);
		assertArrayEquals(res8, bf.getHashTables()[2]);
		assertArrayEquals(res9, bf.getHashTables()[3]);
		assertArrayEquals(res10, bf.getHashTables()[4]);
	}
	
	@Test
	void add_NoValuesInTableAfterClear_AddsAValue() {
		BloomFilter<String> bf = new BloomFilter<String>(capacities);
		
		bf.add("Sean");
		bf.add("Arya");
		bf.add("Robb");
		bf.add("Bran");
		bf.add("Dany");
		
		bf.clear();
		
		assertFalse(bf.contains("Sean"));
		assertFalse(bf.contains("Arya"));
		assertFalse(bf.contains("Robb"));
		assertFalse(bf.contains("Bran"));
		assertFalse(bf.contains("Dany"));
		
		assertArrayEquals(res6, bf.getHashTables()[0]);
		assertArrayEquals(res7, bf.getHashTables()[1]);
		assertArrayEquals(res8, bf.getHashTables()[2]);
		assertArrayEquals(res9, bf.getHashTables()[3]);
		assertArrayEquals(res10, bf.getHashTables()[4]);
		
		bf.add("Sean");
		bf.add("Arya");
		bf.add("Robb");
		bf.add("Bran");
		bf.add("Dany");
		
		assertTrue(bf.contains("Sean"));
		assertTrue(bf.contains("Arya"));
		assertTrue(bf.contains("Robb"));
		assertTrue(bf.contains("Bran"));
		assertTrue(bf.contains("Dany"));
		
		assertArrayEquals(res1, bf.getHashTables()[0]);
		assertArrayEquals(res2, bf.getHashTables()[1]);
		assertArrayEquals(res3, bf.getHashTables()[2]);
		assertArrayEquals(res4, bf.getHashTables()[3]);
		assertArrayEquals(res5, bf.getHashTables()[4]);
	}
}
