import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static long[][] worm;
	static long min;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());

		StringTokenizer tokens;

		for (int testCase = 1; testCase <= T; testCase++) {
			min = Long.MAX_VALUE;
			N = Integer.parseInt(in.readLine().trim());
			worm = new long[N][2];
			for (int n = 0; n < N; n++) {
				tokens = new StringTokenizer(in.readLine());
				worm[n][0] = Long.parseLong(tokens.nextToken());
				worm[n][1] = Long.parseLong(tokens.nextToken());
			}
			
			combination(0, 0, new boolean[N]);

			System.out.println("#" + testCase + " " + min);
		}
	}

	static void combination(int idx, int cnt, boolean[] select) {
		if (cnt == N/2) {
			long teamAx = 0, teamAy = 0, teamBx = 0, teamBy = 0;
			int countA = 0;
			for (int i = 0; i < N; i++) {
				if (select[i]) {
					teamAx += worm[i][0];
					teamAy += worm[i][1];
					countA++;
				} else {
					teamBx += worm[i][0];
					teamBy += worm[i][1];
				}
			}
				long x = (teamAx - teamBx);
				long y = (teamAy - teamBy);
				min = Math.min(min, x*x + y*y);
				return;
		}

		for (int i = idx; i < N; i++) {
			select[i] = true;
			combination(i + 1, cnt + 1, select);
			select[i] = false;
		}
	}
}
