package SWEA_1238_Contact;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	static final int MAX = 101;
	
	static int S, N;
	static boolean[][] graph = new boolean[MAX][MAX];
	static LinkedList<Integer> callList = new LinkedList<>();
	static HashSet<Integer> alreadyCalled = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		StringTokenizer tokens;
		
		for (int tc = 1; tc <= T; tc++) {
			callList.clear();
			alreadyCalled.clear();
			
			tokens = new StringTokenizer(in.readLine().trim());
			N = Integer.parseInt(tokens.nextToken());		// length of input data ( 1 ~ 100 )
			S = Integer.parseInt(tokens.nextToken());		// start point
			for (int i = 0; i < MAX; i++) {
				Arrays.fill(graph[i], false);
			}
				
			
			tokens = new StringTokenizer(in.readLine().trim());
			for (int i = 0; i < N/2; i++) {
				graph[Integer.parseInt(tokens.nextToken())][Integer.parseInt(tokens.nextToken())] = true;
			}
			
			callList.offer(S);
			alreadyCalled.add(S);
			
			int max = 0;
			do {
				max = bfs();
			} while (max <= 0);
			

			System.out.println("#" + tc + " " + max);
		}
	}
	
	
	static int bfs() {
		
		int listLeng = callList.size();
		int curCaller;
		int localMax = -1;
		
		for (int i = 0; i < listLeng; i++) {
			curCaller = callList.poll();
			localMax = Math.max(localMax, curCaller);
			for (int callee = 1; callee < MAX; callee++) {
				if(graph[curCaller][callee] && !alreadyCalled.contains(callee)) {
					callList.offer(callee);
					alreadyCalled.add(callee);
				}
			}
		}
		
		if(callList.isEmpty()) {
			return localMax;
		}
		
		return -1;
		
	}
}
