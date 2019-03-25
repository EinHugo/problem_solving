import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

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
			
			long max = 0;
			for (int idx = 0; idx < N; idx++) {
				tk[idx] = Long.parseLong(in.readLine().trim());
				if(max < tk[idx]) {
					max = tk[idx];
				}
			}
			max *= M;
			

			System.out.println("#" + tc + " " + binarySearch(0, max));
		}
	}

	static long binarySearch(long start, long end) {
//		System.out.println(start + " ~ " + end);
		if(end < start) {
			return start;
		}
		if(start == end) {
			return start + 1;
		}
		
		long mid = (start + end) / 2 + 1;
		
		long sum = 0;
		for (int idx = 0; idx < N; idx++) {
			sum += mid/tk[idx];
		}
		
		if(sum < M) {
			return binarySearch(mid+1, end);
		} else {
			return binarySearch(start, mid-1);
		} 
	}
	
	
}
