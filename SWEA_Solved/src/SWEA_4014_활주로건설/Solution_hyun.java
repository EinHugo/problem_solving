package SWEA_4014_활주로건설;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_hyun {

	static int N, X;
	static int[][] map;
	static int Answer;

	public static void checkCol() {
		boolean isOK; // 우측 경사로 가능 확인 변수
		int markIdx;

		for (int i = 0; i < N; i++) {
			markIdx = -1;
			for (int j = 0; j < N; j++) {

				if (j == N - 1) {
					Answer++;
					break;
				}

				isOK = true;

				if (map[i][j] == map[i][j + 1]) { // 같은 경우
					continue;
				}

				if (map[i][j] > map[i][j + 1] + 1 || map[i][j] < map[i][j + 1] - 1) {
					break;
				}

				if (map[i][j] == map[i][j + 1] + 1) { // 하향 경사로 가능
					if (j + X >= N) {
						break;
					} else {
						for (int k = 1; k < X; k++) {
							if (map[i][j + 1] != map[i][j + 1 + k]) {
								isOK = false;
								break;
							}
						}

						if (isOK) { // 경사로 설치 가능
							markIdx = j + X;
							if (j + X == N - 1) {
								Answer++;
								break;
							}

							continue;
						} else {
							break;
						}
					}
				}

				if (map[i][j] == map[i][j + 1] - 1) { // 상향 경사로 가능
					if (j - (X - 1) < 0) {
						break;
					} else {
						if (j - X + 1 <= markIdx) {
							break;
						}

						for (int k = 1; k < X; k++) {
							if (map[i][j] != map[i][j - k]) {
								isOK = false;
								break;
							}
						}

						if (isOK) { // 경사로 설치 가능
							continue;
						} else {
							break;
						}
					}
				}

			}

			//			System.out.println("Col Index : " + i + " , Answer : " + Answer);
		}
	}

	public static void checkRow() {
		boolean isOK; // 하향 경사로 가능 확인 변수
		int markIdx;

		for (int i = 0; i < N; i++) {
			markIdx = -1;
			for (int j = 0; j < N; j++) {
				if (j == N - 1) {
					Answer++;
					break;
				}

				isOK = true;

				if (map[j][i] == map[j + 1][i]) { // 같은 경우
					continue;
				}

				if (map[j][i] > map[j + 1][i] + 1 || map[j][i] < map[j + 1][i] - 1) {
					break;
				}

				if (map[j][i] == map[j + 1][i] + 1) { // 하향 경사로 가능
					if (j + X >= N) {
						break;
					} else {
						for (int k = 1; k < X; k++) {
							if (map[j + 1][i] != map[j + 1 + k][i]) {
								isOK = false;
								break;
							}
						}

						if (isOK) { // 경사로 설치 가능
							markIdx = j + X;
							if (j + X == N - 1) {
								Answer++;
								break;
							}
							continue;
						} else {
							break;
						}
					}
				} else if (map[j][i] == map[j + 1][i] - 1) { // 상향 경사로 가능
					if (j - (X - 1) < 0) {
						break;
					} else {
						if (j - X + 1 <= markIdx) {
							break;
						}

						for (int k = 1; k < X; k++) {
							if (map[j][i] != map[j - k][i]) {
								isOK = false;
								break;
							}
						}

						if (isOK) { // 경사로 설치 가능
							continue;
						} else {
							break;
						}
					}
				}

			}

			//			System.out.println("Row Index : " + i + " , Answer : " + Answer);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine().trim());

		for (int testcase = 1; testcase <= TC; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// Init
			Answer = 0;

			// Sol
			// 가로 전체 확인 1회, 세로 전체 확인 1회
			checkCol();
			checkRow();

			System.out.println("#" + testcase + " " + Answer);
		}

	}
}