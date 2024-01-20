package data;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class TrieTest {
	@Test
	void insert_AnyString_AddsAString() {
		Map<String, Integer> map;
		Trie root = new Trie();
		
		root.insert("Damola");
		root.insert("Damola");
		root.insert("Damola");
		root.insert("Dayo");
		root.insert("Dayo");
		root.insert("Dapo");
		root.insert("Raifu!");
		root.insert("Rai!fu");
		root.insert("!Raifu!");
		root.insert("kemi");
		
		map = root.storeTrie();
		
		assertEquals(3, map.get("damola")); // three times, capitalized
		assertEquals(2, map.get("dayo")); // two times, capitalized
		assertEquals(1, map.get("dapo")); // one time, capitalized
		assertEquals(3, map.get("raifu")); // three times with non-letter chars
		assertEquals(1, map.get("kemi")); // one time, lowercase 
	}
	
	@Test
	void insertRecursive_AnyString_AddsAString() {
		Map<String, Integer> map;
		Trie root = new Trie();
		
		root.insertRecursive("Damola");
		root.insertRecursive("Damola");
		root.insertRecursive("Damola");
		root.insertRecursive("Dayo");
		root.insertRecursive("Dayo");
		root.insertRecursive("Dapo");
		root.insertRecursive("Raifu!");
		root.insertRecursive("Rai!fu");
		root.insertRecursive("!Raifu!");
		root.insertRecursive("kemi");
		
		map = root.storeTrie();
		
		assertEquals(3, map.get("damola"));
		assertEquals(2, map.get("dayo"));
		assertEquals(1, map.get("dapo"));
		assertEquals(3, map.get("raifu"));
		assertEquals(1, map.get("kemi"));	
	}
	
	@Test
	void delete_AnyString_RemovesAString() {
		Map<String, Integer> map;
		Trie root = new Trie();
		
		root.insert("Damola");
		root.insert("Damola");
		root.insert("Damola");
		root.delete("Deolu");
		root.delete("");
		root.delete("D!mola");
		map = root.storeTrie();
		assertEquals(null, map.get("deolu")); // word is not there
		
		root.delete("Damola");
		map = root.storeTrie();
		assertEquals(2, map.get("damola")); // delete once
		
		root.delete("Damola");
		map = root.storeTrie();
		assertEquals(1, map.get("damola")); // delete twice
		
		root.delete("Damola");
		map = root.storeTrie();
		assertEquals(null, map.get("damola")); // delete thrice
		
;
	}
	
	@Test
	void search_StringInTrie_True() {
		Trie root = new Trie();
		
		root.insert("Damola");
		root.insert("Damola");
		root.insert("Damola");
		root.insert("Dayo");
		root.insert("Dayo");
		root.insert("Dapo");
		root.insert("Raifu!");
		root.insert("Rai!fu");
		root.insert("!Raifu!");
		root.insert("kemi");
		
		assertTrue(root.search("Damola"));
		assertTrue(root.search("Dayo"));
		assertTrue(root.search("Dapo"));
		assertTrue(root.search("Raifu"));
		assertTrue(root.search("Kemi"));
	}
	
	@Test
	void searchRecursive_StringInTrie_True() {
		Trie root = new Trie();
		
		root.insert("Damola");
		root.insert("Damola");
		root.insert("Damola");
		root.insert("Dayo");
		root.insert("Dayo");
		root.insert("Dapo");
		root.insert("Raifu!");
		root.insert("Rai!fu");
		root.insert("!Raifu!");
		root.insert("kemi");
		
		assertTrue(root.searchRecursive("Damola"));
		assertTrue(root.searchRecursive("Dayo"));
		assertTrue(root.searchRecursive("Dapo"));
		assertTrue(root.searchRecursive("Raifu"));
		assertTrue(root.searchRecursive("Kemi"));
	}
	
	@Test
	void search_StringNotInTrie_False() {
		Trie root = new Trie();
		
		root.insert("Damola");
		root.insert("Damola");
		root.insert("Damola");
		root.insert("Dayo");
		root.insert("Dayo");
		root.insert("Dapo");
		root.insert("Raifu!");
		root.insert("Rai!fu");
		root.insert("!Raifu!");
		root.insert("kemi");
		
		assertFalse(root.search("Deolu"));
		assertFalse(root.search("eliza"));
		assertFalse(root.search("Will!"));
	}
	
	@Test
	void searchRecursive_StringNotInTrie_False() {
		Trie root = new Trie();
		
		root.insert("Damola");
		root.insert("Damola");
		root.insert("Damola");
		root.insert("Dayo");
		root.insert("Dayo");
		root.insert("Dapo");
		root.insert("Raifu!");
		root.insert("Rai!fu");
		root.insert("!Raifu!");
		root.insert("kemi");
		
		assertFalse(root.searchRecursive("Deolu"));
		assertFalse(root.searchRecursive("eliza"));
		assertFalse(root.searchRecursive("Will!"));
	}
	
	@Test
	void clear_StringsInTrie_RemovesAllStrings() {
		Trie root = new Trie();
		
		assertEquals(null, root.getRoot());
		assertEquals(new HashMap<>(), root.storeTrie());
		
		root.insert("Damola");
		root.insert("Damola");
		root.insert("Damola");
		root.insert("Dayo");
		root.insert("Dayo");
		root.insert("Dapo");
		root.insert("Raifu!");
		root.insert("Rai!fu");
		root.insert("!Raifu!");
		root.insert("kemi");
		
		root.clear();
		
		assertEquals(null, root.getRoot());
		assertEquals(new HashMap<>(), root.storeTrie());
	}
	
	@Test
	void insert_NoStringsInTrieAfterClear_AddsAString() {
		Map<String, Integer> map;
		Trie root = new Trie();
		
		assertEquals(null, root.getRoot());
		assertEquals(new HashMap<>(), root.storeTrie());
		
		root.insert("Damola");
		root.insert("Damola");
		root.insert("Damola");
		root.insert("Dayo");
		root.insert("Dayo");
		root.insert("Dapo");
		root.insert("Raifu!");
		root.insert("Rai!fu");
		root.insert("!Raifu!");
		root.insert("kemi");
		
		root.clear();
		
		assertEquals(null, root.getRoot());
		assertEquals(new HashMap<>(), root.storeTrie());
		
		root.insert("Damola");
		root.insert("Damola");
		root.insert("Damola");
		root.insert("Dayo");
		root.insert("Dayo");
		root.insert("Dapo");
		root.insert("Raifu!");
		root.insert("Rai!fu");
		root.insert("!Raifu!");
		root.insert("kemi");
		
		map = root.storeTrie();
		
		assertEquals(3, map.get("damola")); // three times, capitalized
		assertEquals(2, map.get("dayo")); // two times, capitalized
		assertEquals(1, map.get("dapo")); // one time, capitalized
		assertEquals(3, map.get("raifu")); // three times with non-letter chars
		assertEquals(1, map.get("kemi")); // one time, lowercase 
	}


}
