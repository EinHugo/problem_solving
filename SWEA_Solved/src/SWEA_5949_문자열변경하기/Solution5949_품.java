package SWEA_5949_문자열변경하기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution5949_품 { // SWexpert #5949. 문자열 변경하기
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("res/sample_input5949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TEST = Integer.parseInt(br.readLine().trim());

		for (int test_case = 1; test_case <= TEST; test_case++) {

			String S = br.readLine().trim();
			String T = br.readLine().trim();

			long cost = 0;

			int size = S.length();
			
			if(size != T.length()) {
				System.out.println("#" + test_case + " -1");
				continue;
			}
			
			int[][] a = new int[size][2];
			
			int countS = 0, countT=0;

			for (int i = 0; i < size; i++) {
				if(S.charAt(i) == 'a') {
					a[countS++][0] = i+1;
				}
				if(T.charAt(i) == 'a') {
					a[countT++][1] = i+1;
				}
			}

			if(countS != countT) {
				cost = -1;
			} else {
				for (int i = 0; i < size; i++) {
					if(a[i][0] == 0) {
						break;
					}
					cost += Math.abs(a[i][1] - a[i][0]);
//					System.out.println(Math.abs(a[i][1] - a[i][0]));
				}

			}
			
			System.out.println("#" + test_case + " " + cost);

		}
	}
}