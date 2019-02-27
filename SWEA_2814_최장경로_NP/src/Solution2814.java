
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution2814 { // #2814. 최장 경로

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

			int[][] edges = new int[N + 1][N + 1];

			for (int i = 1; i <= M; i++) { // get input
				int x = sc.nextInt();
				int y = sc.nextInt();
				edges[x][y]++;
				edges[y][x]++;
			}
			
			int max = 1;
			
			for (int i = 1; i <= N; i++) {
				int tmp = search(i, max, edges);
				if (max < tmp) {
					max = tmp;
				}
			}
			
			System.out.println("#" + test + " " + pathLength);

		}
	}

	
	private static int search(int point, int max, int[][] edges) {
		for (int i = 1; i <= N; i++) {
			if(point == i) {
				continue;
			}
			if(edges[point][i] != 0) {
				
				edges[point][i]--;
				edges[i][point]--;
				
				int tmp = search(i, max + 1, edges);
				if (max < tmp) {
					max = tmp;
				} else {
					edges[point][i]++;
					edges[i][point]++;
				}
			}
		}
		return max;
	}

}
