package data;

import java.util.Arrays;
import java.util.LinkedList;

import algo.Constants;

/**
* The LinearHashTable class inserts, deletes, and searches for keys
* in a hash table using linear probing. 
*
* @author  Damola Adebayo
* @version 1.0
* @since   2023-10-25 
*/

public class LinearHashTable extends AbstractTable {
	public LinearHashTable(int capacity) {
		this.capacity = origCapacity = capacity;
		table = new int [capacity];
	
		Arrays.fill(table, Constants.EMPTY);
	}

	public LinearHashTable(int capacity, boolean isRecursive) {
		this(capacity);
		this.isRecursive = isRecursive; 
	}
	
    /**
    * This method adds a number to the hash table.
    * @param key The number to add
    */
	@Override
	public void insert(int key) {
		if (isRecursive) {
			insertLinearRecursive(key);
		}
		else {
			insertLinear(key);
		}
	}
	
    /**
    * This method removes the first occurrence of the number from the hash table.
    * @param key The number to remove
    */
	@Override
	public void delete(int key) {
		if (isRecursive) {
			deleteLinearRecursive(key);
		}
		else {
			deleteLinear(key);
		}
	}
	
    /**
    * This method checks if the number is in the hash table.
    * @param key The number to find
    * @return boolean true if the number is found and false if the number is not found
    */
	@Override
	public boolean search(int key) {
		return isRecursive ? searchLinearRecursive(key) : searchLinear(key);
	}
	
    /**
    * This method adds a number to the hash table iteratively.
    * @param key The number to add
    * BC/AC: O(1) WC: O(n^2)
    * SC: O(n)
    */
	public void insertLinear(int key) {
		int i = hash(key);
		
		while (table[i] != Constants.EMPTY && table[i] != Constants.DIRTY) {
			i = (i + 1) % table.length;
		}
		
		table[i] = key; 
		size++; 
		expandTable();
	}
	
    /**
    * This method adds a number to the hash table recursively.
    * @param key The number to add
    */
	public void insertLinearRecursive(int key) {
		insertLinearRecursive(key, hash(key));
	}
	
	public void insertLinearRecursive(int key, int i) {
		if (table[i] == Constants.EMPTY || table[i] == Constants.DIRTY) {
			table[i] = key; 
			size++; 
			expandTable();
			return; 
		}
		
		insertLinearRecursive(key, (i + 1) % table.length);
	}
	
    /**
    * This method removes the first occurrence of the number from the hash table iteratively.
    * @param key The number to remove
    * BC/AC: O(1) WC: O(n)
    * SC: O(1)
    */
	public void deleteLinear(int key) {
		int i = hash(key), cnt = 0; 
		
		while (table[i] != key && table[i] != Constants.EMPTY && cnt < table.length) {
			cnt++;
			i = (i + 1) % table.length;
		}
		
		if (table[i] == key) {
			table[i] = Constants.DIRTY;
			size--;
		}
	}
	
    /**
    * This method removes the first occurrence of the number from the hash table recursively.
    * @param key The number to remove
    */
	public void deleteLinearRecursive(int key) {
		deleteLinearRecursive(key, hash(key), 0);
	}
	
	public void deleteLinearRecursive(int key, int i, int cnt) {
		if (table[i] == Constants.EMPTY || cnt >= table.length) {
			return; 
		}
		else if (table[i] == key) {
			table[i] = Constants.DIRTY;
			size--;
			return; 
		}
		
		deleteLinearRecursive(key, (i + 1) % table.length, cnt + 1);
	}
	
	
    /**
    * This method checks if the number is in the hash table iteratively.
    * @param key The number to find
    * @return boolean true if the number is found and false if the number is not found
    * BC/AC: O(1) WC: O(n)
    * SC: O(1)
    */
	public boolean searchLinear(int key) {
		int i = hash(key), cnt = 0; 
		
		while (table[i] != key && table[i] != Constants.EMPTY && cnt < table.length)  {
			cnt++;
			i = (i + 1) % table.length;
		}
		
		return table[i] == key;
	}
	
    /**
    * This method checks if the number is in the hash table recursively.
    * @param key The number to find
    * @return boolean true if the number is found and false if the number is not found
    */
	public boolean searchLinearRecursive(int key) {
		return searchLinearRecursive(key, hash(key), 0);
	}
	
	public boolean searchLinearRecursive(int key, int i, int cnt) {
		if (table[i] == Constants.EMPTY || cnt >= table.length) {
			return false;
		}
		else if (table[i] == key) {
			return true; 
		}

		return searchLinearRecursive(key, (i + 1) % table.length, cnt + 1);
	}
}
