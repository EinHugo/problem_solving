package SWEA_3124_최소스패닝트리;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	
	public static class Node implements Comparable<Node>{
		int A,B,C; // 시작 정점, 끝 정점, 가중치
		public Node(int a, int b, int c) {
			A=a;
			B=b;
			C=c;
		}
		public int compareTo(Node o) {
			return C - o.C > 0 ? 1: -1;
		}
	}
	
	public static void makeSet(int x) {
		p[x] = x;
	}
	
	public static int findSet(int x) {
		if(p[x] == x) {
			return x;
		}
		p[x] = findSet(p[x]);
		return p[x];
	}
	
	public static void union(Node node) {
		int r1 = findSet(node.A);
		int r2 = findSet(node.B);
		if(r1 == r2) return;
		p[r1] = r2;
		result += node.C;
	}
	
	static int p[];
	static long result;			// 가중치의 합
	static int V, E;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;
		TreeSet<Node> ts;
		
		int T = Integer.parseInt(in.readLine().trim());
		for (int test = 1; test <= T; test++) {
			tokens = new StringTokenizer(in.readLine().trim(), " ");
			V = Integer.parseInt(tokens.nextToken());
			E = Integer.parseInt(tokens.nextToken());
			
			ts = new TreeSet<>();
			p= new int[V+1];
			for (int i = 0; i <= V; i++) {
				makeSet(i);
			}
			int A,B,C;
			for (int i = 0; i < E; i++) {
				tokens = new StringTokenizer(in.readLine());
				A = Integer.parseInt(tokens.nextToken());
				B = Integer.parseInt(tokens.nextToken());
				C = Integer.parseInt(tokens.nextToken());
				// Comparable을 이용해서 저장할 시 정렬한다.
				ts.add(new Node(A, B, C));
			}
			result = 0;
			for (Node node : ts) {
				union(node);
			}
			
			System.out.println("#" + test + " " + result);
		}
		
	}
}
