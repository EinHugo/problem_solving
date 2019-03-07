import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int M, N, L;
	static TreeSet<Integer> shootPoint = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tokens = new StringTokenizer(in.readLine());

		M = Integer.parseInt(tokens.nextToken()); // 1~100,000
		N = Integer.parseInt(tokens.nextToken()); // 1~100,000
		L = Integer.parseInt(tokens.nextToken()); // 1~1,000,000,000

		tokens = new StringTokenizer(in.readLine());
		for (int i = 0; i < M; i++) {
			shootPoint.add(Integer.parseInt(tokens.nextToken()));
		}
		
		int x, y;
		int lowest, highest, low, high;
		lowest = shootPoint.first();
		highest = shootPoint.last();
		int count = 0;
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(in.readLine());
			x = Integer.parseInt(tokens.nextToken());
			y = Integer.parseInt(tokens.nextToken());

			if (lowest < x && x < highest) {
				low = shootPoint.floor(x);
				high = shootPoint.ceiling(x);
				if (low >= 0 && x - low + y <= L) {
					count++;
				} else if (high >= 0 && high - x + y <= L) {
					count++;
				}
			} else if (x <= lowest) {
				high = shootPoint.ceiling(x);
				if (high >= 0 && high - x + y <= L) {
					count++;
					continue;
				}
			} else {
				low = shootPoint.floor(x);
				if (low >= 0 && x - low + y <= L) {
					count++;
					continue;
				}
			}

		}
		System.out.println(count);

	}
}
