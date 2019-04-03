import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] dir = { { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

	static int N; // size of map (4 ≤ N ≤ 20)
	static int[][] map;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;

		int T = Integer.parseInt(in.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine().trim());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(in.readLine().trim());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			System.out.println("#" + tc + " ");
		}

	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
