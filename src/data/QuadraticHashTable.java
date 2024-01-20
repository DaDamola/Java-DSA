package data;

import java.util.Arrays;

import algo.Constants;

/**
* The QuadraticHashTable class inserts, deletes, and searches for keys
* in a hash table using quadratic probing. 
*
* @author  Damola Adebayo
* @version 1.0
* @since   2023-11-04 
*/

public class QuadraticHashTable extends AbstractTable {
	private int maxPow;
	
	public QuadraticHashTable(int capacity) {
		this.capacity = capacity;
		table = new int [capacity];
	
		Arrays.fill(table, Constants.EMPTY);
	}

	public QuadraticHashTable(int capacity, boolean isRecursive) {
		this(capacity);
		this.isRecursive = isRecursive; 
	}
	
	public int getMaxPow() {
		return maxPow; 
	}
	
	public void setMaxPow(int maxPow) {
		this.maxPow = maxPow;
	}
	
    /**
    * This method adds a number to the hash table.
    * @param key The number to add
    */
	@Override
	public void insert(int key) {
		if (isRecursive) {
			insertQuadraticRecursive(key);
		}
		else {
			insertQuadratic(key);
		}
	}
	
    /**
    * This method removes the first occurrence of the number from the hash table.
    * @param key The number to remove
    */
	@Override
	public void delete(int key) {
		if (isRecursive) {
			deleteQuadraticRecursive(key);
		}
		else {
			deleteQuadratic(key);
		}
	}
	
    /**
    * This method checks if the number is in the hash table.
    * @param key The number to find
    * @return boolean true if the number is found and false if the number is not found
    */
	@Override
	public boolean search(int key) {
		return isRecursive ? searchQuadraticRecursive(key) : searchQuadratic(key);
	}
	
/*	To ensure that quadratic probing will actually find an Constants.EMPTY space in a 
	hash table (if there is one) without looping infinitely, two conditions must be 
	met:
	1. The hash table must be AT LEAST half Constants.EMPTY.
	2. The size of the hash table must be a PRIME NUMBER */
	
    /**
    * This method adds a number to the hash table iteratively.
    * @param key The number to add
    * BC/AC: O(1) WC: O(n^2)
    * SC: O(n)
    */
	public void insertQuadratic(int key) {
		int i = hash(key), pow = 1;
		
		while (table[i] != Constants.EMPTY && table[i] != Constants.DIRTY) {
			i = (i + (pow * pow++)) % table.length;
		}
		
		table[i] = key; 
		size++; 
		maxPow = Math.max(maxPow, pow);
		expandTable();
	}
	
    /**
    * This method adds a number to the hash table recursively.
    * @param key The number to add
    */
	public void insertQuadraticRecursive(int key) {
		insertQuadraticRecursive(key, hash(key), 1);
	}
	
	public void insertQuadraticRecursive(int key, int i, int pow) {
		if (table[i] == Constants.EMPTY || table[i] == Constants.DIRTY) {
			table[i] = key; 
			size++; 
			maxPow = Math.max(maxPow, pow);
			expandTable();	
			return;
		}

		insertQuadraticRecursive(key, (i + (pow * pow)) % table.length, pow + 1);
	}
	
    /**
    * This method checks if the number is in the hash table iteratively.
    * @param key The number to find
    * @return boolean true if the number is found and false if the number is not found
    * BC/AC: O(1) WC: O(n)
    * SC: O(1)
    */
	public boolean searchQuadratic(int key) {
		int i = hash(key), pow = 1;
		
		while (table[i] != Constants.EMPTY || pow < maxPow) {
			if (table[i] == key) {
				return true;
			}
			
			i = (i + (pow * pow++)) % table.length;
		}
		
		return false;
	}
	
    /**
    * This method checks if the number is in the hash table recursively.
    * @param key The number to find
    * @return boolean true if the number is found and false if the number is not found
    */
	public boolean searchQuadraticRecursive(int key) {
		return searchQuadraticRecursive(key, hash(key), 1);
	}
	
	public boolean searchQuadraticRecursive(int key, int i, int pow) {
		if (table[i] == Constants.EMPTY && pow >= maxPow) {
			return false;
		}
		else if (table[i] == key) {
			return true;
		}

		return searchQuadraticRecursive(key, (i + (pow * pow)) % table.length, pow + 1);
	}
	
    /**
    * This method removes the first occurrence of the number from the hash table iteratively.
    * @param key The number to remove
    * BC/AC: O(1) WC: O(n^2)
    * SC: O(1)
    */
	public void deleteQuadratic(int key) {
		int i = hash(key), pow = 1;
		
		while (table[i] != Constants.EMPTY || pow < maxPow) {
			if (table[i] == key) {
				table[i] = Constants.DIRTY;
				size--;
				break;
			}
			
			i = (i + (pow * pow++)) % table.length;
		}
	}
	
    /**
    * This method removes the first occurrence of the number from the hash table recursively.
    * @param key The number to remove
    */
	public void deleteQuadraticRecursive(int key) {
		deleteQuadraticRecursive(key, hash(key), 1);
	}
	
	public void deleteQuadraticRecursive(int key, int i, int pow) {
		if (table[i] == Constants.EMPTY && pow >= maxPow) {
			return; 
		}
		else if (table[i] == key) {
			table[i] = Constants.DIRTY;
			size--;
			return; 
		}
		
		deleteQuadraticRecursive(key, (i + (pow * pow)) % table.length, pow + 1);
	}
}
