package data;

import java.util.LinkedList;

/**
* The SeparateChainingHashTable class inserts, deletes, and searches for keys
* in a hash table of linked lists using generics.
*
* @author  Damola Adebayo
* @version 1.0
* @since   2023-11-14 
*/

public class SeparateChainingHashTable<AnyType> {
	private static final int MAX_BUCKET_SIZE = 5;
	private LinkedList<LinkedList<AnyType>> buckets; 
	private int origCapacity, capacity, size;
	
	{
		buckets = new LinkedList<>();
	}
	
	public SeparateChainingHashTable(int capacity) {
		this.capacity = origCapacity = capacity; 

		int i = 0;
		while (i++ < capacity) {
			buckets.add(new LinkedList<>());
		}
	}
	
	public LinkedList<LinkedList<AnyType>> getBuckets() {
		return buckets; 
	}
	
	public void setBuckets(LinkedList<LinkedList<AnyType>> buckets) {
		this.buckets = buckets;
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
	
    /**
    * This method calculates a hash value for a character using its hash code. 
    * @param key The character to insert into the hash table
    * @return int The hash value
    */
	public int hashChar(Character key) {         
		return key.hashCode() % capacity;
	}
	
    /**
    * This method calculates a hash value for a string using each character one
    * of its characters. 
    * @param key The string to insert into the hash table
    * @return int The hash value
    */
	public int hashString(String key) {         
		int hVal = 7;
		
		for (int i = 0; i < key.length(); i++) {
			hVal = hVal * 31 + key.charAt(i);
		}  
		
		return hVal % capacity;
	}
	
    /**
    * This method calculates a hash value for a number using bit-shifting. 
    * @param key The number to insert into the hash table
    * @return int The hash value
    */
	public int hashNumber(int key) {         
	      key ^= (key << 13);
	      key ^= (key >>> 17);        
	      key ^= (key << 5);
	      return key % capacity;   
	}
	
    /**
    * This method enlarges the hash table's bucket size by twice its capacity.
    */
	public void expandList(int n) {
		if (buckets.get(n).size() == MAX_BUCKET_SIZE) {
			capacity *= 2; 
			
			LinkedList<LinkedList<AnyType>> newBuckets = new LinkedList<>();
			
			int k = 0; 
			while (k++ < capacity) {
				newBuckets.add(new LinkedList<>());
			}
			
			
			for (LinkedList<AnyType> bucket : buckets) {
				for (AnyType key : bucket) {
					insert(key);
				}
			}
			
			buckets = newBuckets; 
		}
 	}
	
    /**
    * This method adds a number to the hash table.
    * @param key The value to add
    * BC/AC: O(1) WC: O(n^2)
    * SC: O(1)
    */
	public void insert(AnyType key) {
		int i = hashPicker(key);
		buckets.get(i).addFirst(key);
		size++;
		expandList(i);
	}
	
    /**
    * This method checks if the number is in the hash table.
    * @param key The value to find
    * @return boolean true if the number is found and false if the number is not found
    * BC/AC: O(1) WC: O(n) 
    * SC: O(1)
    */
	public boolean search(AnyType key) {
		int i = hashPicker(key);
		return buckets.get(i).contains(key);
	}
	
    /**
    * This method removes the first occurrence of the number from the hash table.
    * @param key The value to remove
    * BC/AC: O(1) WC: O(n) 
    * SC: O(1)
    */
	public void delete(AnyType key) {
		int i = hashPicker(key);
		boolean remove = buckets.get(i).remove(key);
		
		if (remove) {
			size--; 
		}
	}
	
    /**
    * This method calculates a hash value for a key based on its type. 
    * @param key The value to hash
    * @return int The hash value
    */
	public int hashPicker(AnyType key) {
		int hVal; 
		if (key instanceof Character) {
			hVal = hashChar((Character) key);
		}
		else if (key instanceof String) {
			hVal = hashString((String) key);
		}
		else {
			hVal = hashNumber((Integer) key);
		}
		
		return hVal;
	}
	
    /**
    * This method displays the contents of the hash table.
    */
	public void print() {
		for (int i = 0; i < buckets.size(); i++) {
			System.out.print(buckets.get(i).size() + ((i + 1 == buckets.size()) ?  "\n" : " "));
		}
	}
	

    /**
    * This method converts the linked list to an array containing the bucket sizes.
    * @return int [] The int array
    */
	public int [] storeList() {
		if (buckets == null) {
			return new int [] {};
		}
		
		int [] arr = new int [buckets.size()];
		
		for (int i = 0; i < buckets.size(); i++) {
			arr[i] = buckets.get(i).size();
		}
		
		return arr;
	}

    /**
    * This method removes all the values in the hash table. 
    */
	public void clear() {
		size = 0;
		capacity = origCapacity;
		buckets = new LinkedList<>();
		
		int i = 0;
		while (i++ < origCapacity) {
			buckets.add(new LinkedList<>());
		}
	}
}
