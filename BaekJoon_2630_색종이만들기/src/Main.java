import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int numOfBlue = 0;
	static int numOfWhite = 0;
	static boolean[][] paper;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine().trim());
		paper = new boolean[N + 1][N + 1];
		StringTokenizer tokens = null;
		for (int i = 1; i <= N; i++) {
			tokens = new StringTokenizer(in.readLine().trim(), " ");
			for (int j = 1; j <= N; j++) {
				if (tokens.nextToken().equals("0")) {
					paper[i][j] = false;
				} else {
					paper[i][j] = true;
				}
			}
		}

		getPureColor(1, 1, N);

		System.out.println(numOfWhite);
		System.out.println(numOfBlue);

	}

	static void getPureColor(int lt_X, int lt_Y, int length) {

		if (length == 1) {
			if (paper[lt_X][lt_Y]) {
				numOfBlue++;
			} else {
				numOfWhite++;
			}
			return;
		}

		boolean isBlue = false;
		boolean isWhite = false;

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (paper[lt_X + i][lt_Y + j]) {
					isBlue = true;
				} else {
					isWhite = true;
				}

				if (isBlue && isWhite) {
					length /= 2;
					getPureColor(lt_X, lt_Y, length);
					getPureColor(lt_X + length, lt_Y + length, length);
					getPureColor(lt_X, lt_Y + length, length);
					getPureColor(lt_X + length, lt_Y, length);
					return;
				}
			}
		}

		if (isBlue) {
			numOfBlue++;
		} else {
			numOfWhite++;
		}
	}
}