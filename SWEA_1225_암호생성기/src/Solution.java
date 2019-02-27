import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = null;
		StringTokenizer tokens = null;
		Queue<Integer> password = null;

		for (int i = 1; i <= 10; i++) {
			int testCase = Integer.parseInt(br.readLine());

			password = new LinkedList<>();
			answer = new StringBuilder().append('#').append(testCase);

			tokens = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 8; j++) {
				password.add(Integer.parseInt(tokens.nextToken()));
			}

			int now = 0;
			boolean isEnd = false;
			while (!isEnd) {
				for (int step = 1; step < 6; step++) {
					now = password.remove() - step;
					password.add( ( now>0 ? now : 0) );
					if (now <= 0) {
						isEnd = true;
						break;
					}
				}
			}

			
			while(!password.isEmpty()) {
				answer.append(' ').append(password.remove());
			}

			System.out.println(answer);
		}
	}
}
