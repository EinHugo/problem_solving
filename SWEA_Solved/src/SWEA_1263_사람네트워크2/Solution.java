package SWEA_1263_사람네트워크2;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int INF = Integer.MAX_VALUE >> 1;
	static int N;
	static int[][] path;
	static int[][] cost;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		StringTokenizer tokens;
		for (int testCase = 1; testCase <= T; testCase++) {
			tokens = new StringTokenizer(in.readLine());
			N = Integer.parseInt(tokens.nextToken());
			path = new int[N+1][N+1];
			cost = new int[N+1][N+1];
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					path[i][j] = Integer.parseInt(tokens.nextToken());
					cost[i][j] = path[i][j]; 
					if(path[i][j] == 0 && i != j ) {
						cost[i][j] = INF;
					}
				}
			}
			
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						cost[i][j] = Math.min(cost[i][k] + cost[k][j], cost[i][j]);
					}
				}
			}
			
			int globMax = INF, localMax = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					localMax += cost[i][j];
				}
				globMax = Math.min(globMax, localMax);
				localMax = 0;
			}
			
			System.out.println("#" + testCase + " " + globMax);
		}
		
		
	}
}


