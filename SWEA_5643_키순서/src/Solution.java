import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N; 		// # of student 	(2 ≤ N ≤ 500)
	static int M; 		// # of comparison	(0 ≤ M ≤ N*(N-1)/2)

	static int a,b;		// relation : a -> b
	
	static boolean[][] map;
	static boolean[][] mapReverse;
	static int[] count;
	static int answer;
	static int[] visit;

	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		int T = Integer.parseInt(in.readLine().trim());		// 1 ~ 15
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine().trim());
			M = Integer.parseInt(in.readLine().trim());
			map = new boolean[N+1][N+1];
			mapReverse = new boolean[N+1][N+1];
			count = new int[N+1];
			visit = new int[N+1];
			answer = 0;
			
			for (int m = 0; m < M; m++) {
				tokens = new StringTokenizer(in.readLine().trim());
				a = Integer.parseInt(tokens.nextToken());
				b = Integer.parseInt(tokens.nextToken());
				
				map[a][b] = true;
				mapReverse[b][a] = true;
			}
			
			boolean[] c = new boolean[N+1];
			for (int i = 1; i <= N; i++) {
				if(c[i]) {
					continue;
				}
				check(i);
				if(count[i] != N-1) {
					for (int j = 1; j <= N; j++) {
						if(visit[j] != i) {
							c[j] = true;
						}
					}
				}
			}
			for (int i = 1; i <= N; i++) {
				if(count[i] == N-1) {
					answer++;
				}
			}

			System.out.println("#" + tc + " " + answer);
		}
		
	}
	
	static void check(int from) {
		goNCheck(from, from);
		backNCheck(from, from);
	}
	
	static void goNCheck(int from, int origin){
		for (int idx = 1; idx <= N; idx++) {
			if(map[from][idx]) {
				if(visit[idx] != origin) {
					count[origin]++;
					visit[idx] = origin;
					goNCheck(idx, origin);
				}
			}
		}
	}
	static void backNCheck(int from, int origin){
		for (int idx = 1; idx <= N; idx++) {
			if(mapReverse[from][idx]) {
				if(visit[idx] != origin) {
					count[origin]++;
					visit[idx] = origin;
					backNCheck(idx, origin);
				}
			}
		}
	}
	
}
