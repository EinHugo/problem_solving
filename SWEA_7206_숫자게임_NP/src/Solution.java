import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Solution {

	static int n[];
	static int N, nSize;
	static int max;
	static int[] ndivide = { 1, 10, 100, 1000, 10000};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sampleinput.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());

		for (int testCase = 1; testCase <= T; testCase++) {
			max = 0;

			N = Integer.parseInt(in.readLine()); // input N as a Integer

			//			char[] ch = in.readLine().trim().toCharArray();
			//			nSize = ch.length;
			//			n = new int[nSize];
			//			
			//			for (int i = 0; i < nSize; i++) {		// set N to integer
			//				n[i] = ch[i] - '0'; 
			//				System.out.print(n[i] + " ");
			//			}

			int cnt = 0;
			getSize();
			while (nSize != 1) {
				N = divide(N, 0);
				getSize();
				cnt++;
				System.out.println(N);
			}

			System.out.println("#" + testCase + " " + cnt);
		}

	}

	static int divide(int copyN, int idx) {
		if (idx == nSize) {
			//			System.out.println("끝 : " + copyN);
			if (copyN == N) {
				return 0;
			}
			return copyN;
		}
		// 현재 시점에서 분리해서 넣는 것과 분리하지 않고 넣는 것 중 최대값
		return Math.max((copyN % ndivide[idx]) * divide(copyN / ndivide[idx], idx + 1), divide(copyN, idx + 1));

		//		return max;
	}

	static void getSize() {
		int div = 1;
		for (int i = 1; i < 6; i++) {
			div *= 10;
			if (N / div == 0) {
				nSize = i;
				return;
			}
		}
	}
}
