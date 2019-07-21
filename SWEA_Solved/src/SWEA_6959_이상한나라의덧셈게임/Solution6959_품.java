package SWEA_6959_이상한나라의덧셈게임;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution6959_품 {
	static Stack<Integer> stack = new Stack<>();
	static int count = 0;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input6959.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		
		for (int test = 1; test <= T; test++) {
			String line = in.readLine().trim();
			for (int i = line.length() -1 ; i >= 0; i--) {
				stack.push(line.charAt(i) - '0');
			}
			count = 0;
			while(stack.size() >= 2) {
				count++;
				int tmp = stack.pop() + stack.pop();
				while(tmp >= 10) {
					tmp = tmp%10 + tmp/10;
				}
				stack.push(tmp);
			}
			
			
			System.out.println("#" + test + " " + ((count%2==0)?"B":"A") );
			stack.clear();
		}
	}
	
}
