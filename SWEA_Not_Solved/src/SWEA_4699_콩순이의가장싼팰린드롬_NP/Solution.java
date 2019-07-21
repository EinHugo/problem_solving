package SWEA_4699_콩순이의가장싼팰린드롬_NP;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution { // SWexpert #4699. 콩순이의 가장 싼 팰린드롬

	private static int[][] alpCost;
	private static int[] palindrome;
	private static int total;

	private static int mirror(int left, int right, int cost) {
//        System.out.println("들어옴 : (" + left + ", " + right + ") = " + sum);
		if(right <= left) {
//			System.out.println(cost + "!!!!!!!!!!!!!!!!!!!");
			return cost;
		}
		
		int leftMin = Math.min(alpCost[palindrome[left]][0], alpCost[palindrome[left]][1]);	// remove left one
		int rightMin = Math.min(alpCost[palindrome[right]][0], alpCost[palindrome[right]][1]);	// remove right one
		int leftMirror = mirror(left+1, right, leftMin);
		int rightMirror = mirror(left, right-1, rightMin);
//		System.out.println(left + "," + right + " : " + leftMin + ", " + rightMin + " -> "  + leftMirror + ", " + rightMirror);
		int min = Math.min(leftMirror, rightMirror) + cost;
		System.out.println(left + "," + right + " - " + cost + " : " + min);
		
//		if(total > min){
//			total = min;
//			System.out.println("################# total : " + total);
//		}
		
		return min;

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
			total = 10000000; //Integer.MAX_VALUE;

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
			System.out.println(mirror(0, L - 1, 0));
			System.out.println("#" + testCase + " " + total); // min value

		}

	}
}