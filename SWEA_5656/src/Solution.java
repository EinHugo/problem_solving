import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	/**
	 * 1 ≤ N ≤ 4
	 * 2 ≤ W ≤ 12 
	 * 2 ≤ H ≤ 15
	 */

	// requirements
	static int N, W, H;

	// for input
	static StringTokenizer tokens;
	static String line;

	// for process
	static int[][][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int ni, nj, step = 0;

	// for output
	static int inputCnt;
	static int min;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());

		for (int tc = 1; tc <= 1; tc++) {
			inputCnt = 0;
			min = Integer.MAX_VALUE>>1;

			tokens = new StringTokenizer(in.readLine());

			N = Integer.parseInt(tokens.nextToken());
			W = Integer.parseInt(tokens.nextToken());
			H = Integer.parseInt(tokens.nextToken());
			map = new int[5][H][W]; // 0 for Input, 1 ~ 4 for N 

			for (int i = 0; i < H; i++) {
				line = in.readLine();
				for (int j = 0, idx = 0; j < W; j++, idx += 2) {
					map[0][i][j] = line.charAt(idx) - '0';
					if (map[0][i][j] != 0) {
						inputCnt++;
					}
				}
			}
			
			combi();
			
			System.out.println("#" + tc + " " + min);

		}
	}

	static void combi() {
		if (step < N) {
			for (int i = 0; i < W; i++) {
				step++;
				shoot(i);
				combi();
				step--;
			}
		}
	}

	static void shoot(int j) {
//		System.out.println(step + " : " + "shoot" + j);
		setNextStep();
		for (int i = 0; i < H; i++) {
			if (map[step][i][j] != 0) {
				bomb(i, j);
				break;
			}
		}
		print();
//		sortDown();
//		if(step == N) {
//			getMin();
//		}
	}

	static void bomb(int i, int j) {
		System.out.println(i + " , " + j);
		
		for (int d = 0; d < dir.length; d++) {
			for (int dist = 1; dist < map[step][i][j]; dist++) {
				ni = i + dir[d][0];
				nj = j + dir[d][1];
				if (ni < 0 || nj < 0 || ni >= H || nj >= W) {
					break;
				}
				if (map[step][ni][nj] != 0) {
					System.out.println("bomb : " + map[step][ni][nj] + " ");
					bomb(ni, nj);
				} else {
					System.out.println("else : " + map[step][ni][nj]);
				}
			}
		}
	}

	static void sortDown() {
//		int top;
//		for (int j = 0; j < W; j++) {
//			top = -1;
//			for (int i = 0; i < H; i++) {
//				if (top == -1 && map[step][i][j] != 0) {
//					top = i;
//				} else if (top != -1 && map[step][i][j] == 0) {
//					for (int k = i - 1; k >= top; k--) {
//						map[step][i][j] = map[step][k][j];
//					}
//					top++;
//				}
//			}
//		}
	}

	static void setNextStep() {
		map[step] = map[step - 1].clone();
//		if(step == N) {
//			print(step);
//		}
	}

	static void print() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[step][i][j] + " ");
			}
			System.out.println();
		}
	}
	static void print(int n) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[n][i][j] + " ");
			}
			System.out.println();
		}
	}

	static void getMin() {
		int sum = 0;
		for (int j = 0; j < W; j++) {
			for (int i = 0; i < H; i++) {
				if (map[N][i][j] != 0) {
					sum += (H-1-i);
					break;
				}
			}
		}
		min = Math.max(min, sum);
	}

}
