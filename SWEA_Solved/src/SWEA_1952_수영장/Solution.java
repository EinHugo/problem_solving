package SWEA_1952_수영장;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static final int INF = Integer.MAX_VALUE >> 1;
	static final int DAY = 0, MONTH = 1, MONTH_3 = 2, YEAR = 3;
	static final int BEST = 3;

	static int[] fee = new int[4]; // day, month, 3-month, year
	static int[] plan = new int[13];
	static int[] payment;
	static int[][] pay;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;

		int T = Integer.parseInt(in.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			payment = new int[13];
			pay = new int[13][4];		// 1 ~ 3 : day ~ year / 4 : best
			
			tokens = new StringTokenizer(in.readLine().trim());
			for (int i = 0; i < 4; i++) {
				fee[i] = Integer.parseInt(tokens.nextToken());
			}
			tokens = new StringTokenizer(in.readLine().trim());
			for (int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(tokens.nextToken());
			}
			
			for (int m = 1; m <= 12; m++) {
				pay[m][BEST] = INF;
				pay[m][DAY] = plan[m] * fee[DAY] + pay[m-1][BEST];
				pay[m][MONTH] = fee[MONTH] + pay[m-1][BEST];
				pay[m][BEST] = Math.min(pay[m][DAY], pay[m][MONTH]);

				if(m >= 3) {
					pay[m][MONTH_3] = pay[m-3][BEST] + fee[MONTH_3];
					pay[m][BEST] = Math.min(pay[m][BEST], pay[m][MONTH_3]);
					if(m == 12) {
						pay[m][BEST] = Math.min(fee[YEAR], 
								Math.min(pay[m][BEST], 
										Math.min(pay[10][BEST] + fee[MONTH_3], 
												pay[11][BEST] + fee[MONTH_3])));
					}
				}
			}
			
			System.out.println("#" + tc + " " + pay[12][BEST]);
			
		}
	}
	
}
