import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.text.AbstractDocument.LeafElement;

public class Solution {

	static int N;
	static char[] animals;
	static StringBuilder answer;
	static Queue<Character> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(in.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			answer = new StringBuilder().append('#').append(tc).append(' ');
			
			
			N = Integer.parseInt(in.readLine().trim());
			animals = new char[N];
			for (int i = 0; i < N; i++) {
				animals[i] = in.readLine().trim().charAt(0);
			}
			
			putIn(0, N-1);
			
			System.out.println(answer);
		}
	}
	
	static void putIn(int first, int last) {
		while(true) {
			if(last < first) {
				return ;
			} 
			System.out.println(first + " / " + last);
			
			if(findDiff(first, last)) {
				answer.append(animals[first++]);
			} else {
				answer.append(animals[last--]);
			} 
		}
	}
	
	static boolean findDiff(int first, int last) {
		while(true) {
			if(last < first) {
				return true;
			}
			
			if(animals[first] < animals[last]) {
				return true;
			} else if (animals[first] > animals[last]) {
				return false;
			}
			first++; last--;
		}
	}
	
}
