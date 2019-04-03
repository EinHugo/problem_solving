import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	// requirements
	static int N, M;	//  1 ≤ n ≤ 1,000,000, 1 ≤ m ≤ 100,000
	static StringTokenizer tokens;
	
	// for process
	static int[] set = new int[1000001];
	static int command, a, b;
	
	// for output
	static StringBuilder answer;
	
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			answer = new StringBuilder().append('#').append(tc).append(' ');
			
			tokens = new StringTokenizer(in.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			
			for (int i = 0; i < M; i++) {
				tokens = new StringTokenizer(in.readLine());
				command = Integer.parseInt(tokens.nextToken());
				a = Integer.parseInt(tokens.nextToken());
				b = Integer.parseInt(tokens.nextToken());
				switch (command) {
				
				case 0:
					union(a,b);
					break;

				case 1:
					if(findSet(a) == findSet(b)) {
						answer.append('1');
					} else {
						answer.append('0');
					}
					break;
				}
			}
			
			System.out.println(answer);
			Arrays.fill(set, 0);
		}
	}
	
	
	public static int findSet(int node) {
        if(set[node] == 0) {
            return node;
        }
        
        set[node] = findSet(set[node]);    // 대표 노드 찾기
        return set[node];
    }
    
    public static void union(int a,int b) {
        int r1 = findSet(a);
        int r2 = findSet(b);
        
        if(r1 == r2) {        // 합칠 필요 X
            return;
        }
        
        set[r1] = r2;
    }
	
	static int find(int node) {
		while(set[node] != 0) {
			node=set[node];
		}
		return node;
	}
	
}
