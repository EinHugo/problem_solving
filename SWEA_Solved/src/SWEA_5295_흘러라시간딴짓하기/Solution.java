package SWEA_5295_흘러라시간딴짓하기;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] lines;
	static int N;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;
		
		
		int T = Integer.parseInt(in.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine().trim());
			lines = new int[3][N];
			
			for (int i = 0; i < 3; i++) {
				tokens = new StringTokenizer(in.readLine().trim());
				for (int j = 0; j < N; j++) {
					lines[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			
			System.out.println("#" + tc + " ");
		}
		
		
	}
	
	static void print() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(lines[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
