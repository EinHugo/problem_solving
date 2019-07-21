package SWEA_5432_쇠막대기자르기;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {


		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		sc.nextLine();
		Stack<Character> stack = new Stack<>();

		for (int test_case = 1; test_case <= T; test_case++) {

			/////////////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////////

			String line = sc.nextLine();
			int size = line.length();
			int total = 0;
			boolean preLeft = false;
			
			for (int i = 0; i < size; i++) {
				char ch = line.charAt(i);


				if (ch == ')') {
					stack.pop();
					if (preLeft) {
						total += stack.size();
					}
					preLeft = false;
				} else {
					stack.push(ch);
					if (preLeft) {
						total++;
					}
					preLeft = true;
				}
			}

			System.out.println("#" + test_case + " " + total);
		}
	}
}