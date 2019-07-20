package BaekJoon_1062_가르침;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main{
	
	static int N;		// # of words. 		1 ~ 50
	static int K;		// # of letters. 	0 ~ 26
	
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		if(K < 5) {
			System.out.println("0");
			return ;
		}
		
		map = new int[N + 1][K + 1];		// [ word ] [ letter count ] ( 0 means total count ) 
		
		String line;
		for (int i = 1; i <= N; i++) {
			line = in.readLine().trim();
			
			for (int j = 0, size = line.length(); j < size; j++) {
				map[i][line.charAt(j) - 'a' + 1]++;
				map[i][0]++;
				map[0][line.charAt(j)]++;
			}
		}
		
		
	}
}