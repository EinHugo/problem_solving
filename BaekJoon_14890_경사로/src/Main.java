import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// requirements
	static int N, X;
	static int[][] map;

	// for input
	static StringTokenizer tokens;
	static String line;

	// for process
	static int height;
	static int answer;
	static final boolean HORIZONTAL = true, VERTICAL = false, BACKWARD = true, FORWARD = false;
	static boolean[][] alreadyConstructed;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		tokens = new StringTokenizer(in.readLine());
		N = Integer.parseInt(tokens.nextToken());
		X = Integer.parseInt(tokens.nextToken());

		map = new int[N][N];
		alreadyConstructed = new boolean[N][N];
		answer = 2 * N;
		//			answer = N;

		for (int i = 0; i < N; i++) {
			line = in.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j * 2) - '0';
			}
		}

		for (int i = 0; i < N; i++) { // check the row direction
			height = map[i][0];
			for (int j = 1; j < N; j++) {
				if (height == map[i][j]) {
					continue;
				}

				if (Math.abs(height - map[i][j]) != 1) {
					answer--;
					break;
				}

				if (height < map[i][j]) {
					if (j - X < 0) { // can't construct
						answer--;
						break;
					} else if (!canConstruct(i, j, HORIZONTAL, BACKWARD)) {
						answer--;
						break;
					}
				} else {
					if (j + X > N) { // can't construct
						answer--;
						break;
					} else if (!canConstruct(i, j, HORIZONTAL, FORWARD)) {
						answer--;
						break;
					}
				}
				height = map[i][j];

			} // end of for j
		} // end of for i

		alreadyConstructed = new boolean[N][N];

		for (int j = 0; j < N; j++) {
			height = map[0][j];
			for (int i = 1; i < N; i++) { // check the row direction
				if (height == map[i][j]) {
					continue;
				}

				if (Math.abs(height - map[i][j]) != 1) {
					answer--;
					break;
				}

				if (height < map[i][j]) {
					if (i - X < 0) { // can't construct
						answer--;
						break;
					} else if (!canConstruct(i, j, VERTICAL, BACKWARD)) {
						answer--;
						break;
					}
				} else {
					if (i + X > N) { // can't construct
						answer--;
						break;
					} else if (!canConstruct(i, j, VERTICAL, FORWARD)) {
						answer--;
						break;
					}
				}
				height = map[i][j];
			} // end of for j
		} // end of for i

		System.out.println(answer);
	} // end of main

	static boolean canConstruct(int i, int j, boolean isHorizontal, boolean isBackward) {
		if (isBackward) {
			if (isHorizontal) {
				for (int check = j - X; check < j; check++) {
					if (map[i][check] != height || alreadyConstructed[i][check]) {
						return false;
					}
					alreadyConstructed[i][check] = true;
				}
			} else {
				for (int check = i - X; check < i; check++) {
					if (map[check][j] != height || alreadyConstructed[check][j]) {
						return false;
					}
					alreadyConstructed[check][j] = true;
				}
			}
		} else {
			if (isHorizontal) {
				for (int check = j; check < j + X; check++) {
					if (map[i][check] != height - 1 || alreadyConstructed[i][check]) {
						return false;
					}
					alreadyConstructed[i][check] = true;
				}
			} else {
				for (int check = i; check < i + X; check++) {
					if (map[check][j] != height - 1 || alreadyConstructed[check][j]) {
						return false;
					}
					alreadyConstructed[check][j] = true;
				}
			}
		}
		return true;
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
