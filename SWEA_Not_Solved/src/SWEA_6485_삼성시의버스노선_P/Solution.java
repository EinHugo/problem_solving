package SWEA_6485_삼성시의버스노선_P;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int N; 
	static int[] path;
	static int a,b;
	static StringTokenizer tokens= null;
	static StringBuilder sb  = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/s_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(in.readLine());
			path = new int[5001];
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(in.readLine());
				a = Integer.parseInt(tokens.nextToken());
				b = Integer.parseInt(tokens.nextToken());
				for (int j = a ; j <= b; j++) {
					path[j]++;
				}
			}
			
			N = Integer.parseInt(in.readLine());	// this means P
			sb = new StringBuilder(3 * N);
			sb.append("#").append(testCase);
			for (int i = 0; i < N; i++) {
				sb.append(" ").append(path[Integer.parseInt(in.readLine().trim())]);
			}
			System.out.println(sb);
			
			Arrays.fill(path, 0);
		}
	}
}
