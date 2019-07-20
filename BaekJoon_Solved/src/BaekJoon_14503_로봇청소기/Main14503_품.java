package BaekJoon_14503_로봇청소기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BAEKJOON #14503. 로봇 청소기
class Cleaner {
	int dir, i, j, count;

	private Cleaner() {
		this.i = 0;
		this.j = 0;
		this.dir = 0;
		this.count = 0;
	}

	static public Cleaner getInstance() {
		return lazyHolder.INSTANCE;
	}

	static class lazyHolder {
		static final private Cleaner INSTANCE = new Cleaner();
	}

	public void setCleaner(int i, int j, int dir) {
		this.i = i;
		this.j = j;
		this.dir = dir;
	}
}

public class Main14503_품 {

	static int[][] room;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // * d가 0 = 북쪽, 1 = 동쪽, 2 = 남쪽, 3 = 서쪽을 바라보고 있는
																		// 것이다.

	public static void makeClean(Cleaner c) {
		if (room[c.i][c.j] == 0) {
			room[c.i][c.j] = 2;
			c.count++;

		}
	}

	public static void rotation(Cleaner c, int rotation) {
		for (int i = 0; i < rotation; i++) {
			switch (c.dir) {
			case 0:
				c.dir = 3;
				break;
			case 1:
			case 2:
			case 3:
				c.dir--;
				break;
			default:
				System.out.println("잘못된 방향");
				break;
			}
		}
	}

	public static void run(Cleaner c) { // true -> 1 | false -> 2.1
		makeClean(c); // (#1) 현위치 청소

		if (adjChecker(c)) { // 주위에 청소하지 않은 공간이 존재하는 경우
			rotation(c, 1); // (#2.1) 왼쪽으로 회전 1회
			int nextI = c.i + dir[c.dir][0];
			int nextJ = c.j + dir[c.dir][1];
			if (room[nextI][nextJ] == 0) { // 왼쪽자리 청소 안함 -> 1
				c.i = nextI;
				c.j = nextJ;
				run(c);
			} else { // (#2.2) 왼쪽자리 청소했음 -> 2.1
				run(c);
			}
		} else { // 주위 다 청소함 -> 2.3, 2.4
			goBackward(c);
		}
	}

	public static boolean adjChecker(Cleaner c) {
		int nextI, nextJ;
		for (int i = 0; i < 4; i++) {
			nextI = c.i + dir[i][0];
			nextJ = c.j + dir[i][1];
			if (room[nextI][nextJ] == 0) { // 주위에 갈 곳 있음 -> 2.1
				return true;
			}
		}
		return false; // 주위에 갈 곳 없음 -> 2.3
	}

	public static void goBackward(Cleaner c) {
		rotation(c, 2); // 뒤쪽으로 회전
		int nextI = c.i + dir[c.dir][0];
		int nextJ = c.j + dir[c.dir][1];
		if (room[nextI][nextJ] == 1) { // (#2.4) 뒤가 벽이라면 작동을 멈춤
			return;
		} else { // (#2.3) 후진하고 2번 가기
			c.i = nextI;
			c.j = nextJ;
			rotation(c, 2);
			run(c);
		}

	}

	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("res/input14503_1.txt")); // 1
//		System.setIn(new FileInputStream("res/input14503_2.txt"));		// 57
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().trim();
		StringTokenizer tokens = new StringTokenizer(line);
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		room = new int[N][M];

		line = br.readLine().trim();
		tokens = new StringTokenizer(line);
		int r = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		int d = Integer.parseInt(tokens.nextToken());
		Cleaner cleaner = Cleaner.getInstance();
		cleaner.setCleaner(r, c, d);

		for (int i = 0; i < N; i++) {
			line = br.readLine().trim();
			tokens = new StringTokenizer(line);
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}

		run(cleaner);

		System.out.println(cleaner.count);
	}
}
