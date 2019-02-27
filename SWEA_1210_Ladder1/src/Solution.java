import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 	dir <- array of left, right, up	directions
 * 
 * 	int go(int x, int y):
 * 		if x is 0:
 * 			return y;
 * 		for i in (0..2):
 * 			newX <- x + dir[0]
 * 			newY <- y + dir[1]
 * 			if map[newX][newY] is 1:
 * 				go(newX, newY)
 * 				break
 * 
 * 	test_case <- # of test case
 * 
 * 	for t in (1..test_case):
 * 		map[100][100] <- map of each test case
 * 
 * 		for i in (0..99):
 * 			if map[99][i] is 2:
 * 				point <- i
 * 				break
 * 		
 * 		go(99, point)
 * 
 * 		print #t point
 */

public class Solution {

	static int[][] map;
	static int point;
	static int[][] dir = {{0,-1}, {0,1}, {-1,0}}; // left, right, up

	static private int go(int x, int y) {
		int tmp = -1;
		if(x == 0) {
			return y;
		}
		for (int i = 0; i < 3; i++) {
			int newX = x + dir[i][0];
			int newY = y + dir[i][1];
			if(newX>99 || newX<0 || newY>99 || newY<0)
				continue;
			
			if (map[newX][newY] == 1) {
				map[newX][newY] = 2;
				tmp = go(newX,newY);
				break;
			}
		}
		return tmp;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		for (int test_num = 1; test_num <= 10; test_num++) {
			int test_case = Integer.parseInt(br.readLine());
			map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < 100; i++) {
				if(map[99][i] == 2) {
					point = i;
					break;
				}
			}
			
			System.out.println("#" + test_case + " " + go(99,point));
		}		
	}
}
