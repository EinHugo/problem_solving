import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Cell {
	int i, j;
	boolean isActive;
	int life, age;

	public Cell(int i, int j, int life) {
		this.i = i;
		this.j = j;
		this.life = life;
		age = 0;
		isActive = false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(isActive) {
			return "(" + i + " , " + j +") :  " + age + " / " + life + "+";
		}
		return "(" + i + " , " + j +") :  " + age + " / " + life + "-";
	}
}

public class Solution {
	
	static final int PADDING = 1100;
	static final int WEIGHT = 1000;
	
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int N, M, K;
	static int answer;
	static LinkedList<Cell> cells = new LinkedList<>();
	static int[][] visit;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());
		StringTokenizer tokens;

		for (int tc = 1; tc <= T; tc++) {
			cells.clear();

			visit = new int[PADDING][PADDING];

			tokens = new StringTokenizer(in.readLine().trim());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());

			int ch;

			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(in.readLine().trim());
				for (int j = 0; j < M; j++) {
					ch = Integer.parseInt(tokens.nextToken());
					if (ch != 0) {
						cells.offer(new Cell(PADDING/2 + i, PADDING/2 + j, ch));
						visit[PADDING/2 + i][PADDING/2 + j] = ch * WEIGHT + 0;
					}
				}
			}

			Cell cur;

			for (int k = 1; k <= K; k++) {

				if (cells.isEmpty()) {		// if it's empty, it means end up
					answer = 0;
					break;
				}

				for (int i = 0, size = cells.size(); i < size; i++) {	// step by step : BFS
					cur = cells.poll();
					if (cur.isActive) {
						if (cur.life == cur.age) {						// active -> breed
							for (int d = 0; d < dir.length; d++) {		// breed to every side
								int ni = cur.i + dir[d][0];
								int nj = cur.j + dir[d][1];
								if (visit[ni][nj] > 0) {				// if already exist that side
									if (visit[ni][nj] % WEIGHT == k && visit[ni][nj] / WEIGHT < cur.life) {	// check weather steal
										Cell remove;
										for (int idx = 0, til = cells.size(); idx < til; idx++) {		// remove!
											remove = cells.get(idx);
											if (remove.i == ni && remove.j == nj) {
//												System.out.println("(" + ni + " , " + nj + ")");
												cells.remove(idx);
												break;
											}
										}
										visit[ni][nj] = cur.life * WEIGHT + k;
										cells.offer(new Cell(ni, nj, cur.life));
									}
								} else {
									visit[ni][nj] = cur.life * WEIGHT + k;
									cells.offer(new Cell(ni, nj, cur.life));
								}
							}
						}
						cur.age--;				// back then.
						if (cur.age > 0) {		// go on while alive
							cells.offer(cur);
						}
					} else {					// if it's not in active state
						cur.age++;
						if (cur.age == cur.life) {		// older and make active
							cur.isActive = true;
						}
						cells.offer(cur);
					}
				}
				
//				System.out.println(cells);
			}
			answer = cells.size();
			System.out.println("#" + tc + " " + answer);

		}

	}
}
