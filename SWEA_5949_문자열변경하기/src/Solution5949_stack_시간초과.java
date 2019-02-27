
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution5949_stack_시간초과 { 	// SWexpert #5949. 문자열 변경하기

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("res/sample_input5949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TEST = Integer.parseInt(br.readLine().trim());

		for (int test_case = 1; test_case <= TEST; test_case++) {

			String S = br.readLine().trim();
			String T = br.readLine().trim();
			Stack<Character> stackS = new Stack<>();
			Stack<Character> stackT = new Stack<>();
			Stack<Character> temp = new Stack<>();
			int cost = 0;

			int size = S.length();
			for (int i = 0; i < size; i++) {
				stackS.push(S.charAt(i));
				stackT.push(T.charAt(i));
			}
			char chS, chT;

			for (int i = 0; i < size; i++) {
//				System.out.println(stackS + " / " + stackT);
				chS = stackS.pop();
				chT = stackT.pop();

				while (chS != chT) {
					if (T.isEmpty()) {
						cost = -1;
						break;
					} else {
						temp.push(chT);
						chT = stackT.pop();
					}
				}
				if (cost == -1) {
					break;
				}
				while (!temp.isEmpty()) {
					cost++;
					stackT.push(temp.pop());
				}

			}

			System.out.println("#" + test_case + " " + cost);

		}
	}
}