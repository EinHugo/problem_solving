import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	static final int MAX = 101;
	
	static int S, N;
	static boolean[][] graph = new boolean[MAX][MAX];
	static LinkedList<Integer> callList = new LinkedList<>();
	static HashSet<Integer> alreadyCalled = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		StringTokenizer tokens;
		
		for (int tc = 1; tc <= T; tc++) {
			callList.clear();
			alreadyCalled.clear();
			
			tokens = new StringTokenizer(in.readLine().trim());
			N = Integer.parseInt(tokens.nextToken());		// length of input data ( 1 ~ 100 )
			S = Integer.parseInt(tokens.nextToken());		// start point
			for (int i = 0; i < MAX; i++) {
				Arrays.fill(graph[i], false);
			}
				
			
			tokens = new StringTokenizer(in.readLine().trim());
			for (int i = 0; i < N/2; i++) {
				graph[Integer.parseInt(tokens.nextToken())][Integer.parseInt(tokens.nextToken())] = true;
			}
			
			callList.offer(S);
			alreadyCalled.add(S);
			
			int max = 0;
			do {
				max = bfs();
			} while (max <= 0);
			

			System.out.println("#" + tc + " " + max);
		}
	}
	
	
	static int bfs() {
		
		int listLeng = callList.size();
		int curCaller;
		int localMax = -1;
		
		for (int i = 0; i < listLeng; i++) {
			curCaller = callList.poll();
			localMax = Math.max(localMax, curCaller);
			for (int callee = 1; callee < MAX; callee++) {
				if(graph[curCaller][callee] && !alreadyCalled.contains(callee)) {
					callList.offer(callee);
					alreadyCalled.add(callee);
				}
			}
		}
		
		if(callList.isEmpty()) {
			return localMax;
		}
		
		return -1;
		
	}
	
	
	static void print() {
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if(graph[i][j]) {
					System.out.print(1 + " ");
				} else {
					System.out.print(0 + " ");
				}
			}
			System.out.println();
		}
	}
}


/*
 * [입력]

그 다음 줄에 입력받는 데이터는 {from, to, from, to, …} 의 순서로 해석되며 
예시의 경우는 {2, 7, 11, 6, 6, 2, 2, 15, 15, 4, 4, 2, 4, 10, 7, 1, 1, 7, 1, 8, 1, 17, 3, 22}와 같다.

그런데 순서에는 상관이 없으므로 다음과 같이 주어진 인풋도 동일한 비상연락망을 나타낸다 
(같은 비상연락망을 표현하는 다양한 인풋이 존재 가능하다).
{1, 17, 3, 22, 1, 8, 1, 7, 7, 1, 2, 7, 2, 15, 15, 4, 6, 2, 11, 6, 4, 10, 4, 2}

다음과 같이 동일한 {from, to}쌍이 여러 번 반복되는 경우도 있으며, 한 번 기록된 경우와 여러 번 기록된 경우의 차이는 없다.

{1, 17, 1, 17, 1, 17, 3, 22, 1, 8, 1, 7, 7, 1, 2, 7, 2, 15, 15, 4, 6, 2, 11, 6, 4, 10, 11, 6, 4, 2}
*/
