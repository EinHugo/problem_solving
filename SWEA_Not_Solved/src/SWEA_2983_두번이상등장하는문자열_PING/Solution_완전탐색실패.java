package SWEA_2983_두번이상등장하는문자열_PING;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.Character.Subset;

public class Solution_완전탐색실패 {
	static int L;
	static String S;
	static String[][] subs;
	static int max = 0;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			max = 0;
			StringBuilder sb = new StringBuilder().append("#").append(testCase).append(" ");
			
			L = Integer.parseInt(in.readLine().trim());
			S = in.readLine().trim();
			
			sb.append(check(0, L));
			
			System.out.println(sb);
		}
	}
	
	static int check(int start, int end){
		if(start > end) {
			return 0;
		}
		if(end - start < max) {
			return 0;
		}
		
		String sub = S.substring(start, end);
		int index = S.indexOf(sub);
		if(S.substring(index+1).contains(sub)) {
			max = Math.max(max, sub.length());
			return sub.length();
		}
		
		return Math.max(check(start+1, end), check(start, end-1));
		
	}
}
