package BaekJoon_1149_RGB거리;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static final int R = 0, G = 1, B = 2;
	
	static int N;
	static int[][] cost;
	static int[] total;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		N = Integer.parseInt(in.readLine().trim());
		cost = new int[N+1][3];
		total = new int[3];
		
		
		for (int i = 1; i <= N; i++) {
			tokens = new StringTokenizer(in.readLine().trim());
			cost[i][R] = Integer.parseInt(tokens.nextToken());
			cost[i][G] = Integer.parseInt(tokens.nextToken());
			cost[i][B] = Integer.parseInt(tokens.nextToken());
		}
		
		total[R] = cost[1][R];
		total[G] = cost[1][G];
		total[B] = cost[1][B];
		
		int bR,bG,bB;
		for (int i = 2; i <= N; i++) {
			bR = total[R];
			bG = total[G];
			bB = total[B];
			total[R] = Math.min(bG + cost[i][R], bB + cost[i][R]);
			total[G] = Math.min(bR + cost[i][G], bB + cost[i][G]);
			total[B] = Math.min(bG + cost[i][B], bR + cost[i][B]);
		}
		
		
		
		System.out.println(Math.min(Math.min(total[R], total[G]), total[B]));
	}
	
	
	
	static int dfs(int idx, int before, int sum) {
		
		if(idx == N) {
			return sum;
		}
		
		switch (before) {
		case R:
			return Math.min(dfs(idx+1, G, sum + cost[idx][R]), dfs(idx+1, B, sum + cost[idx][R]));
		case G:
			return Math.min(dfs(idx+1, R, sum + cost[idx][G]), dfs(idx+1, B, sum + cost[idx][G]));
		case B:
			return Math.min(dfs(idx+1, G, sum + cost[idx][B]), dfs(idx+1, R, sum + cost[idx][B]));
		default:
			return Math.min(dfs(idx+1, R, sum + cost[idx][R]), 
					Math.min(dfs(idx+1, G, sum + cost[idx][G]), 
							dfs(idx+1, B, sum + cost[idx][B])));
		}
	}
	
}
