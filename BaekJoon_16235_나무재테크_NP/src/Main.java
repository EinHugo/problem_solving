
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // #16235. 나무 재테크

	public static void winter(int[][] ground, int[][] nutritient) {
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = null;
		String line = null;

		line = br.readLine().trim();
		tokens = new StringTokenizer(line);

		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		
		int[][] ground = new int[N][N];
		
		for (int y = 1; y <= N; y++) {
			line = br.readLine().trim();
			tokens = new StringTokenizer(line);
			for (int x = 1; x <= N; x++) {
				ground[x][y] = Integer.parseInt(tokens.nextToken());
			}
		}
		
	}

}
