package data;

import java.util.Arrays;

import algo.Constants;

/**
* The AbstractTable class provides method declarations
* and implements some methods common to hash tables.
*
* @author  Damola Adebayo
* @version 1.0
* @since   2023-07-18 
*/

public abstract class AbstractTable {
	protected int [] table; 
	protected int origCapacity, capacity, size;
	protected boolean isRecursive = false; 
	
	public int [] getTable() {
		return table; 
	}
	
	public void setTable(int [] table) {
		this.table = table;
	}
	
	public int getOrigCapacity() {
		return origCapacity; 
	}
	
	public void setOrigCapacity(int origCapacity) {
		this.origCapacity = origCapacity;
	}
	
	public int getCapacity() {
		return capacity; 
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public int getSize() {
		return size; 
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public boolean getIsRecursive() {
		return isRecursive; 
	}
	
	public void setIsRecursive(boolean isRecursive) {
		this.isRecursive = isRecursive;
	}
	
    /**
    * This method calculates a hash value for a number using bit-shifting. 
    * @param key The number to insert into the hash table
    * @return int The hash value
    */
	public int hash(int key) {         
	      key ^= (key << 13);
	      key ^= (key >>> 17);        
	      key ^= (key << 5);
	      return key % capacity;   
	}
	
    /**
    * This method determines if a number is prime.
    * @param n The number
    * @return boolean true if the number is prime and false if the value is not prime
    */
	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
    /**
    * This method enlarges the hash table by twice its capacity.
    */
	public void expandTable() {
		if (size * 2 > table.length) {
			int n = capacity * 2;
			
			while (!isPrime(n)) {
				n++;
			}
			
			int [] newTable = new int [n];
			Arrays.fill(newTable, Constants.EMPTY);
			
			capacity = newTable.length; 
			size = 0; 

			for (int key : table) {
				if (key != Constants.EMPTY) {
					insert(key, newTable);
				}
			}
			
			table = newTable; 
		}	
	}
	
    /**
    * This method adds a number to the linear or quadratic hash table
    * by its hash value.
    * @param key The number to add
    * @param table The hash table
    */
	public void insert(int key, int [] table) {
		int i = hash(key), pow = 1;
		
		while (table[i] != Constants.EMPTY && table[i] != Constants.DIRTY) {
			if (this.getClass().getSimpleName().equals("LinearHashTable")) {
				i = (i + 1) % table.length;
			}
			else {
				i = (i + (pow * pow++)) % table.length;
			}
		}
		
		table[i] = key; 
		size++; 
	}
	
    /**
    * This method displays the contents of each cell in the hash table.
    */
	public void print() {
		for (int i = 0; i < table.length; i++) {
			System.out.print(((table[i] == Constants.EMPTY) ? "EMPTY" :
							(table[i] == Constants.DIRTY) ? "DIRTY" : table[i]) + ((i + 1 == table.length) ? "\n" : " "));
		}
	}
	
    /**
    * This method resets the hash table.
    */
	public void clear() {
		size = 0;
		capacity = origCapacity;
		table = new int [origCapacity];
		Arrays.fill(table, Constants.EMPTY);
	}
	
    /**
    * This method adds a number to the hash table.
    * @param key The number to add
    */
	public abstract void insert(int key);
	
    /**
    * This method removes the first occurrence of the number from the hash table.
    * @param key The number to remove
    */
	public abstract void delete(int key);
	
    /**
    * This method checks if the number is in the hash table.
    * @param key The number to find
    * @return boolean true if the number is found and false if the number is not found
    */
	public abstract boolean search(int key);
}
