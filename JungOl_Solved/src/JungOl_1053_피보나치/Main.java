package JungOl_1053_피보나치;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

	static int[][] unit = { { 1, 1 }, { 1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String input;
		long target;

		while (true) {
			input = in.readLine();
			if (input == null) {
				break;
			}
			target = Long.parseLong(input);

			int[][] answer = divide(target);
			if (target < 0) {
				return;
			}

			System.out.println(answer[0][1]);
		}

	}

	static int[][] divide(long t) {
		if (t == 1) {
			return unit;
		}

		int[][] localResult = divide(t / 2);

		if (t % 2 == 0) {
			return calc(localResult, localResult);
		} else {
			return calc(calc(localResult, localResult), unit);
		}

	}

	static int[][] calc(int[][] u1, int[][] u2) {
		return new int[][] {
			{ (u1[0][0] * u2[0][0] + u1[0][1] * u2[1][0]) % 10000,
				(u1[0][0] * u2[0][1] + u1[0][1] * u2[1][1]) % 10000 },
		{ (u1[1][0] * u2[0][0] + u1[1][1] * u2[1][0]) % 10000,
				(u1[1][0] * u2[0][1] + u1[1][1] * u2[1][1]) % 10000 } };
	}
}
