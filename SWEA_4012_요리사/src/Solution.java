import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] synergy;
	static boolean[] selected;
	
	static int[] teamA, teamB;

	static int minDiff;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());
		StringTokenizer tokens;

		for (int tc = 1; tc <= T; tc++) {
			minDiff = Integer.MAX_VALUE;
			
			N = Integer.parseInt(in.readLine().trim());
			synergy = new int[N][N];
			
			// for combination
			selected = new boolean[N];
			teamA = new int[N];
			teamB = new int[N];
			
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(in.readLine().trim());
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}

			// for prerequisite data - sum of synergy in (smaller i, bigger j)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i; j++) {
					synergy[i][j] += synergy[j][i];
				}
			}

			combination(0,0);

			System.out.println("#" + tc + " " + minDiff);
		}

	}
	
	private static void combination(int cnt, int start) {
		// on the base condition
		if(cnt == N/2) {
			int idxA = 0, idxB = 0;
			int sumA = 0, sumB = 0;
			
			// check what's selected
			for (int i = 0; i <N; i++) {
				if(selected[i]) {
					teamA[idxA++] = i;
				} else {
					teamB[idxB++] = i;
				}
			}
			
			// get each sum of synergy
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < i; j++) {
					sumA += synergy[teamA[i]][teamA[j]];
					sumB += synergy[teamB[i]][teamB[j]];
				}
			}
			
			// calc the minimum diff value
			minDiff = Math.min(minDiff, Math.abs(sumA-sumB));
			return;
		}
		
		// just combine
		for (int i = start; i < N; i++) {
			selected[i]= true;
			combination(cnt+1, i+1);
			selected[i]= false;
		}
	}
}
