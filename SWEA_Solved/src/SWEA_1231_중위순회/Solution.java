package SWEA_1231_중위순회;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	
	static Map<Integer, Node> tree;
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		tree = new HashMap<>();
		Node newNode;
		int nodeKey;
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			tree.clear();
			
			int vertexNum = Integer.parseInt(in.readLine().trim());
			for (int i = 0; i < vertexNum; i++) {
				
				token = new StringTokenizer(in.readLine());
				
				nodeKey = Integer.parseInt(token.nextToken());
				
				newNode = new Node(nodeKey, token.nextToken());
				if(token.hasMoreTokens())
					newNode.leftChild = Integer.parseInt(token.nextToken());
					if(token.hasMoreTokens()) 
						newNode.rightChild = Integer.parseInt(token.nextToken());
					
				tree.put(nodeKey, newNode);
				
			}
			
			out.write("#" + testCase + " ");
//			System.out.print("#" + testCase + " ");
			inOrder(1);
			out.flush();
			System.out.println();
		}
	}

	public static void inOrder(int n) throws IOException {
		Node node = tree.get(n);
		if (node != null) {
			inOrder(node.leftChild);
//			System.out.print(node.data);
			out.write(node.data);
			inOrder(node.rightChild);
		}
	}
}

class Node {
	int key;
	String data;
	int leftChild;
	int rightChild;

	public Node(int nodeKey, String data) {
		this.key = nodeKey;
		this.data = data;
	}
}
