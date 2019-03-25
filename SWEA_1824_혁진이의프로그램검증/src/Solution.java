import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Inst {
	int r, c, d, mem;

	public Inst(int r, int c, int mem, int d) {
		this.r = r;
		this.c = c;
		this.d = d;
		this.mem = mem;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String ds = "";
		if (d == 0) {
			ds = "RIGHT";
		} else if (d == 1) {
			ds = "LEFT";
		} else if (d == 3) {
			ds = "UP";
		} else if (d == 4) {
			ds = "DOWN";
		}
		return "(" + r + " , " + c + ") : " + mem + " / " + ds;
	}
}

public class Solution {
	static final int RIGHT = 0, LEFT = 1, UP = 2, DOWN = 3;

	static int R, C;
	static int[][] map;
	static boolean[][][][] visit;
	static Queue<Inst> go = new LinkedList<>();
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());
		StringTokenizer tokens;
		String line;

		for (int tc = 1; tc <= T; tc++) {
			boolean yes = false;
			go.clear();
			tokens = new StringTokenizer(in.readLine());
			R = Integer.parseInt(tokens.nextToken()); //  (2 ≤ R, C ≤ 20) 
			C = Integer.parseInt(tokens.nextToken());
			map = new int[R][C];
			visit = new boolean[4][16][R][C];
			/* 방향, 메모리
			 */

			for (int r = 0; r < R; r++) {
				line = in.readLine().trim();
				for (int c = 0; c < C; c++) {
					map[r][c] = line.charAt(c);
				}
			}

			go.offer(new Inst(0, 0, 0, RIGHT));
			visit[LEFT][0][0][0] = true;

			Inst cur;
			int nr, nc, nd, nm;
			while (!go.isEmpty()) {
				cur = go.poll();

//				System.out.println(cur);

				switch (map[cur.r][cur.c]) {
				case '<':
					nc = cur.c - 1;
					if (nc < 0) {
						nc = C - 1;
					}
					if (!visit[LEFT][cur.mem][cur.r][nc]) {
						visit[LEFT][cur.mem][cur.r][nc] = true;
						go.offer(new Inst(cur.r, nc, cur.mem, LEFT));
					}
					break;
				case '>':
					nc = cur.c + 1;
					if (nc >= C) {
						nc = 0;
					}
					if (!visit[RIGHT][cur.mem][cur.r][nc]) {
						visit[RIGHT][cur.mem][cur.r][nc] = true;
						go.offer(new Inst(cur.r, nc, cur.mem, RIGHT));
					}
					break;
				case '^':
					nr = cur.r - 1;
					if (nr < 0) {
						nr = R - 1;
					}
					if (!visit[UP][cur.mem][nr][cur.c]) {
						visit[UP][cur.mem][nr][cur.c] = true;
						go.offer(new Inst(nr, cur.c, cur.mem, UP));
					}
					break;
				case 'v':
					nr = cur.r + 1;
					if (nr >= R) {
						nr = 0;
					}
					if (!visit[DOWN][cur.mem][nr][cur.c]) {
						visit[DOWN][cur.mem][nr][cur.c] = true;
						go.offer(new Inst(nr, cur.c, cur.mem, DOWN));
					}
					break;
				case '_':
					if (cur.mem == 0) {
						nd = RIGHT;
					} else {
						nd = LEFT;
					}

					nc = cur.c + dir[nd][1];
					if (nc >= C) {
						nc = 0;
					}
					if (nc < 0) {
						nc = C - 1;
					}

					if (!visit[nd][cur.mem][cur.r][nc]) {
						visit[nd][cur.mem][cur.r][nc] = true;
						go.offer(new Inst(cur.r, nc, cur.mem, nd));
					}
					break;
				case '|':
					if (cur.mem == 0) {
						nd = DOWN;
					} else {
						nd = UP;
					}

					nr = cur.r + dir[nd][0];
					if (nr >= R) {
						nr = 0;
					}
					if (nr < 0) {
						nr = R - 1;
					}

					if (!visit[nd][cur.mem][nr][cur.c]) {
						visit[nd][cur.mem][nr][cur.c] = true;
						go.offer(new Inst(nr, cur.c, cur.mem, nd));
					}
					break;
				case '?':
					for (nd = 0; nd < dir.length; nd++) {
						nr = cur.r + dir[nd][0];
						nc = cur.c + dir[nd][1];

						if (nr >= R) {
							nr = 0;
						}
						if (nr < 0) {
							nr = R - 1;
						}
						if (nc >= C) {
							nc = 0;
						}
						if (nc < 0) {
							nc = C - 1;
						}
						if (!visit[nd][cur.mem][nr][nc]) {
							visit[nd][cur.mem][nr][nc] = true;
							go.offer(new Inst(nr, nc, cur.mem, nd));
						}
					}
					break;
				case '.':
					nr = cur.r + dir[cur.d][0];
					nc = cur.c + dir[cur.d][1];
					if (nr >= R) {
						nr = 0;
					}
					if (nr < 0) {
						nr = R - 1;
					}
					if (nc >= C) {
						nc = 0;
					}
					if (nc < 0) {
						nc = C - 1;
					}
					if (!visit[cur.d][cur.mem][nr][nc]) {
						visit[cur.d][cur.mem][nr][nc] = true;
						go.offer(new Inst(nr, nc, cur.mem, cur.d));
					}
					break;
				case '+':
					nr = cur.r + dir[cur.d][0];
					nc = cur.c + dir[cur.d][1];
					nm = cur.mem + 1;
					if (nm > 15) {
						nm = 0;
					}
					if (nr >= R) {
						nr = 0;
					}
					if (nr < 0) {
						nr = R - 1;
					}
					if (nc >= C) {
						nc = 0;
					}
					if (nc < 0) {
						nc = C - 1;
					}
					if (!visit[cur.d][nm][nr][nc]) {
						visit[cur.d][nm][nr][nc] = true;
						go.offer(new Inst(nr, nc, nm, cur.d));
					}
					break;
				case '-':
					nr = cur.r + dir[cur.d][0];
					nc = cur.c + dir[cur.d][1];
					nm = cur.mem - 1;
					if (nm < 0) {
						nm = 15;
					}
					if (nr >= R) {
						nr = 0;
					}
					if (nr < 0) {
						nr = R - 1;
					}
					if (nc >= C) {
						nc = 0;
					}
					if (nc < 0) {
						nc = C - 1;
					}
					if (!visit[cur.d][nm][nr][nc]) {
						visit[cur.d][nm][nr][nc] = true;
						go.offer(new Inst(nr, nc, nm, cur.d));
					}
					break;
				case '@':
					yes = true;
					break;
				default:
					nr = cur.r + dir[cur.d][0];
					nc = cur.c + dir[cur.d][1];
					nm = map[cur.r][cur.c] - '0';
					if (nr >= R) {
						nr = 0;
					}
					if (nr < 0) {
						nr = R - 1;
					}
					if (nc >= C) {
						nc = 0;
					}
					if (nc < 0) {
						nc = C - 1;
					}
					if (!visit[cur.d][nm][nr][nc]) {
						visit[cur.d][nm][nr][nc] = true;
						go.offer(new Inst(nr, nc, nm, cur.d));
					}
				}

				if (yes) {
					break;
				}

			}

			if (yes) {
				System.out.println("#" + tc + " YES");
			} else {
				System.out.println("#" + tc + " NO");
			}

		}

	}
}
