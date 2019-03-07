import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_improving {
	static int N;
	static boolean[] score;
	static int max, nextInput, count;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());
		score = new boolean[100 * 100 + 1];
		StringTokenizer tokens = null;
		for (int testCase = 1; testCase <= T; testCase++) {
			Arrays.fill(score, false);
			N = Integer.parseInt(in.readLine().trim());
			tokens = new StringTokenizer(in.readLine());
			
			score[0] = true;
			max = 0;
			count = 1;
			
			for (int i = 0; i < N; i++) {
				nextInput = Integer.parseInt(tokens.nextToken());
				for (int j = max; j >= 0; j--) {
					if(score[j]) {
						if( !score[j + nextInput] ) {
							count++;
							score[j + nextInput] = true;
							if( max < j + nextInput) {
								max = j + nextInput;
							}
						}
					}
				}
			}
			
			
			
			System.out.println("#" + testCase + " " + count);
		}
	}

}
