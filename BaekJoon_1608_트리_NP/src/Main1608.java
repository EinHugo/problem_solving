
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1608 {	// 1608. 트리
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		int answer = 0;
		String[] parent = new String[N];
		StringTokenizer tokens = new StringTokenizer(br.readLine().trim());
		parent[0] = "";
		tokens.nextToken();
		for (int i = 1; i < N; i++) {
			parent[Integer.parseInt(tokens.nextToken())] += i + " ";
		}
		for (String string : parent) {
			if (string ==  null) {
				answer++;
			}
		}
		
		int delete = Integer.parseInt(br.readLine().trim());
		
		System.out.println(answer);
	}
}
