package BaekJoon_2493_탑;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		String line = br.readLine().trim();
		StringTokenizer tokens = new StringTokenizer(line);

		Stack<Integer> towers = new Stack<>();
		Stack<Integer> index = new Stack<>();
		StringBuilder answer = new StringBuilder();
		int preTower, tower, towerIndex;

		for (int i = 1; i <= N; i++) {
			tower = Integer.parseInt(tokens.nextToken());

			while (true) {
				if (towers.isEmpty()) {
					answer.append("0 ");
					break;
				} else {
					preTower = towers.pop();
					towerIndex = index.pop();
					if (preTower >= tower) {
						answer.append(towerIndex + " ");
						towers.push(preTower);
						index.push(towerIndex);
						break;
					}
				}

			}

			towers.push(tower);
			index.push(i);
		}
		System.out.println(answer);

	}
}