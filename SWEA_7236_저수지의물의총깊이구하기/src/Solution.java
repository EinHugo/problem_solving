import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] map;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, {-1,-1}, {-1,1} ,{1,-1}, {1,1} };
	static int ni, nj;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());

		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(in.readLine().trim());
			map = new int[N][N];
			String line;
			char ch;
			for (int i = 0; i < N; i++) {
				line = in.readLine();
				for (int j = 0, index = 0; j < N; j++, index += 2) {
					if (line.charAt(index) == 'W') {
						for (int d = 0; d < dir.length; d++) {
							ni = i + dir[d][0];
							nj = j + dir[d][1];
							if (ni >= 0 && nj >= 0 && ni < N && nj < N) {
								map[ni][nj]++;
							}
						}
					}
				}
			}
			
			
			
			int max = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j] + " ");
					if(max < map[i][j]) {
						max = map[i][j];
					}
				}
//				System.out.println();
			}

			System.out.println("#" + testCase + " " + (max));
		}
	}
}
