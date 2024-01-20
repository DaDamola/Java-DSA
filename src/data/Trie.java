package data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
* The Trie class creates a tree data structure to store collections of strings.
* @author  Damola Adebayo
* @version 1.0
* @since   2024-1-17
*/

class TrieNode {
	int count;
	TrieNode [] children; 
	
	TrieNode() {
		children = new TrieNode [26];
	}
}

public class Trie {
	private TrieNode root; 
	private int size; 
	
	public TrieNode getRoot() {
		return root;
	}
	
	public void setRoot(TrieNode root) {
		this.root = root; 
	}
	
	public int getSize() {
		return size; 
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
    /**
    * This method adds a string to the trie.
    * @param s The string to insert
    * BC/AC/WC: O(k) where k is the length of the string
    * SC: O(k)
    */
	public void insert(String s) {
		if (root == null) {
			root = new TrieNode();
		}
		
		TrieNode wizard = root;
		
		for (int i = 0; i < s.length(); i++) {
			char ch = Character.toLowerCase(s.charAt(i)); 
			
			if (!Character.isLetter(ch)) {
				continue; 
			}
			
			int j = ch - 'a';
			
			if (wizard.children[j] == null) {
				wizard.children[j] = new TrieNode();
			}
			
			wizard = wizard.children[j];
		}
		
		wizard.count++;
		size++;
	}
	
	public void insertRecursive(String s) {
		insertRecursive(root, s);
	}
	
	public void insertRecursive(TrieNode wizard, String s) {
		if (wizard == null) {
			wizard = root = new TrieNode();
		}
		else if (s.length() == 0) {
			wizard.count++;
			size++;
			return;
		}
				
		char ch = Character.toLowerCase(s.charAt(0));

		if (Character.isLetter(ch)) {
			int j = ch - 'a';
			
			if (wizard.children[j] == null) {
				wizard.children[j] = new TrieNode();
			}
			
			wizard = wizard.children[j];
		}
		
		insertRecursive(wizard, s.substring(1));
	}
	
    /**
    * This method checks if the trie contains the string.
    * @param s The string to find
    * @return boolean true if the string is found and false if the string is not found
    * BC: O(1) - no child for this letter 
    * AC/WC: O(k)
    * SC: O(1) 
    */
	public boolean search(String s) {
		if (root == null) {
			return false;
		}
		
		TrieNode wizard = root;
		
		for (int i = 0; i < s.length(); i++) {
			char ch = Character.toLowerCase(s.charAt(i));
			
			if (!Character.isLetter(ch)) {
				continue; 
			}
			
			int j = ch - 'a';
			
			if (wizard.children[j] == null) {
				return false;
			}
			
			wizard = wizard.children[j];
		}
		
		return wizard.count > 0;
	}
	
	public boolean searchRecursive(String s) {
		return searchRecursive(root, s);
	}
	
	public static boolean searchRecursive(TrieNode wizard, String s) {
		if (wizard == null) {
			return false;
		}
		else if (s.isEmpty()) {
			return wizard.count > 0;
		}
		
		char ch = Character.toLowerCase(s.charAt(0));
		
		if (Character.isLetter(ch)) {
			int j = ch - 'a';
			
			if (wizard.children[j] == null) {
				return false;
			}
			
			wizard = wizard.children[j];
		}
		
		return searchRecursive(wizard, s.substring(1));
	}
	
    /**
    * This method checks if the parent node has any children.
    * @param root The parent node
    * BC/AC/WC: O(1)
    * SC: O(1)	
    */
	public static boolean hasChildren(TrieNode root) {
		return Arrays.stream(root.children).anyMatch(child -> child != null);
	}
	
    /**
    * This method removes the one occurrence of the string from the trie.
    * @param s The string to remove
    * BC: O(1) AC/WC: O(k)
    * SC: O(1)	
    */
	public void delete(String s) {
		root = deleteHelper(root, s);
	}
	
	public TrieNode deleteHelper(TrieNode wizard, String s) {
		if (wizard == null) {
			return null;
		}
		else if (s.length() == 0) {
			if (wizard.count > 0) {
				wizard.count--;
				size--;
				
				if (wizard.count == 0 && !hasChildren(wizard)) {
					wizard = null;
				}
			}
		}
		else {
			char ch = Character.toLowerCase(s.charAt(0));		
			
			if (Character.isLetter(ch)) {
				int i = ch - 'a';
				wizard.children[i] = deleteHelper(wizard.children[i], s.substring(1));
			}
			else {
				wizard = deleteHelper(wizard, s.substring(1));
			}
			
			if (wizard.count == 0 && !hasChildren(wizard)) {
				wizard = null;
			}	
		}
		
		return wizard;
	}
	
    /**
    * This method prints the all the strings and their number of occurrences in the trie. 
    */
	public void printTrie() {
		printTrie(root, new StringBuilder(""));
	}
	
	public static void printTrie(TrieNode root, StringBuilder sb) {
		if (root == null) {
			return; 
		}
		
		if (root.count > 0) {
			System.out.println(sb.toString() + " (" + root.count + ")");
		}
		
		for (int i = 0; i < root.children.length; i++) {
			sb.append((char) ('a' + i));
			printTrie(root.children[i], sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
    /**
    * This method converts the trie to a map.
    * @return Map<String, Integer> The map
    */
	public Map<String, Integer> storeTrie() {
		Map<String, Integer> map = new HashMap<>();
		storeTrieHelper(root, new StringBuilder(""), map);
		return map;
	}
	
	public static void storeTrieHelper(TrieNode root, StringBuilder sb, Map<String, Integer> map) {
		if (root == null) {
			return;
		}
		
		if (root.count > 0) {
			map.put(sb.toString(), root.count);
		}
		
		for (int i = 0; i < root.children.length; i++) {
			sb.append((char)( 'a' + i));
			storeTrieHelper(root.children[i], sb, map);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
    /**
    * This method removes all the strings from the trie. 
    */
	public void clear() {
		Map<String, Integer> map = storeTrie();

		for (String key : map.keySet()) {
			Integer val = map.get(key);
			
			while (val > 0) {
				delete(key);
				val--;
			}
		}
	}
}
