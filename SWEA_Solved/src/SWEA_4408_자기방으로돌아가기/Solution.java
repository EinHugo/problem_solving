package SWEA_4408_자기방으로돌아가기;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		int[] takes = new int[401];
		StringTokenizer tokens = null;
		int[] fromTo = new int[2];
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(in.readLine().trim());
			int max = 0;
			
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(in.readLine());
				fromTo[0] = Integer.parseInt(tokens.nextToken());
				fromTo[1] = Integer.parseInt(tokens.nextToken());
				int from = Math.min(fromTo[0], fromTo[1]), to = Math.max(fromTo[1],fromTo[0]);
				if(from%2 == 0) {
					from--;
				}
				if(to%2 == 1) {
					to++;
				}
				for (; from <= to; from++) {
					
					takes[from]++;
					if(takes[from] > max) {
						max = takes[from];
					}
				}
			}
			
//			for (int i = 1; i <= 400; i++) {
//				System.out.print(takes[i] + " ");
//			}
//			System.out.println();
			
			System.out.println("#" + testCase + " " + max);
			Arrays.fill(takes, 0);
		}
		
	}
}

