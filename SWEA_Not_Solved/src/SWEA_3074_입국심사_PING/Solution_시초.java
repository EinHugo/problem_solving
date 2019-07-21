package SWEA_3074_입국심사_PING;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_시초 {

	static int N, M;
	static long[] tk, takes;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());
		StringTokenizer tokens;
		for (int tc = 1; tc <= T; tc++) {
			tokens = new StringTokenizer(in.readLine().trim());
			N = Integer.parseInt(tokens.nextToken()); // (1 ≤ N ≤ 100,000)
			M = Integer.parseInt(tokens.nextToken()); // (1 ≤ M ≤ 1,000,000,000)
			tk = new long[(int) N]; // (1 ≤ tk ≤ 1,000,000,000)
			takes = new long[(int) N]; // (1 ≤ tk ≤ 1,000,000,000)

			for (int idx = 0; idx < N; idx++) {
				tk[idx] = Long.parseLong(in.readLine().trim());
			}
			Arrays.sort(tk);

			int person = 0;

			takes[0] = M * tk[0];
//			print();
			long answer = takes[0];
			int count = 1;
			for (int idx = 1; true; idx++) {
				if(idx == N) {
					idx = 1;
					if(count == 1) {
						break;
					}
					count = 1;
				}
				if(takes[0]-tk[0] > takes[idx] + tk[idx]) {
					takes[idx] += tk[idx];
					takes[0] -= tk[0];
					answer = Math.min(answer, takes[0]);
					answer = Math.max(answer, takes[idx]);
					count++;
				} else {
					idx = N-1;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	static void print() {
		for (int i = 0; i < N; i++) {
			System.out.print(takes[i] + " ");
		}
		System.out.println();
//		for (int i = 0; i < N; i++) {
//			System.out.print(tk[i] + " ");
//		}
	}
}
