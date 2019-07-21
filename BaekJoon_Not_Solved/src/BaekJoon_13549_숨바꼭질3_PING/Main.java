package BaekJoon_13549_숨바꼭질3_PING;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static final int MAX = 100000;
	static int N, K;	// 0~100000
	static boolean[] visit = new boolean[100001];
	static LinkedList<Integer> q = new LinkedList<>();
	static LinkedList<Integer> qC = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens = new StringTokenizer(in.readLine().trim());
		
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		q.add(N);
//		dfs(N);
		
		int cur;
		while(true) {
			cur = q.poll();
			q.offer(cur);
			while(0<cur && cur <= 5000) {
				cur *= 2;
				qC.offer(cur);
				if(cur > K) {
					break;
				}
			}
			
			
			
		}
	}
	
	
	static void dfs(int cur) {
		System.out.println(cur);
		if(cur >= MAX || cur < 0 || visit[cur]) {
			return ;
		}
		
		if(cur == K) {
			System.out.println("ta-dah!");
			return ;
		}
		
		if(cur > 0) {
			dfs(cur*2);
		}
		dfs(cur+1);
		dfs(cur-1);
	}
	
	static void bfs() {
		
		int cur, nc;
		
		while(!q.isEmpty()) {
			System.out.println(q);
			for (int count = 0, unit = q.size(); count < unit; count++) {
				nc = cur = q.poll();
				if(cur == K) {
					System.out.println(count);
				}
				if(cur > 0) {
					while(nc <= MAX) {
						if(!visit[nc]) {
							q.addFirst(nc);
							unit++;
						}
						nc *= 2;
					}
				}
				if(cur >= 0) {
					if(cur+1 < MAX && !visit[cur+1]) {
						q.offer(cur+1);
					}
					if(cur-1 >= 0 && !visit[cur-1]) {
						q.offer(cur-1);
					}
				}
			}
		}
		
	}
	
	
}