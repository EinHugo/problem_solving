package SWEA_1218_괄호짝짓기;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {

		Stack<Character> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		char ch;

		for (int test = 1; test <= 10; test++) {
			int length = sc.nextInt();
			sc.nextLine(); // remove empty line
			String line = sc.nextLine();
			boolean isWrong = false;

			for (int i = 0; i < length; i++) {
				ch = line.charAt(i);

				switch (ch) {
				case ')':
					if (!(stack.pop() == '(')) {
						isWrong = true;
					}
					break;
				case ']':
					if (!(stack.pop() == '[')) {
						isWrong = true;
					}
					break;
				case '}':
					if (!(stack.pop() == '{')) {
						isWrong = true;
					}
					break;
				case '>':
					if (!(stack.pop() == '<')) {
						isWrong = true;
					}
					break;
				default:
					stack.push(ch);
					break;
				}
				
				if(isWrong) {
					break;
				}
				
			}



			System.out.print("#" + test + " ");
			if (stack.isEmpty() && !isWrong) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}

			stack.clear();

		}
	}
}
