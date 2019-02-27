import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {	
	public static void main(String[] args) throws Exception {
		final int mod = 1234567891;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer tokens = null;
		int N, R;
		int middle;
		
		for (int testCase = 1; testCase <= T; testCase++) {
			double total = 1;
			double total1 = 1;
			double total2 = 1;

			tokens = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken());
			
			middle = (N + N - R) / 2;
			for (int i = N; i > middle; i--) {
				total1 *= i;
				if(total1 > mod) {
					total1 %= mod;
				}
			}			

			
			for (int i = middle; i > N-R; i--) {
				total2 *= i;
				if(total2 > mod) {
					total2 %= mod;
				}
			}			
//			System.out.println("total : " + total);
			total = total1 * total2;
			total %= mod;
			
			for (int i = R; i > 0; i--) {
				total /= i;
			}
//			System.out.println("total : " + total);
			
			System.out.println("#" + testCase + " " + (long)(total%1234567891));
		}
	}
}
