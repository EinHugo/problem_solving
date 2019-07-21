package SWEA_3459_승자예측하기_NP;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;



public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		long N;
		int count;
		
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Long.parseLong(in.readLine().trim());
			count = 1;
			System.out.print(N + " -> ");
			
			N /= 2;
			N++;
			count++;
			
			long i = 1;
			while(N >= 1) {
				System.out.print(N + " ");
				if(count%2 == 1 && N%2 == 0) {	
					N /= 2;
					N++;
				} else {
					N /= 2;
				}
				count++;
			}
//			System.out.println(count);
//			if(N > 7) {
//				N /= 2;
//				count++;
//				System.out.print(N + " ");
//			}
//			
//			while(N >= 1) {
//				N /= 2;
//				System.out.print(N + "(" + count + ") ");
//				count++;
//				if(N == 3) {
//					count = 1;
//					break;
//				} else if (N == 2) {
//					count = 2;
//					break;
//				}
//				N--;
//			}
			
			StringBuilder sb = new StringBuilder().append("#").append(testCase).append(" ");
			if(count%2 == 0) {
				sb.append("Bob");
			} else {
				sb.append("Alice");
			}
			System.out.println(sb);
		}
		
	}
}


