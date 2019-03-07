import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	final static int colorNum = 4;

	static int N;
	static boolean[][] map;
	static int[] color_ori, color_cur;
	static int contryNum;
	static int min_conflict;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sampleinput.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());

		StringTokenizer tokens;
		String line;

		for (int testCase = 1; testCase <= T; testCase++) {
			min_conflict = Integer.MAX_VALUE;

			N = Integer.parseInt(in.readLine().trim()); // N : 3 ~ 8
			tokens = new StringTokenizer(in.readLine());
			map = new boolean[N][N];
			color_ori = new int[N]; // original color
			color_cur = new int[N]; // new color
			contryNum = color_ori.length;

			for (int i = 0; i < N; i++) 
				color_ori[i] = Integer.parseInt(tokens.nextToken());
			
			for (int i = 0; i < N; i++) {
				line = in.readLine();
				for (int j = 0, idx = 0; j < N; j++, idx += 2) {
					if (line.charAt(idx) == '1')
						map[i][j] = true;
				}
			}

			setColor(0);

			System.out.println("#" + testCase + " " + min_conflict);
		} // end of test

	} // end of main

	static void setColor(int i) {
		if (i == N) { 		// base-condition : if all-colored
			int cnt = 0;
			for (int j = 0; j < contryNum; j++) {
				if (color_cur[j] != color_ori[j])
					cnt++;
			}
			if (cnt < min_conflict)
				min_conflict = cnt;
			return;
		}

		boolean isConflict;

		for (int color = 1; color <= colorNum; color++) { // pick color one by one
			isConflict = false;
			color_cur[i] = color;
			for (int before_i = 0; before_i < i; before_i++) {
				if (map[i][before_i] && color_cur[i] == color_cur[before_i]) { // is neighbor with same color?
					isConflict = true; // if not, let's pick other color
					break;
				}
			}
			if (!isConflict) {
				setColor(i + 1); // if consistent, take next one
			}
		}
	}
}
