import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	static final long WEIGHT = 100000000, FROM = 10000, TO = FROM;

	static int N, M, a, b, c;
	static int[][] map;
	static long curEdge;
	static int curWeight, curNode, answer = 0;
	static TreeSet<Long> bucket = new TreeSet<>();
	static HashSet<Integer> visited = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tokens = new StringTokenizer(in.readLine());

		N = Integer.parseInt(tokens.nextToken()); // 1 ≤ N ≤ 1,000
		M = Integer.parseInt(tokens.nextToken()); // 1 ≤ M ≤ 20,000
		map = new int[N + 1][N + 1];

		for (int line = 0; line < M; line++) {

			tokens = new StringTokenizer(in.readLine());
			a = Integer.parseInt(tokens.nextToken());
			b = Integer.parseInt(tokens.nextToken());
			c = Integer.parseInt(tokens.nextToken());

			if (map[a][b] < c) {
				map[a][b] = c;
				map[b][a] = c;
			}
		}

		collectNodes(1);
		visited.add(1);

		
		for (int cnt = 2; cnt <= N; cnt++) {
			
			curEdge = bucket.pollLast();
			curWeight = (int) (curEdge / WEIGHT);
			curNode = (int) (curEdge % TO);
			
			if(visited.contains(curNode)) {
				cnt--;
				continue;
			}
			
			answer += curWeight;
			
			collectNodes(curNode);
			visited.add((int) curNode);
		}

		System.out.println(answer);

	}
	
	static void collectNodes(int from) {
		for (int j = 1; j <= N; j++) {
			if(map[from][j] != 0) {
				bucket.add(((map[from][j]) * FROM + 1) * TO + j);
				map[from][j] = 0;
				map[j][from] = 0;
			}
		}
	}
	
}
