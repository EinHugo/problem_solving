package SWEA_5672_올해의조련사;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Solution_시초 {

	static int N;
	static char[] animals;
	static StringBuilder answer;
	
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
			
			if(animals[first] < animals[last]) {
				answer.append(animals[first++]);
			} else if(animals[first] > animals[last]) {
				answer.append(animals[last--]);
			} else {
				boolean isDiff = false;
				int left = 0, right = 0;
				for (int offset = 1; left * right == 0; offset++) {
//					System.out.println("뭐냐");
					isDiff = true;
					if(offset > (last - first) / 2 + 1) {
						for (int cnt = 0; cnt < offset; cnt++) {
							answer.append(animals[first++]);
						}
						isDiff = false;
						break;
					}
						
					if(left == 0 && animals[first + offset] != animals[last]) {
						left = first + offset;
					}
					
					if(right == 0 && animals[first] != animals[last - offset]) {
						right = last - offset;
					}
				}	// end of for
				
				if(isDiff) {
					if(left < right) {
						if(animals[left] < animals[right]) {
							for (int cnt = 0; cnt < left - first; cnt++) {
								answer.append(animals[first++]);
							}
						} else {
							for (int cnt = 0; cnt < last - right; cnt++) {
								answer.append(animals[last--]);
							}
						}
						
					} else {
						if(animals[left] < animals[first]) {
							for (int cnt = 0; cnt < left - first; cnt++) {
								answer.append(animals[first++]);
							}
						}
					}
				}
			}
		}

	}
}
