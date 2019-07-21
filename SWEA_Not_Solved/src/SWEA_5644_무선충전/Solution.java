package SWEA_5644_무선충전;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Charger {
	int X, Y, C, P;
	
	public Charger(int X, int Y, int C, int P) {
		this.X = X;
		this.Y = Y;
		this.C = C;
		this.P = P;
	}
}


public class Solution {

	// requirements
	static final int NOP = 0, UP = 1, RIGHT = 2, DOWN = 3, LEFT = 4;
	static int M, A;
	static int[][] map;

	// for input
	static StringTokenizer tokens;
	static String line;
	static int[][] move1, move2;
	
	// for process
	static final int[][] dir = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int i, j;
	static ArrayList<Charger> chargers  = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			chargers.clear();
			
			tokens = new StringTokenizer(in.readLine());
			M = Integer.parseInt(tokens.nextToken());
			A = Integer.parseInt(tokens.nextToken());

			map = new int[11][11];
			
			move1 = new int[M+1][2];
			move2 = new int[M+1][2];
			
			line = in.readLine();
			i = 1; j = 1;
			for (int m = 0; m < M; m++) {
				i += dir[line.charAt(m*2) - '0'][0];
				j += dir[line.charAt(m*2) - '0'][1];
				move1[m+1][0] = i;
				move1[m+1][1] = i;
			}
			
			line = in.readLine();
			i = 10; j = 10;
			for (int m = 0; m < M; m++) {
				i += dir[line.charAt(m*2) - '0'][0];
				j += dir[line.charAt(m*2) - '0'][1];
				move2[m+1][0] = i;
				move2[m+1][1] = i;
			}
			
			tokens = new StringTokenizer(in.readLine());
			for (int a = 0; a < A; a++) {
				chargers.add(new Charger(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken())));
			}
			
			
			
		} // end of test case
	}
	
	
}
