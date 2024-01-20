package algo;

import static org.junit.jupiter.api.Assertions.*;


import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UnweightedGraphTest {
	static String graphFile1, graphFile2, topoSortFile1, hamiltonCycleFile1, eulerCycleFile1,
	eulerPathFile1, unconnectedGraphFile1, unconnectedGraphFile2, evenCycleGraph, oddCycleGraph;
	static int [] res1, res2, res3, res4, res5, res6, res7, res8, res9, res10,
	res11, res12, res13, res14, res15, res16, res17, res18, res19, res20, res21,
	res22, res23, res24, res25, res26, res27, res28, res29, res30;
	static UnweightedGraph g1, g2, g3, g4, g5, g6, g7, g8, g9, g10;
	
	@BeforeAll
	static void setUp() throws IOException {
		graphFile1 = "g1.txt";
		graphFile2 = "g2.txt";
		topoSortFile1 =  "prereqs.txt";
		hamiltonCycleFile1 = "hamilton.txt";
		eulerCycleFile1 = "eulerCycle.txt";
		eulerPathFile1 = "eulerPath.txt";
		unconnectedGraphFile1 = "unconnectedGraph1.txt";
		unconnectedGraphFile2 = "unconnectedGraph2.txt";
		evenCycleGraph = "evenCycleGraph.txt";
		oddCycleGraph = "oddCycleGraph.txt";
		
		g1 = new UnweightedGraph(graphFile1);
		g2 = new UnweightedGraph(graphFile2);
		g3 = new UnweightedGraph(topoSortFile1);
		g4 = new UnweightedGraph(hamiltonCycleFile1);
		g5 = new UnweightedGraph(eulerCycleFile1);
		g6 = new UnweightedGraph(eulerPathFile1);
		g7 = new UnweightedGraph(unconnectedGraphFile1);
		g8 = new UnweightedGraph(unconnectedGraphFile2);
		g9 = new UnweightedGraph(evenCycleGraph);
		g10 = new UnweightedGraph(oddCycleGraph);
		
		// BFS 
		res1 = new int [] {0, 1, 3, 2};
		res2 = new int [] {1, 0, 2, 3};
		res3 = new int [] {2, 1, 3, 0};
		res4 = new int [] {3, 0, 1, 2};

		res5 = new int [] {0, 2, 4, 1, 3};
		res6 = new int [] {1, 2, 0, 4, 3};
		res7 = new int [] {2, 0, 1, 4, 3};
		res8 = new int [] {3, 4, 0, 2, 1};
		res9 = new int [] {4, 0, 3, 2, 1};
		
		// DFS
		res10 = new int [] {0, 1, 2, 3};
		res11 = new int [] {1, 0, 3, 2};
		res12 = new int [] {2, 1, 0, 3};
		
		res13 = new int [] {0, 2, 1, 4, 3};
		res14 = new int [] {2, 0, 4, 3, 1};
		res15 = new int [] {4, 0, 2, 1, 3};
		
		// topological sort
		res16 = new int [] {0, 1, 2, 3, 4, 6, 5, 7};
		
		// hamilton cycle
		res17 = new int [] {0, 4, 1, 5, 6, 2, 3, 0};
		res18 = new int [] {1, 5, 6, 0, 4, 3, 2, 1};
		res19 = new int [] {2, 1, 5, 6, 0, 4, 3, 2};
		res20 = new int [] {3, 0, 4, 1, 5, 6, 2, 3};
		res21 = new int [] {4, 1, 5, 6, 2, 3, 0, 4};
		res22 = new int [] {5, 6, 0, 4, 3, 2, 1, 5};
		res23 = new int [] {6, 0, 4, 3, 2, 1, 5, 6};
		
		// hamilton path
		res24 = new int [] {0, 4, 1, 5, 6, 2, 3};
		res25 = new int [] {1, 5, 6, 0, 4, 3, 2};
		res26 = new int [] {2, 1, 5, 6, 0, 4, 3};
		res27 = new int [] {3, 0, 4, 1, 5, 6, 2};
		res28 = new int [] {4, 1, 5, 6, 2, 3, 0};
		res29 = new int [] {5, 6, 0, 4, 3, 2, 1};
		res30 = new int [] {6, 0, 4, 3, 2, 1, 5};
	}

	@Test
	void BFS_VertexOnGraph_FindsAPath() {		
		g1.BFS(0);
		int [] out1 = g1.storePath();
		
		g1.BFS(1);
		int [] out2 = g1.storePath();
		
		g1.BFS(2);
		int [] out3 = g1.storePath();
		
		g1.BFS(3);
		int [] out4 = g1.storePath();
		
		g2.BFS(0);
		int [] out5 = g2.storePath();
		
		g2.BFS(1);
		int [] out6 = g2.storePath();
		
		g2.BFS(2);
		int [] out7 = g2.storePath();
		
		g2.BFS(3);
		int [] out8 = g2.storePath();
		
		g2.BFS(4);
		int [] out9 = g2.storePath();
		
		assertArrayEquals(res1, out1);
		assertArrayEquals(res2, out2);
		assertArrayEquals(res3, out3);
		assertArrayEquals(res4, out4);
		
		assertArrayEquals(res5, out5);
		assertArrayEquals(res6, out6);
		assertArrayEquals(res7, out7);
		assertArrayEquals(res8, out8);
		assertArrayEquals(res9, out9);
	}

	@Test
	void BFSRecursive_VertexOnGraph_FindsAPath() {
		g1.BFSRecursive(0);
		int [] out1 = g1.storePath();
		
		g1.BFSRecursive(1);
		int [] out2 = g1.storePath();
		
		g1.BFSRecursive(2);
		int [] out3 = g1.storePath();
		
		g1.BFSRecursive(3);
		int [] out4 = g1.storePath();
		
		g2.BFSRecursive(0);
		int [] out5 = g2.storePath();
		
		g2.BFSRecursive(1);
		int [] out6 = g2.storePath();
		
		g2.BFSRecursive(2);
		int [] out7 = g2.storePath();
		
		g2.BFSRecursive(3);
		int [] out8 = g2.storePath();
		
		g2.BFSRecursive(4);
		int [] out9 = g2.storePath();

		assertArrayEquals(res1, out1);
		assertArrayEquals(res2, out2);
		assertArrayEquals(res3, out3);
		assertArrayEquals(res4, out4);
		
		assertArrayEquals(res5, out5);
		assertArrayEquals(res6, out6);
		assertArrayEquals(res7, out7);
		assertArrayEquals(res8, out8);
		assertArrayEquals(res9, out9);
	}
	
	@Test
	void DFS_VertexOnGraph_FindsAPath() {
		g1.DFS(0);
		int [] out1 = g1.storePath();
		
		g1.DFS(1);
		int [] out2 = g1.storePath();
		
		g1.DFS(2);
		int [] out3 = g1.storePath();
		
		g1.DFS(3);
		int [] out4 = g1.storePath();
		
		g2.DFS(0);
		int [] out5 = g2.storePath();
		
		g2.DFS(1);
		int [] out6 = g2.storePath();
		
		g2.DFS(2);
		int [] out7 = g2.storePath();
		
		g2.DFS(3);
		int [] out8 = g2.storePath();
		
		g2.DFS(4);
		int [] out9 = g2.storePath();
		
		assertArrayEquals(res10, out1);
		assertArrayEquals(res11, out2);
		assertArrayEquals(res12, out3);
		assertArrayEquals(res4, out4);
		
		assertArrayEquals(res13, out5);
		assertArrayEquals(res6, out6);
		assertArrayEquals(res14, out7);
		assertArrayEquals(res8, out8);
		assertArrayEquals(res15, out9);
	}
	
	@Test
	void DFSIterative_VertexOnGraph_FindsAPath() {
		g1.DFSIterative(0);
		int [] out1 = g1.storePath();
		
		g1.DFSIterative(1);
		int [] out2 = g1.storePath();
		
		g1.DFSIterative(2);
		int [] out3 = g1.storePath();
		
		g1.DFSIterative(3);
		int [] out4 = g1.storePath();
		
		g2.DFSIterative(0);
		int [] out5 = g2.storePath();
		
		g2.DFSIterative(1);
		int [] out6 = g2.storePath();
		
		g2.DFSIterative(2);
		int [] out7 = g2.storePath();
		
		g2.DFSIterative(3);
		int [] out8 = g2.storePath();
		
		g2.DFSIterative(4);
		int [] out9 = g2.storePath();
		
		assertArrayEquals(res10, out1);
		assertArrayEquals(res11, out2);
		assertArrayEquals(res12, out3);
		assertArrayEquals(res4, out4);
		
		assertArrayEquals(res13, out5);
		assertArrayEquals(res6, out6);
		assertArrayEquals(res14, out7);
		assertArrayEquals(res8, out8);
		assertArrayEquals(res15, out9);
	}
	
	@Test
	void topologicalSort_GraphHasNoDirectedCycles_FindsAPath() {
		g3.topologicalSort();
		int [] out1 = g3.storePath();
		
		assertArrayEquals(res16, out1);
	}
	
	@Test
	void hasHamiltonCycle_VertexOnGraph_True() {
		assertTrue(g4.hasHamiltonCycle(0));
		assertArrayEquals(res17, g4.storePath());
		
		assertTrue(g4.hasHamiltonCycle(1));
		assertArrayEquals(res18, g4.storePath());
		
		assertTrue(g4.hasHamiltonCycle(2));
		assertArrayEquals(res19, g4.storePath());
		
		assertTrue(g4.hasHamiltonCycle(3));
		assertArrayEquals(res20, g4.storePath());
		
		assertTrue(g4.hasHamiltonCycle(4));
		assertArrayEquals(res21, g4.storePath());
		
		assertTrue(g4.hasHamiltonCycle(5));
		assertArrayEquals(res22, g4.storePath());
		
		assertTrue(g4.hasHamiltonCycle(6));
		assertArrayEquals(res23, g4.storePath());
	}
	
	@Test
	void hasHamiltonCycle_VertexOnGraph_False() {
		assertFalse(g2.hasHamiltonCycle(0));
		assertFalse(g3.hasHamiltonCycle(0));
	}
	
	@Test
	void hasHamiltonPath_VertexOnGraph_True() {
		assertTrue(g4.hasHamiltonPath(0));
		assertArrayEquals(res24, g4.storePath());
		
		assertTrue(g4.hasHamiltonPath(1));
		assertArrayEquals(res25, g4.storePath());
		
		assertTrue(g4.hasHamiltonPath(2));
		assertArrayEquals(res26, g4.storePath());
		
		assertTrue(g4.hasHamiltonPath(3));
		assertArrayEquals(res27, g4.storePath());
		
		assertTrue(g4.hasHamiltonPath(4));
		assertArrayEquals(res28, g4.storePath());
		
		assertTrue(g4.hasHamiltonPath(5));
		assertArrayEquals(res29, g4.storePath());
		
		assertTrue(g4.hasHamiltonPath(6));
		assertArrayEquals(res30, g4.storePath());
	}
	
	@Test
	void hasHamiltonPath_VertexOnGraph_False() {
		assertFalse(g2.hasHamiltonPath(0));
		assertFalse(g3.hasHamiltonPath(0));
	}
	
	@Test
	void hasEulerCycle_ConnectedGraph_True() {
		assertTrue(g5.hasEulerCycle());
	}
	
	@Test
	void hasEulerCycle_ConnectedGraph_False() {
		assertFalse(g6.hasEulerCycle());
		assertFalse(g4.hasEulerCycle());
		assertFalse(g3.hasEulerCycle());
		assertFalse(g2.hasEulerCycle());
		assertFalse(g1.hasEulerCycle());
	}
	
	@Test
	void hasEulerPath_ConnectedGraph_True() {
		assertTrue(g6.hasEulerPath());
		assertTrue(g1.hasEulerPath());
		assertTrue(g2.hasEulerPath());
	}
	
	@Test
	void hasEulerPath_ConnectedGraph_False() {
		assertFalse(g5.hasEulerPath());
		assertFalse(g4.hasEulerPath());
		assertFalse(g3.hasEulerPath());
	}
	
	@Test
	void isConnected_ConnectedGraph_True() {
		assertTrue(g1.isConnected());
		assertTrue(g2.isConnected());
		assertTrue(g4.isConnected());
		assertTrue(g5.isConnected());
		assertTrue(g6.isConnected());
	}
	
	@Test
	void isConnected_UnconnectedGraph_False() {
		assertFalse(g7.isConnected());
		assertFalse(g8.isConnected());
	}
	
	@Test
	void clear_NoGraph_HasAnEmptyPath() throws IOException {
		UnweightedGraph g1 = new UnweightedGraph(graphFile1, false);
		
		g1.BFS(0);
		int [] out1 = g1.storePath();
		assertArrayEquals(res1, out1);
		
		g1.clear();
		
		assertEquals(0, g1.getPath().size());
		assertArrayEquals(new int [] {}, g1.storePath());
	}
	
	@Test
	void BFS_NoVertexOnGraphAfterClear_FindsAPath() throws IOException {
		UnweightedGraph g1 = new UnweightedGraph(graphFile1, false);
		
		g1.BFS(0);
		int [] out0 = g1.storePath();
		assertArrayEquals(res1, out0);
		
		g1.clear();
		
		assertEquals(0, g1.getPath().size());
		assertArrayEquals(new int [] {}, g1.storePath());
		
		g1.BFS(0);
		int [] out1 = g1.storePath();
		
		assertArrayEquals(res1, out1);
	}
	
	@Test
	void isBipartite_EvenCycleGraph_True() {
		assertTrue(g9.isBipartite());
	}
	
	@Test
	void isBipartite_OddCycleGraph_False() {
		assertFalse(g10.isBipartite());
	}
}
