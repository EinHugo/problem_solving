package BaekJoon_5373_큐빙_NP;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main { // BaekJoon #5373. 큐빙


	static char[][] cube = new char[6][10];
	static char[] tmpLine = new char[4];
	static Map<Integer, Integer> next = new HashMap<>();

	static void storeTmp(int code) {
		int a = (code%1000)/100;
		int b = (code%100)/10;
		int c = (code%10);
		
		tmpLine[1] = cube[code/1000][a];
		tmpLine[2] = cube[code/1000][b];
		tmpLine[3] = cube[code/1000][c];
	}

	static void restoreTmp(int code) {
		int a = (code%1000)/100;
		int b = (code%100)/10;
		int c = (code%10);
		
		cube[code/1000][a] = tmpLine[1];
		cube[code/1000][b] = tmpLine[2];
		cube[code/1000][c] = tmpLine[3];
	}
	
	static void spin(int code) {
		int a = (code%1000)/100;
		int b = (code%100)/10;
		int c = (code%10);
		int aspect = code/1000;
		
		int preCode = next.get(code);
		
		if(preCode == 0) {
			return ;
		}
		
		int pa = (preCode%1000)/100;
		int pb = (preCode%100)/10;
		int pc = (preCode%10);
		int preAspect = preCode/1000;
		
		cube[aspect][a] = cube[preAspect][pa];
		cube[aspect][b] = cube[preAspect][pb];
		cube[aspect][c] = cube[preAspect][pc];
		
		spin(preCode);
	}

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input5373.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 0: 윗 면, 1: 아랫 면, 2: 앞 면, 3: 뒷 면, 4: 왼쪽 면, 5: 오른쪽 면
		// x1 : 시계방향, x0 : 반시계방향

		next.put(00, 5741);
		next.put(5741, 2123);
		next.put(2123, 4369);
		next.put(4369, 3987);
		next.put(3987, 0);
		
		next.put(01, 5147);
		next.put(5147, 3789);
		next.put(3789, 4963);
		next.put(4963, 2321);
		next.put(2321, 0);
		
		next.put(10, 5369);
		next.put(5369, 3321);
		next.put(3321, 4741);
		next.put(3123, 4714);
		

		int T = Integer.parseInt(in.readLine().trim());

		for (int test = 1; test <= T; test++) {
			
			// 윗 면은 흰색, 아랫 면은 노란색, 앞 면은 빨간색, 뒷 면은 오렌지색, 왼쪽 면은 초록색, 오른쪽 면은 파란색
			for (int i = 1; i <= 9; i++) {
				cube[0][i] = 'w';
				cube[1][i] = 'y';
				cube[2][i] = 'r';
				cube[3][i] = 'o';
				cube[4][i] = 'g';
				cube[5][i] = 'b';
			}

			int n = Integer.parseInt(in.readLine().trim());
			StringTokenizer tokens = new StringTokenizer(in.readLine().trim(), " ");
			String command = "";
			int code = 0;
			
			for (int i = 0; i < n; i++) {
				
				// U: 윗 면, D: 아랫 면, F: 앞 면, B: 뒷 면, L: 왼쪽 면, R: 오른쪽 면
				command = tokens.nextToken();
				switch (command.charAt(0)) {
				case 'U':
					if (command.charAt(1) == '+') {
						code = next.get(01);
						storeTmp(code);
						spin(code);
						restoreTmp(code);
					} else {
						code = next.get(00);
						storeTmp(code);
						spin(code);
						restoreTmp(code);
					}
					break;

				default:
					break;
				}
			}
			
			System.out.println("" + cube[0][1] + cube[0][2] + cube[0][3]);
			System.out.println("" + cube[0][4] + cube[0][5] + cube[0][6]);
			System.out.println("" + cube[0][7] + cube[0][8] + cube[0][9]);

		}

	}
}

//static void up(char dir) {
//storeTmp(2);
//if (dir == '+') {
//	for (int i = 1; i <= 4; i++) {
//		cube[2][1][i] = cube[5][1][i];
//		cube[5][1][i] = cube[3][1][i];
//		cube[3][1][i] = cube[4][1][i];
//	}
//	restoreTmp(4);
//} else {
//	for (int i = 1; i <= 4; i++) {
//		cube[2][1][i] = cube[4][1][i];
//		cube[4][1][i] = cube[3][1][i];
//		cube[3][1][i] = cube[5][1][i];
//	}
//	restoreTmp(5);
//}
//}
//
//static void down(char dir) {
//storeTmp(2);
//if (dir == '+') {
//	for (int i = 1; i <= 4; i++) {
//		cube[2][1][i] = cube[5][1][i];
//		cube[5][1][i] = cube[3][1][i];
//		cube[3][1][i] = cube[4][1][i];
//	}
//	restoreTmp(4);
//} else {
//	for (int i = 1; i <= 4; i++) {
//		cube[2][1][i] = cube[4][1][i];
//		cube[4][1][i] = cube[3][1][i];
//		cube[3][1][i] = cube[5][1][i];
//	}
//	restoreTmp(5);
//}
//}