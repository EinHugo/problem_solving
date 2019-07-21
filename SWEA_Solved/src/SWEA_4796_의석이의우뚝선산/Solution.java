package SWEA_4796_의석이의우뚝선산;
import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	static final int INF = Integer.MAX_VALUE;
	
	static int N, answer;
	static int leftCnt, rightCnt;
	static int pre, cur;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = in.nextInt();
			leftCnt = 0; rightCnt = 0;answer = 0;
			
			pre = in.nextInt();
			
			for (int i = 1; i < N; i++) {
				cur = in.nextInt();
				if(pre < cur) {
					if(rightCnt == 0) {
						leftCnt++;
					} else {	// add answer
						answer += leftCnt * rightCnt;
						leftCnt = 1; rightCnt = 0;
					}
				} else {
					if(leftCnt == 0) {
						rightCnt = 0;
					} else {
						rightCnt++;
					}
				}
				pre = cur;
			}
			
			answer += leftCnt * rightCnt;
			
			System.out.println("#" + tc + " " + answer);
			
		}
		
	}

}
