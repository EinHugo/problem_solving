package SWEA_1223_계산기2;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static int getPriority(char a, boolean isInStack) {
		if (a == '+' || a == '-')
			return 1;
		else if (a == '*' || a == '/')
			return 2;
		else {
			return isInStack ? 0 : 3;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

//		BufferedReader in = new BufferedReader(new FileReader("res/postfix.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(in.readLine().trim());
		Stack<Character> stack = new Stack<>();
		StringBuilder expression;
		char temp, top;
		char[] line;
		int N;
		for (int testcase = 1; testcase <= 10; testcase++) {
			N = Integer.parseInt(in.readLine().trim());
			expression = new StringBuilder(N);
			line = in.readLine().toCharArray();

			for (int i = 0; i < N; i++) {
				temp = line[i];
				if (temp == ' ') {
					continue;
				}
				if (Character.isDigit(temp)) {
					expression.append(temp);
				} else if (temp == ')') {
					while (!stack.isEmpty() && (top = stack.pop()) != '(') {
						expression.append(top);
					}
				} else { // +, - , *, /, (
					while (!stack.isEmpty()) {
						if (getPriority(stack.peek(), true) < getPriority(temp, false)) {
							break;
						}
						expression.append(stack.pop());
					}
					stack.push(temp);
				}
			}
			while (!stack.isEmpty()) {
				expression.append(stack.pop());
			}

			int post, pre;
			Stack<Integer> answer = new Stack<>();
			
			for (int i = 0; i < expression.length(); i++) {
				char ch = expression.charAt(i);

				if (ch == ' ')
					continue;

				if (Character.isDigit(ch)) {
					answer.push((int) ch - '0');
				} else {
					post = answer.pop();
					pre = answer.pop();
					switch (ch) {
					case '–':
					case '-':
						answer.push(pre - post);
						break;
					case '+':
						answer.push(pre + post);
						break;
					case '*':
						answer.push(pre * post);
						break;
					case '/':
						answer.push(pre / post);
					default:
						break;
					}
				}

			}

			System.out.println("#" + testcase + " " + answer.pop());

		}

	}
}
