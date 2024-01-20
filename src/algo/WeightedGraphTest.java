package algo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class WeightedGraphTest {
	static String dijkstraFile1;
	static Vertex [] res1, res2, res3, res4, res5, res6, res7, res8, res9;
	static WeightedGraph g1;

	@BeforeAll
	static void setUpBeforeClass() throws IOException  {
		dijkstraFile1 = "dijkstra.txt";
		g1 = new WeightedGraph(dijkstraFile1);
		
		res1 = new Vertex [] {new Vertex(0, 0), new Vertex(8, 1), new Vertex(4, 3), new Vertex(6, 4),
							  new Vertex(1, 5), new Vertex(5, 5), new Vertex(7, 6), new Vertex(2, 7), 
							  new Vertex(3, 15)};
		res2 = new Vertex [] {new Vertex(1, 0), new Vertex(0, 5), new Vertex(8, 6), new Vertex(2, 7),
							  new Vertex(4, 8), new Vertex(6, 9), new Vertex(5, 10), new Vertex(7, 11), 
							  new Vertex(3, 15)};
		res3 = new Vertex [] {new Vertex(2, 0), new Vertex(8, 6), new Vertex(1, 7), new Vertex(0, 7),
							  new Vertex(3, 8), new Vertex(4, 8), new Vertex(6, 9), new Vertex(5, 10), 
							  new Vertex(7, 11)};
		res4 = new Vertex [] {new Vertex(3, 0), new Vertex(2, 8), new Vertex(8, 14), new Vertex(1, 15),
							  new Vertex(0, 15), new Vertex(4, 16), new Vertex(6, 17), new Vertex(5, 18), 
							  new Vertex(7, 19)};
		res5 = new Vertex [] {new Vertex(4, 0), new Vertex(8, 2), new Vertex(0, 3), new Vertex(5, 4),
							  new Vertex(6, 5), new Vertex(7, 7), new Vertex(2, 8), new Vertex(1, 8), 
							  new Vertex(3, 16)};
		res6 = new Vertex [] {new Vertex(5, 0), new Vertex(6, 1), new Vertex(7, 3), new Vertex(4, 4),
							  new Vertex(8, 4), new Vertex(0, 5), new Vertex(2, 10), new Vertex(1, 10), 
							  new Vertex(3, 18)};
		res7 = new Vertex [] {new Vertex(6, 0), new Vertex(5, 1), new Vertex(7, 2), new Vertex(8, 3),
							  new Vertex(0, 4), new Vertex(4, 5), new Vertex(2, 9), new Vertex(1, 9), 
							  new Vertex(3, 17)};
		res8 = new Vertex [] {new Vertex(7, 0), new Vertex(6, 2), new Vertex(5, 3), new Vertex(8, 5),
							  new Vertex(0, 6), new Vertex(4, 7), new Vertex(2, 11), new Vertex(1, 11), 
							  new Vertex(3, 19)};
		res9 = new Vertex [] {new Vertex(8, 0), new Vertex(0, 1), new Vertex(4, 2), new Vertex(6, 3),
							  new Vertex(5, 4), new Vertex(7, 5), new Vertex(1, 6), new Vertex(2, 6), 
							  new Vertex(3, 14)};
	}

	@Test
	void runDijkstra_GraphHasPositiveWeights_FindsTheLowestCostPath() {
		g1.runDijkstra(0);
		assertArrayEquals(res1, g1.storePath());
		
		g1.runDijkstra(1);
		assertArrayEquals(res2, g1.storePath());
		
		g1.runDijkstra(2);
		assertArrayEquals(res3, g1.storePath());
		
		g1.runDijkstra(3);
		assertArrayEquals(res4, g1.storePath());
		
		g1.runDijkstra(4);
		assertArrayEquals(res5, g1.storePath());
		
		g1.runDijkstra(5);
		assertArrayEquals(res6, g1.storePath());
		
		g1.runDijkstra(6);
		assertArrayEquals(res7, g1.storePath());
		
		g1.runDijkstra(7);
		assertArrayEquals(res8, g1.storePath());
		
		g1.runDijkstra(8);
		assertArrayEquals(res9, g1.storePath());
	}
	
	@Test
	void clear_NoGraph_HasAnEmptyPath() throws IOException {
		WeightedGraph g1 = new WeightedGraph(dijkstraFile1);
		
		g1.runDijkstra(0);
		g1.clear();
		
		assertEquals(0, g1.getPath().size());
		assertArrayEquals(new Vertex [] {}, g1.storePath());
	}
	
	@Test
	void runDijkstra_GraphHasPositiveWeightsAfterClear_FindsTheLowestCostPath() throws IOException {
		WeightedGraph g1 = new WeightedGraph(dijkstraFile1);
		
		g1.runDijkstra(0);
		g1.clear();
		
		assertEquals(0, g1.getPath().size());
		assertArrayEquals(new Vertex [] {}, g1.storePath());
		
		g1.runDijkstra(0);
		assertArrayEquals(res1, g1.storePath());
	}
}
