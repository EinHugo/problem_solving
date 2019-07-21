package BaekJoon_15686_치킨배달_PING;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] diry = {1, -1, 0, 0};
	static int[] dirx = {0, 0, -1, 1};
	static int[][] map;
	static int[][] isVisited;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input1.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens = new StringTokenizer(in.readLine());
		N = Integer.parseInt(tokens.nextToken());	// 2~50
		M = Integer.parseInt(tokens.nextToken());	// 1~13
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
	}
}
