package algo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Vertex implements Comparable<Vertex> {
	int id, dist;
	
	Vertex(int id, int dist) {
		this.id = id;
		this.dist = dist;
	}
	
	@Override
	public boolean equals(Object o) {
		Vertex v = (Vertex) o;
		return this.id == v.id && this.dist == v.dist;
	}
	
	@Override
	public int compareTo(Vertex v) {
		return this.dist - v.dist;
	}
	
	@Override
	public String toString() {
		return "The lowest cost path to vertex " + (char)(this.id + 'A') + ": " + this.dist;
	}
}

public class WeightedGraph {
	private static final int OO = (int) 1e9;
	private int [][] matrix;
	private int n; 
	private List<Vertex> path; 
	private static boolean isPrinting = false; 
	
	{
		path = new ArrayList<>();
	}
	
	public WeightedGraph(String filename) throws IOException {
		Scanner in = new Scanner(new File(filename));
		n = in.nextInt();
		matrix = new int [n][n];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
		
		in.close();
	}
	
	public WeightedGraph(String filename, boolean isPrinting) throws IOException {
		this(filename);
		WeightedGraph.isPrinting = isPrinting;
	}
	
	public int [][] getMatrix() {
		return matrix; 
	}
	
	public void setMatrix(int [][] matrix) {
		this.matrix = matrix; 
	}
	
	public int getN() {
		return n; 
	}
	
	public void setN(int n) {
		this.n = n;
	}
	
	public List<Vertex> getPath() {
		return path; 
	}
	
	public void setPath(List<Vertex> path) {
		this.path = path; 
	}
	
	public boolean getIsPrinting() {
		return isPrinting;
	}
	
	public void setIsPrinting(boolean isPrinting) {
		WeightedGraph.isPrinting = isPrinting; 
	}
	
	// BC/AC/WC: O(|V|^2 log |V|) where |V|^2 is the while and for loops and log |V| is 
	// the cost of placing a vertex in the minheap
	// SC: O(|V|) where |V| is the set of vertices
	public void runDijkstra(int source) {
		clear();
		boolean [] visited = new boolean[n];
		int [] dist = new int [n];
		int cnt = 0; 
		
		// populate the distance array with infinity
		Arrays.fill(dist, OO);
		
		// set the source to zero since we are already at the source
		dist[source] = 0;
		
		PriorityQueue<Vertex> minheap = new PriorityQueue<Vertex>();
		
		for (int i = 0; i < dist.length; i++) {
			minheap.add(new Vertex(i, dist[i]));
		}
		
		
		while (!minheap.isEmpty() && cnt < n) {
			// picks out the lowest cost vertex
			Vertex v = minheap.remove();
			
			if (visited[v.id]) {
				continue;
			}
				
			path.add(v);
			visited[v.id] = true; 
			cnt++;
			
			if (isPrinting) {
				System.out.println(v);
			}
			
			
			for (int i = 0; i < matrix.length; i++) {
				// check if the path to this vertex is lower than the current cost of the vertex
				// and update the distance for all adjacent vertices
				if (matrix[v.id][i] > 0 && !visited[i] && dist[v.id] + matrix[v.id][i] < dist[i]) {
					dist[i] = matrix[v.id][i] + dist[v.id];
					minheap.add(new Vertex(i, dist[i]));
				}
			}
		}
		
		if (cnt != n) {
			System.out.println("Oh no! You fed dijkstra a disconnected graph.");
		}
		
	}
	
	public Vertex [] storePath() {
		if (path == null) return new Vertex [] {}; 	
		return path.stream().toArray(Vertex[]::new);
	}
	
	public void clear() {
		path.clear();
	}
}
