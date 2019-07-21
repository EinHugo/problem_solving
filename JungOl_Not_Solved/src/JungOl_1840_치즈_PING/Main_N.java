package JungOl_1840_치즈_PING;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_N {

	static int y, x;
	static LinkedList<int[]> cheeze = new LinkedList<>();
	static int[][] map;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static final int dirLeng = dir.length;
	static int ny, nx;
	static int curCount = 0, curHour;

	static boolean isInBoundary() {
		if (ny >= 0 && nx >= 0 && ny < y && nx < x) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(in.readLine());
		y = Integer.parseInt(tokens.nextToken());
		x = Integer.parseInt(tokens.nextToken());
		map = new int[y][x];

		for (int i = 0; i < y; i++) {
			tokens = new StringTokenizer(in.readLine());
			for (int j = 0; j < x; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (map[i][j] == 1) {
					for (int d = 0; d < dirLeng; d++) {
						ny = i + dir[d][0];
						nx = j + dir[d][1];
						if (isInBoundary()) {
							if (map[ny][nx] == 0) {
								cheeze.add(new int[] { i, j, 0 });
								break;
							}
						}
					}
				}
			}
		}

		System.out.println(cheeze.size());

		int[] curCheeze;

		while (!cheeze.isEmpty()) {
			
			curCheeze = cheeze.getFirst();
			curCount++;
			
			if (curHour != curCheeze[2]) {
				System.out.println("curHour " + curHour);
				curHour = curCheeze[2];
				curCount = 0;
				curCount++;
			}
			
			cheeze.removeFirst();
			
			map[curCheeze[0]][curCheeze[1]] = 0;
			for (int d = 0; d < dirLeng; d++) {
				ny = curCheeze[0] + dir[d][0];
				nx = curCheeze[1] + dir[d][1];
				if (isInBoundary()) {
					if (map[ny][nx] == 1) {
						cheeze.addLast(new int[] { ny, nx, curCheeze[2] + 1 });
					}
				}
			}
		}
		System.out.println("############");
		System.out.println(curCount);
		System.out.println(curHour);

	}
}
