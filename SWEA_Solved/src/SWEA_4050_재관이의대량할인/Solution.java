package SWEA_4050_재관이의대량할인;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int[] cost;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;
		
		int T = Integer.parseInt(in.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine().trim());
			cost = new int[N];
			tokens = new StringTokenizer(in.readLine().trim());
			for (int i = 0; i < N; i++) {
				cost[i] = Integer.parseInt(tokens.nextToken());
			}
			
			Arrays.sort(cost);
			int sum = 0;
			for (int i = N-1; i >= 0; i--) {
				if(i >= 2) {
					sum += cost[i--];
					sum += cost[i--];
				} else {
					sum += cost[i];
				}
			}
			
			
			System.out.println("#" + tc + " " + sum);
		}
		
	}
}
