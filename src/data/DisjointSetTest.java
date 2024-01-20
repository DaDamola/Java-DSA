package data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DisjointSetTest {
	static int [] res1, res2, res3, res4, res5, res6, res7, res8;

	@BeforeAll
	static void setUpBeforeClass() {
		res1 = new int [] {0, 1, 2, 3, 4};
		res2 = new int [] {0, 1, 2, 3, 2}; 
		res4 = new int [] {0, 1, 2, 1, 2}; 
		res6 = new int [] {0, 2, 2, 2, 2};
		res8 = new int [] {0, 2, 2, 1, 2};
		res3 = new int [] {0, 0, 1, 0, 0};
		res5 = new int [] {0, 1, 1, 0, 0};
		res7 = new int [] {0, 1, 2, 0, 0};
	}
	
	@Test
	void makeSet_PositiveNumber_BuildsASet() {
		DisjointSet ds = new DisjointSet(5);
		
		assertArrayEquals(res1, ds.getParent());
		assertArrayEquals(new int [5], ds.getRank());
	}
	
	@Test
	void findSet_NumbersInSets_FindsSetRepresentative() {
		DisjointSet ds = new DisjointSet(5);
		
		assertArrayEquals(res1, ds.findSetArray());
		assertArrayEquals(new int [5], ds.getRank());
				
		ds.union(2, 4);
		assertArrayEquals(res2, ds.findSetArray());
		assertArrayEquals(res3, ds.getRank());
	
		ds.union(1, 3);		
		assertArrayEquals(res4, ds.findSetArray());
		assertArrayEquals(res5, ds.getRank());

		ds.union(2, 3);
		assertArrayEquals(res6, ds.findSetArray());
		assertArrayEquals(res7, ds.getRank());
	}
	
	@Test
	void union_NumbersInDistinctSets_JoinTheSameSet() {
		DisjointSet ds = new DisjointSet(5);
		
		ds.union(2, 4);
		assertArrayEquals(res2, ds.getParent());
		assertArrayEquals(res3, ds.getRank());
		
		ds.union(1, 3);		
		assertArrayEquals(res4, ds.getParent());
		assertArrayEquals(res5, ds.getRank());

		ds.union(2, 3);
		assertArrayEquals(res8, ds.getParent());
		assertArrayEquals(res7, ds.getRank());
	}

	@Test
	void clear_NumbersInSets_ResetsSet() {
		DisjointSet ds = new DisjointSet(5);
		
		assertArrayEquals(res1, ds.getParent());
		assertArrayEquals(res1, ds.findSetArray());
		assertArrayEquals(new int [5], ds.getRank());
		
		ds.union(2, 4);
		assertArrayEquals(res2, ds.getParent());
		assertArrayEquals(res2, ds.findSetArray());
		assertArrayEquals(res3, ds.getRank());
	
		ds.union(1, 3);		
		assertArrayEquals(res4, ds.getParent());
		assertArrayEquals(res4, ds.findSetArray());
		assertArrayEquals(res5, ds.getRank());

		ds.union(2, 3);
		assertArrayEquals(res8, ds.getParent());
		assertArrayEquals(res6, ds.findSetArray());
		assertArrayEquals(res7, ds.getRank());
	
		ds.clear();
		assertArrayEquals(res1, ds.getParent());
		assertArrayEquals(res1, ds.findSetArray());
		assertArrayEquals(new int [5], ds.getRank());
	}
	
	@Test
	void union_NumbersInDistinctSetsAfterClear_JoinTheSameSet() {
		DisjointSet ds = new DisjointSet(5);
		
		assertArrayEquals(res1, ds.getParent());
		assertArrayEquals(res1, ds.findSetArray());
		assertArrayEquals(new int [5], ds.getRank());
		
		ds.union(2, 4);
		assertArrayEquals(res2, ds.getParent());
		assertArrayEquals(res2, ds.findSetArray());
		assertArrayEquals(res3, ds.getRank());
	
		ds.union(1, 3);		
		assertArrayEquals(res4, ds.getParent());
		assertArrayEquals(res4, ds.findSetArray());
		assertArrayEquals(res5, ds.getRank());

		ds.union(2, 3);
		assertArrayEquals(res8, ds.getParent());
		assertArrayEquals(res6, ds.findSetArray());
		assertArrayEquals(res7, ds.getRank());
	
		ds.clear();
		assertArrayEquals(res1, ds.getParent());
		assertArrayEquals(res1, ds.findSetArray());
		assertArrayEquals(new int [5], ds.getRank());
		
		ds.union(2, 4);
		assertArrayEquals(res2, ds.getParent());
		assertArrayEquals(res2, ds.findSetArray());
		assertArrayEquals(res3, ds.getRank());
	
		ds.union(1, 3);		
		assertArrayEquals(res4, ds.getParent());
		assertArrayEquals(res4, ds.findSetArray());
		assertArrayEquals(res5, ds.getRank());

		ds.union(2, 3);
		assertArrayEquals(res8, ds.getParent());
		assertArrayEquals(res6, ds.findSetArray());
		assertArrayEquals(res7, ds.getRank());
	}

}
