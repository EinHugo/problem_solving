package SWEA_3752_가능한시험점수;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[] score;
	static HashSet<Integer> sum = new HashSet<>();
	static HashSet<Integer> tmpSum = new HashSet<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());
		StringTokenizer tokens = null;
		for (int testCase = 1; testCase <= T; testCase++) {
			sum.clear();
			N = Integer.parseInt(in.readLine().trim());
			score = new int[N];
			tokens = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				score[i] = Integer.parseInt(tokens.nextToken());
			}
			Arrays.sort(score);
			
			sum.add(0);
			sum.add(score[0]);
			
			for (int i = 1; i < N; i++) {
				tmpSum.clear();
				for (Integer a : sum) {
					tmpSum.add(a + score[i]);
				}
				
				sum.addAll(tmpSum);
			}
			
			System.out.println("#" + testCase + " " + sum.size());
		}
	}

}
