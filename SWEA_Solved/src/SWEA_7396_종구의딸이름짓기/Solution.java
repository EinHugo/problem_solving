package SWEA_7396_종구의딸이름짓기;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	// requirements
	static int N, M;
	static int[][] map;

	// for input
	static StringTokenizer tokens;
	static String line;

	// process
	static final int MUL = 10000;
	static final int[][] dir = { { 1, 0 }, { 0, 1 } };
	static boolean[][] visited;
	static Queue<Integer> q = new LinkedList<>();
	static Stack<Integer> maxStack = new Stack<>();
	static int cur, curI, curJ, max, nextI, nextJ;

	// for output
	static StringBuilder answer;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/s_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			answer = new StringBuilder().append('#').append(tc).append(' ');
			q.clear();
			maxStack.clear();

			tokens = new StringTokenizer(in.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				line = in.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = line.charAt(j);
				}
			}

			q.offer(0);
			visited[0][0] = true;

			while (!q.isEmpty()) {
				for (int step = 0, size = q.size(); step < size; step++) {
					cur = q.poll();
					curI = cur / MUL;
					curJ = cur % MUL;
					if (maxStack.isEmpty()) {
						max = map[curI][curJ];
						maxStack.push(cur);
					} else if (map[curI][curJ] < max && map[curI][curJ] >= 'a') {
						maxStack.clear();

						max = map[curI][curJ];
						maxStack.push(cur);
					} else if (map[curI][curJ] == max) {
						maxStack.push(cur);
					}
				}
				answer.append((char) max);


				while (!maxStack.isEmpty()) {
					cur = maxStack.pop();
					curI = cur / MUL;
					curJ = cur % MUL;

					for (int i = 0; i < dir.length; i++) {
						nextI = curI + dir[i][0];
						nextJ = curJ + dir[i][1];

						if (nextI < N && nextJ < M && !visited[nextI][nextJ]) {
							q.offer(nextI * MUL + nextJ);
							visited[nextI][nextJ] = true;
						}
					}
				}

			}

			System.out.println(answer);

		}

	}
}
