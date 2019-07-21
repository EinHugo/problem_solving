package SWEA_4699_콩순이의가장싼팰린드롬_NP;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution2 { // SWexpert #4699. 콩순이의 가장 싼 팰린드롬 https://goo.gl/dG9AoJ

	private static int[][] alpCost;
	private static int[] palindrome;
	private static int total;

	private static int mirror(int left, int right, int sum) {
//        System.out.println("들어옴 : (" + left + ", " + right + ") = " + sum);

		if (right <= left) { // return at center
			return 0;
		}
		if (sum >= total || sum < 0) { // pruning
			return 0;
		}

		if (palindrome[left] == palindrome[right]) { // same value -> go next

			mirror(++left, --right, sum);
			return sum;

		} else {
			int min = Integer.MAX_VALUE;
			int tmp = 0;

			tmp = addLeft(left, right, sum); // first of all, go to the end.
			if (tmp < min) {
				min = tmp;
				if (min + sum < total) {
					total = min + sum;
				}
			}

			tmp = addRight(left, right, sum);
			if (tmp < min) {
				min = tmp;
				if (min + sum < total) {
					total = min + sum;
				}
			}

			tmp = removeLeft(left, right, sum);
			if (tmp < min) {
				min = tmp;
				if (min + sum < total) {
					total = min + sum;
				}
			}

			tmp = removeRight(left, right, sum);
			if (tmp < min) {
				min = tmp;
				if (min + sum < total) {
					total = min + sum;
				}
			}
			return sum + min;
		}

	}

	public static int addLeft(int left, int right, int sum) { // add to left (from right one)
		return alpCost[palindrome[right]][0] + mirror(left, right - 1, sum + alpCost[palindrome[right]][0]);
	}

	public static int addRight(int left, int right, int sum) { // add to right (from left one)
		return alpCost[palindrome[left]][0] + mirror(left + 1, right, sum + alpCost[palindrome[left]][0]);
	}

	public static int removeLeft(int left, int right, int sum) { // remove left ones until there's same value
		int i, tmp;
		for (i = 0, tmp = 0; palindrome[left + i] != palindrome[right]; i++) {
			tmp += alpCost[palindrome[left + i]][1];
			if (right - (left + i) <= 1) {
				break;
			}
		}
		return mirror(left + i, right, sum + tmp);
	}

	public static int removeRight(int left, int right, int sum) { // remove right ones until there's same value
		int i, tmp;
		for (i = 0, tmp = 0; palindrome[left] != palindrome[right - i]; i++) {
			tmp += alpCost[palindrome[right - i]][1];
			if ((right - i) - left <= 1) {
				break;
			}
		}
		return mirror(left, right - i, sum + tmp);
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input4699.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		int L, K;
		String[] lineToken;
		alpCost = new int[126][2]; // ASCII value
		palindrome = new int[2001]; // Max size of L : 2000

		for (int testCase = 1; testCase <= T; testCase++) {
			total = Integer.MAX_VALUE;

			lineToken = in.readLine().trim().split(" ");

			L = Integer.parseInt(lineToken[0]); // length of Line (1 ~ 2000)
			K = Integer.parseInt(lineToken[1]); // number of character (1 ~ 26)

			for (int i = 0; i < L; i++) {
				palindrome[i] = in.read(); // cost of insert/delete (0 ~ 10000)
			}
			in.readLine(); // remove /n/r

			for (int i = 0; i < K; i++) {
				lineToken = in.readLine().trim().split(" ");
				alpCost['a' + i][0] = Integer.parseInt(lineToken[0]);
				alpCost['a' + i][1] = Integer.parseInt(lineToken[1]);
			}

			System.out.println("#" + testCase + " " + mirror(0, L - 1, 0)); // min value

		}

	}
}