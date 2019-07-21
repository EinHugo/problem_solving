package SWEA_4672_수진이의팰린드롬;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution {

	static String line;
	static int size;
	static int answer;
	
	static int[] alphabet;
	static LinkedList<Integer> distort = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(in.readLine().trim());
		
		
		for (int tc = 1; tc <= T; tc++) {
			answer = 0;
			distort.clear();
			
			alphabet = new int[26];
			
			
			line = in.readLine().trim();
			size = line.length();
			
			for (int i = 0; i < size; i++) {
				alphabet[ line.charAt(i)-'a' ]++; 
			}
			
			
		
			System.out.println("#" + tc + " " + answer);
		}
	}

	static boolean getPalindrome(int left, int right) {
		if (left == right) {
			return true;
		}

		for (int offset = 0, mid = (right - left) / 2; offset <= mid; offset++) {
			if (distort.get(left + offset) != distort.get(right - offset)) {
				return false;
			}
		}
		return true;
	}
}
