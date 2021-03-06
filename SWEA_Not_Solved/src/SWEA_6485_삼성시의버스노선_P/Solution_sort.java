package SWEA_6485_삼성시의버스노선_P;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;


//  TreeSet을 사용하였기 때문에 중복된 Start point, end point들이 계산이 되지 않는 문제가 발생함.

public class Solution_sort {
	
	static int N; 
	static int[] path;
	static int a,b;
	static StringTokenizer tokens= null;
	static StringBuilder sb  = new StringBuilder();
	static TreeSet<Integer> startP = new TreeSet<>();
	static TreeSet<Integer> endP = new TreeSet<>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/s_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(in.readLine());
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(in.readLine());
				startP.add(Integer.parseInt(tokens.nextToken()));
				endP.add(Integer.parseInt(tokens.nextToken()));
			}
			N = Integer.parseInt(in.readLine());	// this means P
			sb = new StringBuilder(3 * N);
			sb.append("#").append(testCase);
			int sf = startP.first();
			int ef = endP.first();
			for (int i = 0; i < N; i++) {
				int jeon = Integer.parseInt(in.readLine().trim());
				
				if(sf > jeon) {
					sb.append(" 0");
					continue;
				}
				
				
				if(ef >= jeon) {
					sb.append(" ").append(startP.subSet(sf, jeon+1).size());
				} else {
					sb.append(" ").append(startP.subSet(sf, jeon+1).size() - endP.subSet(ef, jeon).size());
				}
			}
			System.out.println(sb);
			startP.clear();
			endP.clear();
		}
	}
}
