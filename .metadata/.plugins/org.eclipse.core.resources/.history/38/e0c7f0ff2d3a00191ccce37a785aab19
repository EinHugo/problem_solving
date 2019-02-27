
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		Stack<Character> stack = new Stack<>();
		Stack<Character> answer = new Stack<>();
		

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		
		for (int test_case = 1 ; test_case <= 10 ; test_case++) {

			StringBuilder sb = new StringBuilder();

			String line = br.readLine().trim();
			String[] tokens = line.split(" ");
			int length = Integer.parseInt(tokens[0]);
			line = tokens[1];
//			System.out.println("");
//			System.out.println(length + " " +line);
			
			for (int ch = 0; ch < length; ch++) {
				if(stack.isEmpty()) {
					stack.push(line.charAt(ch));
				} else if(stack.peek() == line.charAt(ch)) {
					stack.pop();					
				} else {
					stack.push(line.charAt(ch));
				}				
			}
			
			while(!stack.isEmpty())
				answer.push(stack.pop());
			
			while(!answer.isEmpty())
				sb.append(answer.pop());
			System.out.print("#" + test_case + " ");
			System.out.println(sb);
			
						
		}
	}
}
