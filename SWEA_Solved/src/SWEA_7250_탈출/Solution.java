package SWEA_7250_탈출;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Unit {
	int y, x, k;

	public Unit(int y, int x, int k) {
		this.y = y;
		this.x = x;
		this.k = k;
	}

	public Unit(int y, int x) {
		this.y = y;
		this.x = x;
		this.k = 0;
	}
}

public class Solution {

	static final int F = 'F', A = 'A', W = 'W', X = 'X', V = 'V', S = 'S', E = 'E';

	static int N, M, K;
	static int[][] map;
	static boolean[][] fireVisited;
	static int[][] scatVisited;
	static boolean[][] villanVisited;
	static int[] end;

	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static final int dirLeng = dir.length;

	static LinkedList<Unit> fire = new LinkedList<>();
	static LinkedList<Unit> scat = new LinkedList<>();
	static LinkedList<Unit> villan = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());
		StringTokenizer tokens;
		String line;

		for (int tc = 1; tc <= T; tc++) {
			tokens = new StringTokenizer(in.readLine().trim());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken()); // (3 <= N,M <= 1000)
			K = Integer.parseInt(tokens.nextToken()); // (1 <= K <= 10)
			map = new int[N][M];
			end = new int[2];
			fireVisited = new boolean[N][M];
			scatVisited = new int[N][M];
			villanVisited = new boolean[N][M];
			fire.clear();
			scat.clear();
			villan.clear();
			// get inputs

			for (int i = 0; i < N; i++) {
				line = in.readLine().trim();
				for (int j = 0; j < M; j++) {
					map[i][j] = line.charAt(j);
					switch (map[i][j]) {
					case S:
						scat.offer(new Unit(i, j));
						scatVisited[i][j] = -1;
						break;
					case V:
						villan.offer(new Unit(i, j));
						villanVisited[i][j] = true;
						break;
					case F:
						fire.offer(new Unit(i, j));
						fireVisited[i][j] = true;
						break;
					case E:
						end[0] = i;
						end[1] = j;
						break;
					default:
						break;
					}
				}
			}

			int answer, cnt = 0;
			do {
				answer = goOut();
				cnt++;
			} while (answer == -2);
			if(answer == 1) {
				answer = cnt;
			}
			
			
			System.out.println("#" + tc + " " + answer);
		}
	}

	static int goOut() {
		int length;
		Unit curUnit;
		int ny, nx;
		
		// let's go fire
		length = fire.size();
		for (int idx = 0; idx < length; idx++) {
			curUnit = fire.poll();
			for (int i = 0; i < dirLeng; i++) {
				ny = curUnit.y + dir[i][0];
				nx = curUnit.x + dir[i][1];
				if ((ny >= 0 && nx >= 0 && ny < N && nx < M) && !fireVisited[ny][nx] && map[ny][nx] == A) {
					fire.offer(new Unit(ny, nx));
					fireVisited[ny][nx] = true;
				}
			}
		}

		// let's go villan
		length = villan.size();
		for (int idx = 0; idx < length; idx++) {
			curUnit = villan.poll();
			for (int i = 0; i < dirLeng; i++) {
				ny = curUnit.y + dir[i][0];
				nx = curUnit.x + dir[i][1];
				if ((ny >= 0 && nx >= 0 && ny < N && nx < M) && !villanVisited[ny][nx] && map[ny][nx] == A) {
					if(ny == end[0] && nx == end[1]) {
						return -1;
					}
					villan.offer(new Unit(ny, nx));
					villanVisited[ny][nx] = true;
				}
			}
		}

		// let's go scat
		length = scat.size();
		for (int idx = 0; idx < length; idx++) {
			curUnit = scat.poll();
			for (int i = 0; i < dirLeng; i++) {
				ny = curUnit.y + dir[i][0];
				nx = curUnit.x + dir[i][1];
				if ((ny >= 0 && nx >= 0 && ny < N && nx < M) && scatVisited[ny][nx] >= 0 && !fireVisited[ny][nx] && map[ny][nx] != X) {
					if(ny == end[0] && nx == end[1]) {
						return 1;
					}
					if(map[ny][nx] == W && curUnit.k < K && (scatVisited[ny][nx] == 0 || curUnit.k + 1 < scatVisited[ny][nx])) {
						scat.offer(new Unit(ny, nx, curUnit.k + 1));
						scatVisited[ny][nx] = curUnit.k+1;
					} else {
						if(map[ny][nx] == A) {
							scat.offer(new Unit(ny, nx, 0));
							scatVisited[ny][nx] = -1;
						}
					}
				}
			}
		}
		
		if (scat.isEmpty()) {
			return -1;
		}
		
		return -2;
	}

}
