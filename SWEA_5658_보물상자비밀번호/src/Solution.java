import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {

	// requirements
	static int N, K; //  (8 ≤ N ≤ 28)
	
	// for input
	static StringTokenizer tokens;
	static String line;
	
	// for process
	static int unit;
	static TreeSet<Integer> set = new TreeSet<>();
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			set.clear();
			
			tokens = new StringTokenizer(in.readLine());
			N = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
			line = in.readLine();
			
			
			for (int i = 0, unit = N/4; i < unit; i++) {
				set.add(Integer.parseInt(line.substring(0+i, unit+i), 16));
				set.add(Integer.parseInt(line.substring(unit+i, (unit*2)+i), 16));
				set.add(Integer.parseInt(line.substring((unit*2)+i, (unit*3)+i), 16));
				set.add(Integer.parseInt(line.substring((unit*3)+i) + line.substring(0, 0+i), 16));
			}
//			System.out.println(set);
			
			for (int i = 1; i < K; i++) {
				set.pollLast();
			}
			
			System.out.println("#" + tc + " " + set.pollLast());
		}
		
	}
	
	
}
