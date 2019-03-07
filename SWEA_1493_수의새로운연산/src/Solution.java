import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static final int y_height = 150 * 2;
	
	static int[] y_1 = new int[y_height];
	static int p,q;
	static int p_start, q_start;
	static int p_y, p_x, q_y, q_x;
	static int sum_x , sum_y, sum;
	
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		
		y_1[1] = 1;
		
		for (int i = 2; i < y_height; i++) {
			y_1[i] = y_1[i-1] + i-1;
		}
		
		StringTokenizer tokens;
		
		for (int testCase = 1; testCase <= T; testCase++) {
			tokens = new StringTokenizer(in.readLine());
			p = Integer.parseInt(tokens.nextToken());
			q = Integer.parseInt(tokens.nextToken());
			p_start = -1;
			q_start = -1;
			
			for (int i = 1; i < y_height; i++) {
				if(p_start < 0 && y_1[i] > p) {
					p_start = i - 1;
				}
				
				if(q_start < 0 && y_1[i] > q) {
					q_start = i - 1;
				}
				
				if(p_start > 0 && q_start > 0) {
					break;
				}
			}
			
			
			p_y = p_start - (p - y_1[p_start]);
			p_x = 1 + p - y_1[p_start];
			q_y = q_start - (q - y_1[q_start]);
			q_x = 1 + q - y_1[q_start];
			
			if(p_start <= 0) {
				p_x = p_y = 1;
			}
			if(q_start <= 0) {
				q_x = q_y = 1;
			}
			
			sum_x = p_x + q_x;
			sum_y = p_y + q_y;

			sum = y_1[sum_y];
			for (int i = 1, add = sum_y; i < sum_x; i++) {
				sum += add + i;
			}
			
			
			System.out.println("#" + testCase + " " + sum);
		}
		
	}
}
