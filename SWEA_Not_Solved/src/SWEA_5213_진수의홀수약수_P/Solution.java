package SWEA_5213_진수의홀수약수_P;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int MAX = 1000000;
	static int L, R;
	static long gxResult;
	static long[] fx = new long[MAX + 1];
	static long[] gx = new long[MAX + 1];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());
		StringTokenizer tokens = null;
		
		setFunctions();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			tokens = new StringTokenizer(in.readLine().trim());
			L = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken());
			gxResult = gx[R] - gx[L-1];
			System.out.println("#" + testCase + " " + gxResult);
		}
	}
	
	static void setFunctions() {
		for (int i = 1; i <= MAX; i+= 2) {
			for (int j = 1; i*j < MAX+1; j++) {
				fx[i*j] += i;
			}
		}
		
		for (int i = 1; i <= MAX; i++) {
			gx[i] = gx[i-1] + fx[i];
		}
	}


}
