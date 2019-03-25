import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static String A, B; // 1~10000

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());
		StringTokenizer tokens;
		for (int tc = 1; tc <= T; tc++) {
			tokens = new StringTokenizer(in.readLine().trim());
			
			A = tokens.nextToken();
			B = tokens.nextToken();
			
			A = A.replace(B, ".");
			
			System.out.println("#" + tc + " " + A.length());
			
		}

	}
}
