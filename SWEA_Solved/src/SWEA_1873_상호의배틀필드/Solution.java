package SWEA_1873_상호의배틀필드;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution {

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // �����¿�
	static int H, W, N;
	static int x = 0, y = 0, face = 0;
	static int newX, newY;
	static char[][] map;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());

		StringTokenizer tokens = null;
		String line;
		char ch;
		
		boolean isTankFound ;
		
		for (int testCase = 1; testCase <= T; testCase++) {
			tokens = new StringTokenizer(in.readLine());
			H = Integer.parseInt(tokens.nextToken());	//  (2 �� H �� 20) 
			W = Integer.parseInt(tokens.nextToken());	//  (2 �� W �� 20) 
			map = new char[H][W];
			isTankFound = false;
			
			for (int i = 0; i < H; i++) {
				line = in.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);
					if(!isTankFound) {
						switch (map[i][j]) {
						case '^':
							x=i; y=j;
							face = 0;
							isTankFound = true;
							break;
						case 'v':
							x=i; y=j;
							face = 1;
							isTankFound = true;
							break;
						case '<':
							x=i; y=j;
							face = 2;			
							isTankFound = true;
							break;
						case '>':
							x=i; y=j;
							face = 3;
							isTankFound = true;
							break;
						default:
							break;
						}
					}
				}
			}
			
			N = Integer.parseInt(in.readLine());
			line = in.readLine();

			for (int i = 0; i < N; i++) {
				
				ch = line.charAt(i);
				switch(ch) {
				case 'U':
				case 'D':
				case 'L':
				case 'R':
					go(ch);
					break;
				case 'S':
					shoot();
				}
			}
			
			System.out.print("#" + testCase + " " );
			print();
			
		}
		
	}
	
	static void print() {
		for (int i = 0; i < H; i++) {
			System.out.println(String.valueOf(map[i]));
//			for (int j = 0; j < W; j++) {
//				System.out.print(map[i][j]);
//			}
		}
	}
	
	
	static void go(char where) {
		switch (where) {
		case 'U':
			face = 0;
			map[x][y] = '^';
			break;
		case 'D':
			face = 1;
			map[x][y] = 'v';
			break;
		case 'L':
			face = 2;
			map[x][y] = '<';
			break;
		case 'R':
			face = 3;
			map[x][y] = '>';
			break;
		default:
			break;
		}
		newX = x + dir[face][0];
		newY = y + dir[face][1];
		
		if(newX < 0 || newY < 0 || newX >= H || newY >= W) {
			return;
		}
		
		if(map[newX][newY] == '.') {
			map[newX][newY] = map[x][y];
			map[x][y] = '.';
			x = newX;
			y = newY;
		}
	}
	
	static void shoot() {
		for (int i = 1; true; i++) {
			newX = x + dir[face][0] * i;
			newY = y + dir[face][1] * i;
			
			if(newX < 0 || newY < 0 || newX >= H || newY >= W) {
				return;
			}
			
			switch (map[newX][newY]) {
			case '#':
				return;
			case '*':
				map[newX][newY] = '.';
				return;
			default:
				break;
			}
		}
	}
		
}
