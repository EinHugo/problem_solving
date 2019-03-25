import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
	
	static final int INF = Integer.MAX_VALUE >> 1;
	
	static int N, M;
	static int[][] map;
	static boolean[] visit;
	static int[] cost;
	static String[] path;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer tokens = new StringTokenizer(in.readLine().trim());
		N = Integer.parseInt(tokens.nextToken()); 		// 3 ~ 100
		M = Integer.parseInt(tokens.nextToken());		// 1 ~ N
		map = new int[N+1][N+1];
		cost = new int[N+1];
		visit = new boolean[N+1];
		path = new String[N+1];
		
		for (int i = 1; i <= N; i++) {
			cost[i] = INF;
			tokens = new StringTokenizer(in.readLine().trim());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		for (int i = 1; i <= N ; i++) {
			cost[i] = map[1][i];
			path[i] = i + " ";
		}
		
		for (int i = 1; i <= N; i++) {
			int localMin = INF + 1;
			int index = -1;
			for (int j = 1; j <= N; j++) {
				if(!visit[j] && localMin > cost[j]) {
					localMin = cost[j];
					index = j;
				}
			}
			visit[index] = true;
			
			for (int j = 1; j <= N; j++) {
				if(map[index][j] != 0 && cost[j] > cost[index] + map[index][j]){
					System.out.println("==========");
					System.out.println(j);
					System.out.println(path[j]);
					path[j] = path[index] + path[j];
					System.out.println(path[j]);
					System.out.println("==========");
                    cost[j] = cost[index] + map[index][j];
				}
			}
			if(index == M) {
				break;
			}
		}
		System.out.println(cost[M]);
		System.out.print("1 ");
		
		HashSet<Character> dupCheck = new HashSet<>();
		for (int i = 0; i < path[M].length(); i++) {
			if(path[M].charAt(i) == ' ') {
				System.out.print(' ');
				continue;
			}
			
			if(dupCheck.contains(path[M].charAt(i))) {
				i++;
				continue;
			}
			
			System.out.print(path[M].charAt(i));
			dupCheck.add(path[M].charAt(i));
		}
		
	}
	
	static void print() {
		System.out.println("#################");
		for (int i = 1; i <= N; i++) {
			System.out.print(cost[i] + " ");
		}
		System.out.println();
		for (int i = 1; i <= N; i++) {
			System.out.print(visit[i] + " ");
		}
		System.out.println();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("#################");
	}
}
