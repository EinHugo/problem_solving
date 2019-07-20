package BaekJoon_7569_토마토_초;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

class Tomato {
	int h, m, n, day;

	public Tomato(int h, int m, int n, int day) {
		this.h = h;
		this.m = m;
		this.n = n;
		this.day = day;
	}
}

public class Main {
	static int M, N, H;
	static int[][][] tomatoes;
	static int[][] dir = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };
	static final int dirLeng = dir.length;

	static Tomato curTom;
	static int max = 0;

	static LinkedList<Tomato> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3.txt"));
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt(); // 2~100
		N = sc.nextInt(); // 2~100
		H = sc.nextInt(); // 1~100
		sc.nextLine();
		tomatoes = new int[H][N][M];
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					tomatoes[h][n][m] = sc.nextInt();
					if (tomatoes[h][n][m] == 1) {
						queue.add(new Tomato(h, m, n, 0));
					}
				}
				sc.nextLine();
			}
		}

		int nh, nm, nn;
		while (!queue.isEmpty()) {
			curTom = queue.getFirst();
			if (max < curTom.day) {
				max = curTom.day;
			}
			for (int i = 0; i < dirLeng; i++) {
				nh = curTom.h + dir[i][0];
				nm = curTom.m + dir[i][1];
				nn = curTom.n + dir[i][2];
				if (nh >= 0 && nh < H && nm >= 0 && nm < M && nn >= 0 && nn < N) {
					if (tomatoes[nh][nn][nm] == 0) {
						tomatoes[nh][nn][nm] = 1;
						queue.add(new Tomato(nh, nm, nn, max + 1));
					}
				}
			}
			queue.removeFirst();
		}

		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if(tomatoes[h][n][m] == 0) {
						max = -1;
						break;
					}
				}
			}
		}
		System.out.println(max);

	}
	
}
