package data;

import java.util.Arrays;

/**
* The CircularLinkedList class creates a linked list where all the nodes are
* connected to form a circle. The first node is connected to the last node
* and there are no null values. It is implemented with generics.
* @author  Damola Adebayo
* @version 1.0
* @since   2023-09-03
*/

public class DisjointSet {	
	private int [] parent, rank, set;
	
	public DisjointSet(int n) {
		parent = new int [n];
		rank = new int [n];
		set = new int [n];
		
		makeSet(n);
	}
	
	public int [] getParent() {
		return parent;
	}
	
	public void setParent(int [] parent) {
		this.parent = parent;
	}
	
	public int [] getRank() {
		return rank;
	}
	
	public void setRank(int [] rank) {
		this.rank = rank;
	}
	
	public int [] getSet() {
		return set;
	}
	
	public void setSet(int [] set) {
		this.set = set;
	}
	
    /**
    * This method checks if the linked list contains the generic value.
    * @param data The generic value to find
    * @return boolean true if the value is found and false if the value is not found
    * BC: O(1) AC/WC: O(n)
    * SC: O(1) 
    */
	// BC/AC/WC: O(n)
	// SC: O(1)
	public void makeSet(int n) {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}
	
	// BC: O(1) AC/WC: O(n)
	// SC: O(1)
	public int findSet(int v) {
		if (parent[v] == v) {
			return v;
		}
		
		int res = findSet(parent[v]);
		parent[v] = res;
		
		return res;
	}
	
	// BC: O(1) AC/WC: O(n)
	// SC: O(1)
	public boolean union(int x, int y) {
		int setX = findSet(x);
		int setY = findSet(y);
		
		if (setX == setY) {
			return false;
		}
		
		if (rank[setX] >= rank[setY]) {
			parent[setY] = setX;
			rank[setX] += 1;
		}
		else {
			parent[setX] = setY;
			rank[setY] += 1;
		}
		
		return true;
	}
	
	public int [] findSetArray() {
		for (int i = 0; i < set.length; i++) {
			set[i] = findSet(parent[i]);
		}
		
		return set;
	}
	
	public void printArray(String name, int [] arr) {
		System.out.println(name + ":");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ((i + 1 == arr.length) ? "\n" : " "));
		}
	}
	
	public void printParent() {
		printArray("Parent", parent);
	}
	
	public void printRank() {
		printArray("Rank", rank);
	}
	
	public void printSetArray() {
		printArray("Set", set);
	}
	
	public void clear() {
		Arrays.fill(rank, 0);
		Arrays.fill(set, 0);
		
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}
}
