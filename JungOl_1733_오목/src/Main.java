import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// for input
	static final int size = 19;
	static int[][][] map = new int[5][21][21];	// [0][n][n] for pure input, [n][0][0], [n][20][20] for padding 
	static StringTokenizer tokens;

	// for process
	static final int[][] dir = { { 0, 0 }, { -1, 0 }, { 0, -1 }, { -1, -1 }, { -1, 1 } }; // [0] for padding
	static final int RIGHTUP = 4;
	static int score = 0, answer = 0;

	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("res/input4.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= size; i++) {
			tokens = new StringTokenizer(in.readLine());
			for (int j = 1; j <= size; j++) {
				switch (Integer.parseInt(tokens.nextToken())) {
				case 1:
					map[0][i][j] = 1;
					for (int d = 1; d < dir.length; d++) {
						map[d][i][j] = map[0][i][j];
						if(map[d][ i + dir[d][0] ][ j + dir[d][1] ] > 0) {
							map[d][i][j] += map[d][ i + dir[d][0] ][ j + dir[d][1] ];
						}
						if(map[d][i][j] == 5) {
							score++;
							if(d == RIGHTUP) {
								answer += ( (i) * 100 + (j) );
							} else {
								answer += ( (i + dir[d][0] * 4) * 100 + (j + dir[d][1] * 4) );
							}
						}else if(map[d][i][j] == 6) {
							score--;
							if(d == RIGHTUP) {
								answer -= ( (i + dir[d][0]) * 100 + (j + dir[d][1]) );
							} else {
								answer -= ( (i + dir[d][0] * 5) * 100 + (j + dir[d][1] * 5) );
							}
						}
					}
					break;
				case 2:
					map[0][i][j] = -1;
					for (int d = 1; d < dir.length; d++) {
						map[d][i][j] = map[0][i][j];
						if(map[d][ i + dir[d][0] ][ j + dir[d][1] ] < 0) {
							map[d][i][j] += map[d][ i + dir[d][0] ][ j + dir[d][1] ];
						}
						if(map[d][i][j] == -5) {
							score--;
							if(d == RIGHTUP) {
								answer += ( (i) * 100 + (j) );
							} else {
								answer += ( (i + dir[d][0] * 4) * 100 + (j + dir[d][1] * 4) );
							}
						}else if(map[d][i][j] == -6) {
							score++;
							if(d == RIGHTUP) {
								answer -= ( (i + dir[d][0]) * 100 + (j + dir[d][1]) );
							} else {
								answer -= ( (i + dir[d][0] * 5) * 100 + (j + dir[d][1] * 5) );
							}
						}
					}
					break;
				}
			} // end of for j
		} // end of for i

		if(score > 0) {
			System.out.println("1");
		} else if (score < 0) {
			System.out.println("2");
		} else {
			System.out.println("0");
		}
		if(answer != 0) {
			System.out.println(answer / 100 + " " + answer % 100);
		}
	}
}
