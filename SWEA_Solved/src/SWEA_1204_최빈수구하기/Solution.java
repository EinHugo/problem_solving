package SWEA_1204_최빈수구하기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Solution { // #1204. [S/W 문제해결 기본] 1일차 - 최빈수 구하기

	static int score;
	
	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("res/sample_input1204.txt"));
		// 입력 조절
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test = 1; test <= T; test++) {
			int[] scores = new int[101];
			int max_idx = 0;
			int test_num = sc.nextInt();
			for (int i = 0; i < 1000; i++) {
				score = sc.nextInt();
				scores[score]++;
				if(scores[score] > scores[max_idx]) {
					max_idx = score;
				} else if(scores[score] == scores[max_idx]) {
					if(score > max_idx) {
						max_idx = score;
					}
				}
			}
			System.out.println("#" + test_num + " " + max_idx);
			
		}

	}

}

