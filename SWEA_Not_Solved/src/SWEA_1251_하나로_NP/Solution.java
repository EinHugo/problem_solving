package SWEA_1251_하나로_NP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class Node {
	static int codeCount = 0;
	int hashcode;

	public double x, y;

	public Node(double x) {
		this.x = x;
		hashcode = codeCount++;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void print() {
		System.out.print("(" + x + ", " + y +")");
	}

	@Override
	public int hashCode() {
		return hashcode;
	}
}

class Edge implements Comparable<Edge> {
	double distance;
	Node i1, i2;

	public Edge(double distance, Node i1, Node i2) {
		this.distance = distance;
		this.i1 = i1;
		this.i2 = i2;
	}

	@Override
	public int compareTo(Edge o) {
		
	    if(this.distance > o.distance ){
	        return 1;
	    }else if(this.distance < o.distance){
	        return -1;
	    }else if(this.distance == o.distance ){
	        return 0;
	    }
		// TODO Auto-generated method stub
		return (this.distance - o.distance > 0) ? 1 : -1;
	}
	
	public void print() {
		i1.print();
		System.out.print(" -> ");
		i2.print();
		System.out.println(" " + distance);
	}

}

public class Solution {

	static int N;
	static double[][] map;
	static double envCost, totalCost;
	static List<Node> islands = null;
	static Set<Node> alreadyConnected = null;
	static List<Edge> tunnels = null;
	static StringTokenizer tokens = null;
	static Node tmp1, tmp2;
	static Edge tunnel;
	static boolean[][] isConnected;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine().trim());
		islands = new ArrayList<>();
		tunnels = new ArrayList<>();
		alreadyConnected = new HashSet<>();

		for (int test = 1; test <= 3; test++) {
			N = Integer.parseInt(in.readLine());
			isConnected = new boolean[N][N];
			
			islands.clear();
			tunnels.clear();
			alreadyConnected.clear();
			totalCost = 0;
			Node.codeCount = 0;
			
			tokens = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				islands.add(new Node(Double.parseDouble(tokens.nextToken())));
			}
			tokens = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				islands.get(i).y = (Double.parseDouble(tokens.nextToken()));
			}
			envCost = Double.parseDouble(in.readLine().trim());

			for (int i = 0; i < N; i++) {
				tmp1 = islands.get(i);
				for (int j = i + 1; j < N; j++) {
					tmp2 = islands.get(j);
					tunnels.add(new Edge(Math.pow(tmp1.x - tmp2.x, 2) + Math.pow(tmp1.y - tmp2.y, 2), tmp1, tmp2));
				}
			}

			Collections.sort(tunnels);

			int size = tunnels.size();
			for (int i = 0; i < N-1; i++) {
				for (int j = i; j < size; j++) {
					tunnel = tunnels.get(j);
//					System.out.println(tunnel.i1.hashcode + " , " + tunnel.i2.hashcode);
					if (isConnected[tunnel.i1.hashcode][tunnel.i2.hashcode]) {
						continue;
					} else {
						alreadyConnected.add(tunnel.i1);
						alreadyConnected.add(tunnel.i2);
						totalCost += tunnel.distance;
						isConnected[tunnel.i1.hashcode][tunnel.i2.hashcode] = true;
						isConnected[tunnel.i2.hashcode][tunnel.i1.hashcode] = true;
						break;
					}
				}
			}

			
			System.out.println("#" + test + " " + Math.round(envCost*totalCost));

		}

	}
}
