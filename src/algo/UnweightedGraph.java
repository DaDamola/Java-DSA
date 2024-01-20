package algo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class UnweightedGraph {
	private boolean [][] matrix;
	private List<Integer> path; 
	private static String [] courses; 
	private static boolean isPrinting = false; 
	
	static {
		courses = new String [] {"C Programming", "Intro to Discrete", "Comp Sci I",
				 				 "Object-Oriented Programming", "Comp Org", 
				 				 "Comp Sci II", "Foundation Exam", "Big Discrete"};
	}
	
	{
		path = new ArrayList<>();
	}
	
	public UnweightedGraph(String filename) throws IOException {
		Scanner in = new Scanner(new File(filename));
		int n = in.nextInt();
		matrix = new boolean [n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = (in.nextInt() == 1); 
			}
		}
		
		in.close();
	}
	
	public UnweightedGraph(String filename, boolean isPrinting) throws IOException {
		this(filename);
		UnweightedGraph.isPrinting = isPrinting;
	}
	
	public boolean [][] getMatrix() {
		return matrix; 
	}
	
	public void setMatrix(boolean [][] matrix) {
		this.matrix = matrix; 
	}
	
	public List<Integer> getPath() {
		return path; 
	}
	
	public void setPath(List<Integer> path) {
		this.path = path; 
	}
	
	public static String [] getCourses() {
		return courses; 
	}
	
	public static void setCourses(String [] courses) {
		UnweightedGraph.courses = courses; 
	}
	
	public boolean getIsPrinting() {
		return isPrinting;
	}
	
	public void setIsPrinting(boolean isPrinting) {
		UnweightedGraph.isPrinting = isPrinting; 
	}
	
	// BC/AC/WC: O(|V|^2) 
	// SC: O(|V|)
	public void BFS(int start) {
		clear();
		boolean [] visited = new boolean [matrix.length];
		Queue<Integer> q = new ArrayDeque<>();	
		
		// add the first vertex 
		q.add(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
			// pull the vertex off the queue 
			int node = q.remove();
			path.add(node); 
			
			if (isPrinting) {
				System.out.print(node + " ");
			}
			
			// visit all this vertex's neighbors
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[node][i] && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
		if (isPrinting) {
			System.out.println();
		}	
	}
	
	public void BFSRecursive(int start) {
		clear();
		boolean [] visited = new boolean [matrix.length];
		Queue<Integer> q = new ArrayDeque<>();	
		
		q.add(start);
		visited[start] = true;
		BFSRecursive(q, visited);
	}
	
	public void BFSRecursive(Queue<Integer> q, boolean [] visited) {
		if (q.isEmpty()) {
			if (isPrinting) {
				System.out.println();
			}	
			
			return; 
		}
		
		int node = q.remove();
		path.add(node);
		
		if (isPrinting) {
			System.out.print(node + " ");
		}
		
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[node][i] && !visited[i]) {
				q.add(i);
				visited[i] = true;
			}
		}
		
		BFSRecursive(q, visited);
	}
	
	// BC/AC/WC: O(|V|^2) 
	// SC: O(|V|)
	public void DFS(int start) {
		boolean [] visited = new boolean [matrix.length];
		clear();
		
		DFS(start, visited);
		
		if (isPrinting) {
			System.out.println();
		}
	}
	
	public void DFS(int start, boolean [] visited) {
		if (visited[start]) {
			return; 
		}
		
		if (isPrinting) {
			System.out.print(start + " ");
		}
		
		// visit this vertex 
		visited[start] = true;
		path.add(start);
		
		// pick the next vertex 
		for (int i = 0; i < visited.length; i++) {
			if (matrix[start][i] && !visited[i]) {
				DFS(i, visited);
			}
		}
	}
	
	public void DFSIterative(int start) {
		clear();
		Stack<Integer> s = new Stack<>();
		boolean [] visited = new boolean [matrix.length];
		
		s.push(start);
		
		while (!s.isEmpty()) {
			int node = s.pop();
			
			if (visited[node]) {
				continue;
			}
			
			if (isPrinting) {
				System.out.print(node + " ");
			}
			
			visited[node] = true;
			path.add(node);
			
			for (int i = matrix.length - 1; i >= 0; i--) {
				if (matrix[node][i] && !visited[i]) {
					s.push(i);
				}
			}
		}
		
		if (isPrinting) {
			System.out.println();
		}
	}
	
	// BC/AC/WC: O(|V|^2) 
	// SC: O(|V|)
	public void topologicalSort() {
		clear();
		int cnt = 0; 
		Queue<Integer> q = new LinkedList<>();
		int [] incoming = new int [matrix.length];
		
		// find incoming edges for all vertexes
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				incoming[j] += (matrix[i][j]) ? 1 : 0;  
			}
		}
		
		// add vertexes with no incoming edges
		for (int i = 0; i < incoming.length; i++) {
			if (incoming[i] == 0) {
				q.add(i);
			}
		}
		
		while (!q.isEmpty()) {	
			// pull the vertex from the queue 
			int node = q.remove();
			path.add(node);
			cnt++;
			
			if (isPrinting) {
				System.out.print(node + " ");
			}
			
			// add the next vertexes with no incoming edges
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[node][i] && --incoming[i] == 0) {
					q.add(i);
				}
			}
		}
			
		if (cnt != matrix.length) {
			System.out.println("Error: Graph contains a cycle!");
		}
	
		if (isPrinting) {
			System.out.println();
		}
	}
	
	// BC/AC/WC: O(|V|^2)
	// SC: O(|V|) where |V| is the set of vertices
	public boolean hasHamiltonCycle(int start) {
		clear();
		int [] cycle = new int [matrix.length];
		boolean [] used = new boolean [matrix.length];
		
		// begin the cycle
		cycle[0] = start;
		used[start] = true;
		
		if (hasHamiltonCycle(cycle, used, 1)) {
			// display the cycle
			for (int i = 0; i < cycle.length; i++) {
				if (isPrinting) {
					System.out.print((char)(cycle[i] + 'A') + ", ");
				}
				
				path.add(cycle[i]);
			}
			
			if (isPrinting) {
				System.out.println((char)(cycle[0] + 'A'));
			}
			
			path.add(cycle[0]);
			
			return true;
		}
		
		return false;
	}
	
	public boolean hasHamiltonCycle(int [] cycle, boolean [] used, int k) {
		int v = cycle[k - 1];
		
		// a cycle exists if there is an edge back to the start vertex
		if (k >= cycle.length) {
			return matrix[v][cycle[0]];
		}
		
		for (int i = 0; i < cycle.length; i++) {
			if (!used[i] && matrix[v][i])  {
				// pick a vertex
				cycle[k] = i;
				used[i] = true;
				
				// continue from the new vertex
				if (hasHamiltonCycle(cycle, used, k + 1)) {
					return true;
				}
				
				// unvisit the vertex, so we can pick a new vertex for this position
				used[i] = false;
			}
		}
		
		return false;
	}
	
	// BC/AC/WC: O(|V|^2)
	// SC: O(|V|)
	public boolean hasHamiltonPath(int start) {
		clear();
		boolean [] visited = new boolean [matrix.length];
		int [] trail = new int [matrix.length];
		
		trail[0] = start;
		visited[start] = true;
		
		if (hasHamiltonPath(trail, visited, 1)) {
			for (int i : trail) {
				path.add(i);
			}
			
			return true;
		}
		
		return false;
	}
	
	public boolean hasHamiltonPath(int [] trail, boolean [] visited, int k) {
		if (k >= trail.length) {
			return true;
		}
		
		int v = trail[k - 1];
		
		for (int i = 0; i < trail.length; i++) {
			if (matrix[v][i] && !visited[i]) {
				trail[k] = i;
				visited[i] = true;
				
				if (hasHamiltonPath(trail, visited, k + 1)) {
					return true;
				}
				
				visited[i] = false;
			}
		}
		
		return false;
	}
	
	// BC: O(|V|) AC/WC: O(|V|^2)
	// SC: O(1)
	public boolean hasEulerCycle() {
		for (int i = 0; i < matrix.length; i++) {
			int cnt = 0;
			
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j]) {
					cnt++;
				}
			}
			
			// check if each vertex has an even number of edges (even degree)
			if (cnt % 2 == 1) {
				return false;
			}
		}
		
		return true;
	}
	

	// BC/AC/WC: O(|V|^2)
	// SC: O(1)
	public boolean hasEulerPath() {
		int oddDegCnt = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			int cnt = 0;
			
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j]) {
					cnt++;
				}
			}
			
			if (cnt % 2 == 1) {
				oddDegCnt++;
				
				if (oddDegCnt > 2) {
					return false;
				}
			}
		}
		
		// check if only two vertexes have an odd degree and all other vertexes have an even degree
		return oddDegCnt == 2;
	}
	
	// BC/AC/WC: O(|V|^2)
	// SC: O(|V|)
	public boolean isConnected() {
		boolean [] visited = new boolean [matrix.length];
		DFS(0, visited);
		
		for (boolean v : visited) {
			if (!v) {
				return false; 
			}
		}
		
		return true;
	}
	
	// BC/AC/WC: O(|V|^2)
	// SC: O(|V|)
	public boolean isBipartite() {
		boolean [] color = new boolean [matrix.length], visited = new boolean [matrix.length];
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		visited[0] = true;
		
		while (!q.isEmpty()) {
			int v = q.remove();
			
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[v][i] && !visited[i]) {
					visited[i] = true;
					color[i] = !color[v];
					q.add(i);
				}
			}
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] && color[i] == color[j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public int [] storePath() {
		if (path == null) return new int [] {}; 
		return path.stream().mapToInt(i -> i).toArray();
	}
	
	public void clear() {
		path.clear();
	}
}
