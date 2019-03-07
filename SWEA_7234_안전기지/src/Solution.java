import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, B; //	N : 5~50, B : 3~30
	static int[][] map;
	static int y, x, ny, nx;
	static final int[][] dir = { { 1, 0 }, { 2, 0 }, { -1, 0 }, { -2, 0 }, { 0, 1 }, { 0, 2 }, { 0, -1 }, { 0, -2 } };
	static final int dirLeng = 8;
	
	static int max;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sampleinput.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;

		int T = Integer.parseInt(in.readLine().trim());

		for (int testCase = 1; testCase <= T; testCase++) {
			max = 0;
			tokens = new StringTokenizer(in.readLine());

			N = Integer.parseInt(tokens.nextToken());
			B = Integer.parseInt(tokens.nextToken());

			map = new int[N + 1][N + 1];
			for (int line = 0; line < B; line++) {
				tokens = new StringTokenizer(in.readLine());

				y = Integer.parseInt(tokens.nextToken());
				x = Integer.parseInt(tokens.nextToken());
				for (int i = 0; i < dirLeng; i++) {
					ny = y + dir[i][0];
					nx = x + dir[i][1];
					if(ny >= 1 && ny <= N && 
							nx >= 1 && nx <= N) {
						map[ny][nx]++;
						if(max < map[ny][nx]) {
							max++;
						}
					}
				}

			}

			System.out.println("#" + testCase + " " + max);
		}

	}
}
