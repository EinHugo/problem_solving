package BaekJoon_14891_톱니바퀴;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static final int PLUS = -1, MINUS = 1;
	static int[][] gear;
	static int[][] point;
	static boolean[] changeable;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		gear = new int[5][8];
		point = new int[5][2];
		changeable = new boolean[4]; // 1~2, 2~3, 3~4;
		changeable[0] = true;
		
		for (int i = 1; i <= 4; i++) {
			String line = in.readLine().trim();
			
			for (int j = 0, size = line.length(); j < size; j++) {
				gear[i][j] = line.charAt(j) - '0';
			}
			
			point[i][0] = 6;
			point[i][1] = 2;
		}
		
		int K = Integer.parseInt(in.readLine().trim());
		StringTokenizer tokens;
		int change, d;
		
//		print();
		
		for (int command = 0; command < K; command++) {
			setChangeable();
			tokens = new StringTokenizer(in.readLine().trim());
			change = Integer.parseInt(tokens.nextToken());
			if(tokens.nextToken().equals("-1")) {
				d = MINUS;
			} else{
				d = PLUS;
			}
			
			for (int i = change-1; i >= 1; i--) {
				if(!changeable[i]) {
					break;
				}
				if((change-i) % 2 == 0){	// 같은 방향
					point[i][0] += d;
					point[i][1] += d;
					
					if(point[i][0] < 0) {
						point[i][0] = 7;
					} else if(point[i][0] >= 8) {
						point[i][0] = 0;
					}
					
					if(point[i][1] < 0) {
						point[i][1] = 7;
					} else if(point[i][1] >= 8) {
						point[i][1] = 0;
					}
					
				} else {					// 다른 방향
					point[i][0] -= d;
					point[i][1] -= d;

					if(point[i][0] < 0) {
						point[i][0] = 7;
					} else if(point[i][0] >= 8) {
						point[i][0] = 0;
					}
					
					if(point[i][1] < 0) {
						point[i][1] = 7;
					} else if(point[i][1] >= 8) {
						point[i][1] = 0;
					}
				}
			}
			for (int i = change+1; i <= 4; i++) {
				if(!changeable[i-1]) {
					break;
				}
				if((i-change) % 2 == 0){	// 같은 방향
					point[i][0] += d;
					point[i][1] += d;
					
					if(point[i][0] < 0) {
						point[i][0] = 7;
					} else if(point[i][0] >= 8) {
						point[i][0] = 0;
					}
					
					if(point[i][1] < 0) {
						point[i][1] = 7;
					} else if(point[i][1] >= 8) {
						point[i][1] = 0;
					}
					
				} else {					// 다른 방향
					point[i][0] -= d;
					point[i][1] -= d;

					if(point[i][0] < 0) {
						point[i][0] = 7;
					} else if(point[i][0] >= 8) {
						point[i][0] = 0;
					}
					
					if(point[i][1] < 0) {
						point[i][1] = 7;
					} else if(point[i][1] >= 8) {
						point[i][1] = 0;
					}
				}
			}
			point[change][0] += d;
			point[change][1] += d;
			
			if(point[change][0] < 0) {
				point[change][0] = 7;
			} else if(point[change][0] >= 8) {
				point[change][0] = 0;
			}
			
			if(point[change][1] < 0) {
				point[change][1] = 7;
			} else if(point[change][1] >= 8) {
				point[change][1] = 0;
			}
			
//			print();
			
		}
		
		int answer = 0;
		for (int idx = 1, mul = 1; idx <= 4; idx++, mul*=2) {
			int point12 = (point[idx][1]-2 + 8) % 8; 
			
			if(gear[idx][point12] == 1) {
				answer += mul;
			}
		}
		System.out.println(answer);

	}
	
	
	static void setChangeable() {
		for (int i = 1; i < 4; i++) {
			if(gear[i][point[i][1]] != gear[i+1][point[i+1][0]]) {
				changeable[i] = true;
			} else {
				changeable[i] = false;
			}
		}
	}
	
	static void print() {
		System.out.println("~~~~~~~~~~~~~~~~");
		for (int i = 1; i <= 4; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(gear[i][j]);
			}
			System.out.println(" : " + gear[i][point[i][0]] + "(" + point[i][0] + ") , " + gear[i][point[i][1]] + "(" + point[i][1] + ")");
		}
		
		System.out.println("~~~~~~~~~~~~~~~~");
	}
	
}
