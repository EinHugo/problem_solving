package JungOl_1840_치즈_PING;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static boolean[][] visit;
	static int[][] arr;
	static int x, y, cnt, time;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static Queue<int[]> qq = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");

		x = Integer.parseInt(temp[0]);
		y = Integer.parseInt(temp[1]);

		arr = new int[x][y];

		for (int i = 0; i < x; i++) {
			temp = in.readLine().split(" ");
			for (int j = 0; j < y; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}

		visit = new boolean[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (i == 0 || i == x - 1 || j == 0 || j == y - 1) { // 외곽에서만~
					bfs(i, j);
				}
			}
		}
		// qq에 외곽 위치 넣었음
		while (!qq.isEmpty()) {
			int[] item = qq.poll();
			for (int i = 0; i < 4; i++) {

			}
		}

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void bfs(int i, int j) {
		// TODO Auto-generated method stub
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { i, j });
		int nx, ny;
		while (!q.isEmpty()) {
			int[] item = q.poll();
			visit[item[0]][item[1]] = true;
			arr[item[0]][item[1]] = 2;
			for (int k = 0; k < 4; k++) {
				nx = item[0] + dir[k][0];
				ny = item[1] + dir[k][1];
				if (nx >= 0 && ny >= 0 && nx < x && ny < y) { // 범위안에 있을때
					if (arr[nx][ny] == 1) {
						qq.add(new int[] { nx, ny });
					}
					if (!visit[nx][ny] && (arr[nx][ny] == 0 || arr[nx][ny] == 2)) { // 가능
						q.add(new int[] { nx, ny });
					}
				}
			}
		}
	}
}