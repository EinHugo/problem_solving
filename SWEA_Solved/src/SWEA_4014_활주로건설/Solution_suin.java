package SWEA_4014_활주로건설;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_suin {
	static int N, X, answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/sample_input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int i_T = 1; i_T <= T; i_T++) {
			answer = 0;
			String[] NX = in.readLine().split(" ");
			N = Integer.parseInt(NX[0]);
			X = Integer.parseInt(NX[1]);

			int[][] matrix = new int[N][N];

			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				String[] temp = in.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					int x = Integer.parseInt(temp[j]);
					matrix[i][j] = x;
					if (j == N - 1) { // 가로
						for (int z = 0; z < N; z++) {
							arr[z] = matrix[i][z];
						}
						check(arr);
					}

					if (i == N - 1) { // 세로
						for (int z = 0; z < N; z++) {
							arr[z] = matrix[z][j];
						}
						check(arr);
					}
				}

			}
			System.out.println("#" + i_T + " " + answer);
		}
	}

	private static void check(int[] arr) {
		int connect = 1;
		for (int i = 0; i < arr.length - 1; i++) {
			int cur = arr[i];
			int nxt = arr[i + 1];

			if (cur == nxt)
				connect++;
			else if (cur + 1 == nxt) {
				if (connect >= X) {
					connect = 1;
				} else {
					return;
				}
			} else if (cur == nxt + 1) {
				if( i + X >= N) {
					return;
				}
				for (int j = 2; j <= X; j++) {
					if (arr[i + j] != nxt) {
						return;
					}
				}
				
				i += X-1;
				connect = 0;

			} else
				return;
		}
		answer++;
	}
}