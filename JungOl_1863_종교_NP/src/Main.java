import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;


class Pair implements Comparable<Pair> {
	int left, right;
	
	public Pair(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return this.left - o.right;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tokens = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] pairs = new int[n+1][n+1];
		
		HashSet<Integer> set = new HashSet<>();
		LinkedList<Pair> pairList = new LinkedList<>();
		
		Integer i, j;
		
		if(m == 0) {
			System.out.println(n);
			return ;
		}
		
		for (int k = 0; k < m; k++) {

			tokens = new StringTokenizer(in.readLine());
			i = Integer.parseInt(tokens.nextToken());
			j = Integer.parseInt(tokens.nextToken());
			
			pairs[i][j] = 1;
			pairs[j][i] = 1;
			pairList.add(new Pair(i, j));
//			if (set.contains(i)) {
//				if(set.contains(j)) {
//					continue;
//				}
//				set.add(j);
//				n--;
//			} else if (set.contains(j)) {
//				set.add(i);
//				n--;
//			} else {
//				set.add(i);
//				set.add(j);
//				n--;
//			}
		}
		
		Collections.sort(pairList);
		
		for (Pair pair : pairList) {
			i = pair.left;
			j = pair.right;
			if(pairs[i][j] == 0) {
				continue;
			}
			
			if(set.contains(i)) {
				if(!set.contains(j)) {
					set.add(j);
					pairs[i][j] = 0;
					pairs[j][i] = 0;
					n--;
				}
				
				for (int j2 = 1; j2 <= n; j2++) {
					if(pairs[i][j2] == 1) {
						set.add(j2);
						pairs[i][j2] = 0;
						pairs[j2][i] = 0;
						n--;
					}
				}
			} else {
				set.add(i);
				set.add(j);
				pairs[i][j] = 0;
				pairs[j][i] = 0;
				n--;
			}
		}
		System.out.println(n);
	}
}
