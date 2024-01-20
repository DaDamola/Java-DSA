package data;

import java.util.Arrays;

import algo.Constants;

/**
* The BloomFilter class creates a probabilistic space-efficient data
* structure that tests whether an item is a member of a set. It 
* stores generic values using multiple hash tables and calculates the 
* false positive rate.
* @author  Damola Adebayo
* @version 1.0
* @since   2023-08-11
*/

public class BloomFilter<AnyType> {
	private boolean [][] hashTables;
	
	public BloomFilter(int [] capacities) {
		hashTables = new boolean [capacities.length][];
		
		for (int i = 0; i < hashTables.length; i++) {
			hashTables[i] = new boolean [capacities[i]];
		}
	}
	
	public boolean [][] getHashTables() {
		return hashTables;
	}
	
	public void setHashTables(boolean [][] hashTables) {
		this.hashTables = hashTables;
	}
	
    /**
    * This method calculates the hash value for a key. 
    * @param key The key
    */
	public int getHashValue(AnyType key) {
		return key.hashCode() < 0 ? key.hashCode() - Integer.MIN_VALUE : key.hashCode();
	}
	
    /**
    * This method inserts a key into each hash table in the bloom filter. 
    * @param key The value to insert
    * BC/AC/WC: O(n) where n is the number of hash tables
    * SC: O(1)
    */
	public void add(AnyType key) {
		int hVal = getHashValue(key);
		
		for (int i = 0; i < hashTables.length; i++) {
			hashTables[i][hVal % hashTables[i].length] = true;
		}
	}
	

    /**
    * This method recursively inserts a key into each hash table in the bloom filter. 
    * @param key The value to insert
    */
	public void addRecursive(AnyType key) {
		addRecursive(getHashValue(key), 0);
	}
	
	public void addRecursive(int hVal, int i) {
		if (i >= hashTables.length) {
			return;
		}
		
		hashTables[i][hVal % hashTables[i].length] = true;
		addRecursive(hVal, i + 1);
	}
	
    /**
    * This method searches for a key in the bloom filter. 
    * @param key The value to find
    * @return boolean true if the value is found and false if the value is not found
    * BC: O(1) AC/WC: O(n) 
    * SC: O(1)
    */
	public boolean contains(AnyType key) {
		int hVal = getHashValue(key);
		
		for (int i = 0; i < hashTables.length; i++) {
			if (!hashTables[i][hVal % hashTables[i].length]) {
				return false;
			}
		}
		
		return true;
	}
	
    /**
    * This method recursively searches for a key in the bloom filter. 
    * @param key The value to find
    * @return boolean true if the value is found and false if the value is not found
    */
	public boolean containsRecursive(AnyType key) {		
		return containsRecursive(getHashValue(key), 0);
	}
	
	public boolean containsRecursive(int hVal, int i) {
		if (i >= hashTables.length) {
			return true;
		}
		else if (!hashTables[i][hVal % hashTables[i].length]) {
			return false;
		}
		
		return containsRecursive(hVal, i + 1);
	}
	
    /**
    * This method calculates the rate that the bloom filter confirms it contains a key
    * that does not exist.
    * @return double The false positive rate
    * BC/AC/WC: O(n)
    * SC: O(1)
    */
	public double expectedFalsePositiveRate() {
		double rate = 1.0;
		
		for (int i = 0; i < hashTables.length; i++) {
			int cnt = 0;
			
			for (int j = 0; j < hashTables[i].length; j++) {
				if (hashTables[i][j]) {
					cnt++;
				}
			}
			
			rate *= (double) cnt / hashTables[i].length;
		}
		
		return rate * 100.0;
	}
	
    /**
    * This method displays where each value is in each hash table. 
    */
	public void print() {
		if (expectedFalsePositiveRate() > 0) {
			for (int i = 0; i < hashTables.length; i++) {
				for (int j = 0; j < hashTables[i].length; j++) {
					System.out.print(hashTables[i][j] + ((j + 1 == hashTables[i].length) ? "\n" : " "));
				}
			}
		}
		else {
			System.out.println(Constants.NULL_KEY);
		}
	}
	
    /**
    * This method removes each value in the hash table. 
    */
	public void clear() {
		for (int i = 0; i < hashTables.length; i++) {
			Arrays.fill(hashTables[i], false);
		}
	}
}
