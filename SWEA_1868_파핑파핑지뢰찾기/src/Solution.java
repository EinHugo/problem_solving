
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
	static int N;
	static char[][] map;
	static boolean[][] isVisited;
	static int ni, nj;
	static int count;

	static int ZERO = '.';
	static int MINE = '*';

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			count = 0;

			N = Integer.parseInt(in.readLine());
			map = new char[N][];
			isVisited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				map[i] = in.readLine().toCharArray();
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == MINE) {
						isVisited[i][j] = true;
						for (int k = 0; k < 8; k++) {
							ni = i + dir[k][0];
							nj = j + dir[k][1];
							if (ni >= 0 && nj >= 0 && ni < N && nj < N && map[ni][nj] != MINE) {
								map[ni][nj]++;
							}
						}
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == ZERO && !isVisited[i][j]) {
						isVisited[i][j] = true;
						findZero(i, j);
						count++;

					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!isVisited[i][j]) {
						count++;
					}
				}
			}
			System.out.println("#" + test_case + " " + count);

		} // end-of-test case
	}

	static void findZero(int i, int j) {
		int newI, newJ;

		for (int k = 0; k < 8; k++) {
			newI = i + dir[k][0];
			newJ = j + dir[k][1];
			if (newI >= 0 && newJ >= 0 && newI < N && newJ < N && !isVisited[newI][newJ]) {
				isVisited[newI][newJ] = true;
				if (map[newI][newJ] == ZERO) {
					findZero(newI, newJ);
				}
			}
		}

	}
}