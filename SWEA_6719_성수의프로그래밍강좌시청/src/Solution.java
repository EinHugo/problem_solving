import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer tokens = null;
		int N, K;
		List<Integer> lecture;
		for (int testCase = 1; testCase <= T; testCase++) {
			double grade = 0;

			tokens = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
			lecture = new ArrayList<Integer>();

			tokens = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				lecture.add(Integer.parseInt(tokens.nextToken()));
			}

			Collections.sort(lecture, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2 - o1;
				}
			});

			for (int i = K - 1; i >= 0; i--) {
				grade = (grade + lecture.get(i)) / 2.0;
//				System.out.print(grade + " ");

			}

			System.out.println("#" + testCase + " " + grade);
		}
	}
}
