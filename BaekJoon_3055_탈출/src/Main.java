import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	// requirements
	static int R, C; // 1 ~ 50
	static final int DOT = '.', WATER = '*', ROCK = 'X', BIEBER = 'D', HEDGEHOG = 'S';

	// for input
	static StringTokenizer tokens;
	static String line;

	// for process
	static int[][] map;
	static int cur, curi, curj, newi, newj, bi, bj;
	static Queue<Integer> waterQ = new LinkedList<>();
	static Queue<Integer> hedgeQ = new LinkedList<>();
	static final int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static boolean survive, die;
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tokens = new StringTokenizer(in.readLine());

		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			line = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == WATER) {
					waterQ.offer(i*100 + j);
				} else if (map[i][j] == HEDGEHOG) {
					hedgeQ.offer(i*100 + j);
				} else if (map[i][j] == BIEBER) {
					bi = i;
					bj = j;
				} 
			}
		}
//		print();
		
		while(!survive && !die) {
			
			flood();
			escape();
			
			ans++;
//			print();
		}
		
		if(die) {
			System.out.println("KAKTUS");
//			System.out.println("impossible");
		} else {
			System.out.println(ans);
		}
		
	}
	
	static void flood() {
		for (int i = 0, size = waterQ.size(); i < size; i++) {
			cur = waterQ.poll();
			curi = cur / 100;
			curj = cur % 100;
			
			for (int d = 0; d < dir.length; d++) {
				newi = curi + dir[d][0];
				newj = curj + dir[d][1];
				if(newi >= 0 && newj >= 0 && newi < R && newj < C && map[newi][newj] != ROCK && map[newi][newj] != WATER && map[newi][newj] != BIEBER) {
					if(newi == bi && newj == bj) {
						die = true;
						return;
					}
					map[newi][newj] = WATER;
					waterQ.offer(newi*100 + newj);
				}
			}
		}
	}
	static void escape() {
		for (int i = 0, size = hedgeQ.size(); i < size; i++) {
			cur = hedgeQ.poll();
			curi = cur / 100;
			curj = cur % 100;
			
			for (int d = 0; d < dir.length; d++) {
				newi = curi + dir[d][0];
				newj = curj + dir[d][1];
				if(newi >= 0 && newj >= 0 && newi < R && newj < C && map[newi][newj] != WATER && map[newi][newj] != ROCK && map[newi][newj] != HEDGEHOG) {
					if(newi == bi && newj == bj) {
						survive = true;
						return;
					}
					map[newi][newj] = HEDGEHOG;
					hedgeQ.offer(newi*100 + newj);
				}
			}
		}
		if(hedgeQ.isEmpty()) {
			die = true;
			return;
		}
	}
	
	static void print() {
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print((char)map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
}