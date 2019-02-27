import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	static Map<String, Integer> codeMap;

	public static void main(String[] args) throws Exception {
		codeMap = new HashMap<>();
		codeMap.put("0001101", 0);
		codeMap.put("0011001", 1);
		codeMap.put("0010011", 2);
		codeMap.put("0111101", 3);
		codeMap.put("0100011", 4);
		codeMap.put("0110001", 5);
		codeMap.put("0101111", 6);
		codeMap.put("0111011", 7);
		codeMap.put("0110111", 8);
		codeMap.put("0001011", 9);

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		boolean isFound = false;

		int T = Integer.parseInt(in.readLine().trim());
		StringTokenizer tokens = null;
		for (int testCase = 1; testCase <= T; testCase++) {
			tokens = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(tokens.nextToken()); // height of array
			int M = Integer.parseInt(tokens.nextToken()); // width of array

			isFound = false;

			for (int i = 0; i < N; i++) {
				String line = in.readLine();
				if (isFound) {
					continue;
				}

				if (!line.contains("1")) {
					continue;
				}

				isFound = true;

				int index = 0;
				for (int j = M - 1; j > 5; j--) {
					if (line.charAt(j) == '0') {
						continue;
					} else {
						index = j;
						break;
					}
				}

				int[] code = new int[9];
				for (int j = 8; j >= 1; j--) {
					String subLine = line.substring(index - 6, index + 1);

					code[j] = codeMap.get(subLine);
					index -= 7;
				}

				int even = 0, odd = 0, sum = 0;

				for (int j = 1; j <= 8; j++) {
					if (j % 2 == 1) {
						odd += code[j];
					} else {
						even += code[j];
					}
				}
				sum = odd * 3 + even;

				answer = (sum % 10 == 0) ? (odd + even) : 0;

			}

			System.out.println("#" + testCase + " " + answer);
		}

	}
}
