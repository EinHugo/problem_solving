
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// SW Academy #6058. 새해 축하 파티

public class Solution {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/sample_input6058.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		String line;
		String tokens[] = new String[3];

		int B, L, N;

		for (int testCase = 1; testCase <= T; testCase++) {
			line = br.readLine().trim();
			tokens = line.split(" ");
			B = Integer.parseInt(tokens[0]) * 3; // 750/250 = 3 		# of Bottle (Glass)
			L = Integer.parseInt(tokens[1]);	// # of Line
			N = Integer.parseInt(tokens[2]);	// 
			int numberOfL = L * (L + 1) / 2;
			int[] indexOfThrice = new int[(L-1) * L / 2];
			
			for (int i = 4; i <= L; i++) {
//				for
			}
			
			int total = 0;
			double answer = 0;
			for (int i = 1; i <= L; i++) {
				total += i * (i + 1) / 2;
			}
			int rest = B - total; // L 라인까지 채워지고도 얼마나 채울정도로 남았나?
			if (rest >= 0) { // 남았다! -> 250ml 채워졌을것이다.
				System.out.println("남은경우 : " +rest);
				answer = 250;
			} else if (numberOfL < -rest) { // 부족하다! -> 그 라인에서 얼마만큼 채워졌는가? 
//				System.out.println("아예 미치지 못하는 경우 : 0 출력###########");	// 그 라인이 채워지지 않은 경우
			} else {						// 채워지긴 하였다! 그러면 몇개만 가득 채워졌나?
				int fill = numberOfL + rest;
				answer = (double) fill / numberOfL;
				answer /= 3;
				answer *= 250;
				if(N == 1 || N == L || N == numberOfL) {
//					System.out.println("###");
					;
//				} else if (N == thrice){	// thrice
//					answer *= 3;
				} else {			// twice
					answer *= 2;
				}
					
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}
}
