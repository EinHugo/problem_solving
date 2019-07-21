package SWEA_3378_스타일리쉬들여쓰기;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	// requirements
	static int p,q;
	
	// for input
	static StringTokenizer tokens;
	
	// for process
	
	// for output
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			tokens = new StringTokenizer(in.readLine());
			p = Integer.parseInt(tokens.nextToken());
			q = Integer.parseInt(tokens.nextToken());
			
		}
		
		
	}
}
