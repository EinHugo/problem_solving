package SWEA_2814_최장경로_NP;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution2814_못품 { // #2814. 최장 경로

	static int N, M, pathLength;

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("res/sample_input2814.txt"));
		// 입력 조절

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test = 1; test <= T; test++) {

			///////////////////////////////////////////
			///////////////////////////////////////////

			N = sc.nextInt(); // vertex
			M = sc.nextInt(); // edge
			pathLength = 1;

			boolean[][] edges = new boolean[N + 1][N + 1];
			int[] heuristic = new int[N + 1];

			for (int i = 1; i <= M; i++) { // get input
				int x = sc.nextInt();
				int y = sc.nextInt();
				edges[x][y] = true;
				edges[y][x] = true;
				heuristic[x]++;
				heuristic[y]++;
			}

			for (int i = 1; i <= N; i++) {
				edges[0][i] = true;
				edges[i][0] = true;
			}

//			for (int i = 0; i <= N; i++) {
//				for (int j = 0; j <= N; j++) {
//					System.out.print(edges[i][j] + " ");
//				}
//				System.out.println();
//			}

			int point = 0;
			while (true) {
				point = GoNext(point, edges, heuristic);
//				System.out.print(point + " ");
				if (point == -1)
					break;
			}
			System.out.println("#" + test + " " + pathLength);

		}
	}

	
	private static int GoNext(int point, boolean[][] edges, int[] heuristic) {
		int minValue = 100, tmp = 0, goodIdx = -1;
		boolean isLastStep = false;

		for (int i = 1; i <= N; i++) {
			if (edges[point][i]) {
				tmp = heuristic[i];
				if (1 < tmp && tmp < minValue) {
					goodIdx = i;
					minValue = tmp;
				} else if (tmp == 1) {
					for (int i2 = 1; i2 <= N; i2++) {
						if (edges[point][i]) {
							if (1 < heuristic[i2])
								return i;
						}
					}
					
					isLastStep = true;
					
				}
			}
		}
		if (goodIdx == -1 && isLastStep) {
			pathLength++;
			return -1;
		} else if (goodIdx == -1) {
			return -1;
		}

		pathLength++;
		heuristic[goodIdx] = 0;
		edges[point][goodIdx] = false;
		edges[goodIdx][point] = false;
		return goodIdx;
	}

}
