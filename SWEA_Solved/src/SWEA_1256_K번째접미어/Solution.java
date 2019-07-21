package SWEA_1256_K번째접미어;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int K;
	static String line; 
	static String[] subLines;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		
		
		for (int testCase = 1; testCase <= T; testCase++) {
			K = Integer.parseInt(in.readLine().trim());
			line = in.readLine();
			int length = line.length();
			subLines = new String[length];
			for (int i = 0; i < length; i++) {
				subLines[i] = line.substring(i);
			}
			Arrays.sort(subLines);
			
			
			String answer = subLines[K-1];
			System.out.println("#" + testCase + " " + answer);
		}
	}
}
