package SWEA_6782_현주가좋아하는제곱근놀이;

import java.util.Scanner;
import java.io.FileInputStream;



class Solution6782_품 {		// #6782. 현주가 좋아하는 제곱근 놀이
	
	static int T, operation;
	static long pow, pow_ceil, root, root_ceil, N;
	static double sqrt;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			/////////////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////////
			N = sc.nextLong();
			operation = 0;
			
			while(N > 2) {
				sqrt = Math.sqrt(N);
				root = (long) (sqrt);
				pow = root * root;
				if(pow == N) {
					N = root;
					operation++;
					continue;
				} 
				
				root_ceil = root+1;
				pow_ceil = root_ceil * root_ceil;

				if (N < pow_ceil) {
					operation += pow_ceil - N + 1;
					N = root_ceil;
				} else {
					N++;
					operation++;
				}
			}
			
			StringBuilder sb = new StringBuilder("#").append(test_case).append(" ").append(operation);
			System.out.println(sb.toString());
		}
	}
}