package JungOl_1462_보물섬;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


// http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=734&sca=3040
public class Main {

	static int N;
	static Map<Integer, Integer> tempMap = new HashMap<>();
	static int min, max;
	static int count = 0;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine().trim());
		StringTokenizer tokens = null;
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(in.readLine());
			min = Integer.parseInt(tokens.nextToken());
			max = Integer.parseInt(tokens.nextToken());

			for (int j = min; j <= max; j++) {
				if (tempMap.containsKey(j)) {
					tempMap.put(j, tempMap.get(j) + 1);
				} else {
					tempMap.put(j, 1);
				}
				if(count < tempMap.get(j)) {
					count = tempMap.get(j);
				}
			}
		}
		System.out.println(count);

	}
}
