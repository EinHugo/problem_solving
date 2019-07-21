package SWEA_5986_새샘이와세소수;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Solution {
	
	static int N;
	static boolean[] notPrimes = new boolean[1000];
	static int p1,p2,p3;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/s_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 2; i < 1000; i++) {
			if(notPrimes[i]) continue;
			for (int j = 2, sqr = i; sqr*j < 1000; j++) {
				notPrimes[sqr*j] = true;
			}
		}
		
		
		int T = Integer.parseInt(in.readLine().trim());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(in.readLine().trim());
			int count = 0;
			
			for (int i = 2; i < 1000; i++) {
				if(notPrimes[i]) 	continue;
				if(i >= N)	break;
				p1 = i;
				for (int j = i; j < 1000; j++) {
					if(notPrimes[j]) 	continue;
					if(p1 + j >= N)		break;
					p2 = j;
					for (int k = j; k < 1000; k++) {
						if(notPrimes[k]) 	continue;
						if(p1 + p2 + k > N)	break;
						p3 = k;
						if(p1 + p2 + p3 == N) {
							count++;
						}
					}
				}
			}
			
			System.out.println("#" + testCase + " " + count);
		}
		
		
	}
	
}
