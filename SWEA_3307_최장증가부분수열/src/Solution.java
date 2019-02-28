import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[] numbers;
	static int[] maxOnes;
	static int max;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());
		StringTokenizer tokens = null;
		for (int testCase = 1; testCase <= T; testCase++) {

			N = Integer.parseInt(in.readLine());
			tokens = new StringTokenizer(in.readLine());

			numbers = new int[N];
			maxOnes = new int[N];
			maxOnes[0] = 1;
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(tokens.nextToken());
			}

			max = 0;
			
			for (int idx = 1; idx < N; idx++) {
				int localMax = 1;
				for (int j = idx-1; j >= 0; j--) {
					if(numbers[j] < numbers[idx]) {
						localMax = Math.max(localMax, maxOnes[j] + 1);
//						System.out.println(localMax);
					}
				}
				maxOnes[idx] = localMax;
				max = Math.max(max, maxOnes[idx]);
//				System.out.print(maxOnes[idx] + " ");
			}
			
			System.out.println("#" + testCase + " " + max);

		}
	}

	static void dfs(int idx, int cnt, int pre) {
		if (idx == N) {
			max = Math.max(max, cnt);
			return;
		}

		if (numbers[idx] > pre) {
			dfs(idx + 1, cnt + 1, numbers[idx]);
		}
		dfs(idx + 1, cnt, pre);
	}
}
