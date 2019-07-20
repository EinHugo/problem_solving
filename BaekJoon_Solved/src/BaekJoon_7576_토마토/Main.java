package BaekJoon_7576_토마토;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

class Tomato {
	int m, n, day;

	public Tomato(int m, int n, int day) {
		this.m = m;
		this.n = n;
		this.day = day;
	}
}

public class Main {
	static int M, N;
	static int[][] tomatoes;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static final int dirLeng = dir.length;

	static Tomato curTom;
	static int max = 0;

	static LinkedList<Tomato> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5.txt"));
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt(); // 2~100
		N = sc.nextInt(); // 2~100
		sc.nextLine();
		tomatoes = new int[N][M];
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				tomatoes[n][m] = sc.nextInt();
				if (tomatoes[n][m] == 1) {
					queue.add(new Tomato(m, n, 0));
				}
			}
			sc.nextLine();
		}

		int nm, nn;
		while (!queue.isEmpty()) {
			curTom = queue.getFirst();
			if (max < curTom.day) {
				max = curTom.day;
			}
			for (int i = 0; i < dirLeng; i++) {
				nm = curTom.m + dir[i][0];
				nn = curTom.n + dir[i][1];
				if (nm >= 0 && nm < M && nn >= 0 && nn < N) {
					if (tomatoes[nn][nm] == 0) {
						tomatoes[nn][nm] = 1;
						queue.add(new Tomato(nm, nn, max + 1));
					}
				}
			}
			queue.removeFirst();
		}

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (tomatoes[n][m] == 0) {
					max = -1;
					break;
				}
			}
		}
		System.out.println(max);

	}

}
