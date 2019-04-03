import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	/**
	 * N : vertical line				2 ≤ N ≤ 10
	 * M : horizontal line				0 ≤ M ≤ (N-1)×H
	 * H : possible horizontal line		1 ≤ H ≤ 30
	 */
	static int N, M, H;
	static boolean[][] map;
	static boolean[][] isImpossible;
	static int[] total;
	static int[] leftRight = {-1, 1};
	
	static int a,b;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input4.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tokens = new StringTokenizer(in.readLine().trim());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		H = Integer.parseInt(tokens.nextToken());
		map = new boolean[H+1][N+1];			// [1 ~ H] [1 ~ N-1] : for padding. 
		isImpossible = new boolean[H+1][N+1]; 	// for check the promise;
		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(in.readLine());
			a = Integer.parseInt(tokens.nextToken());
			b = Integer.parseInt(tokens.nextToken());
			map[a][b] = true;

			isImpossible[a][b] = true;
			for (int dir = 0; dir < leftRight.length; dir++) {
				isImpossible[a][b+leftRight[dir]] = true;
			}
			
		}
		
		print();
		
		
		
	}
	static void print() {
		System.out.println("===================");
		for (int i = 0; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				int a = !map[i][j]? 0 : 1;
				System.out.print(a + " ");
			}
			System.out.println();
		}
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		for (int i = 0; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				int a = !isImpossible[i][j] ? 0 : 1;
				System.out.print(a + " ");
			}
			System.out.println();
		}
		System.out.println("===================");
	}
}