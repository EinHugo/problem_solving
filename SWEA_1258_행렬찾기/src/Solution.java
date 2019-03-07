import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class SubMat implements Comparable<SubMat>{
	
	int si, sjS, sjE;
	int ilength;
	public SubMat(int si, int sjS, int sjE, int ilength) {
		this.si = si;
		this.sjS = sjS;
		this.sjE = sjE;
		this.ilength = ilength;
	}
	@Override
	public int compareTo(SubMat o) {
		int val1, val2;
		val1 = ((this.sjE - this.sjS + 1) / 2) * this.ilength ;
		val2 = ((o.sjE - o.sjS + 1) / 2) * o.ilength ;
		if( val1 < val2 )  {
			return -1;
		} else if (val1 > val2){
			return 1;
		} else {
			if(this.ilength < o.ilength) {
				return -1;
			} else {
				return 1;
			}
		}
	}
}


public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		int N, NN;
		char[] tokens = null;
		ArrayList<SubMat> subs = null;
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			subs = new ArrayList<>();
			
			N = Integer.parseInt(in.readLine().trim());
			NN = 2 * N;
			int tmpJ;
			boolean isNew;
			
			for (int i = 0; i < N; i++) {
				tokens = in.readLine().toCharArray();
				for (int j = 0; j < NN; j+= 2) {
					isNew = true;
					if( tokens[j] != '0' ) {
						tmpJ = j;
						do {
							j+= 2;
						} while ( (j < NN) && (tokens[j] != '0') );
						for (SubMat subMat : subs) {
							if(subMat.sjS == tmpJ && subMat.sjE == j-1 && subMat.si + subMat.ilength == i) {
								subMat.ilength++;
								isNew = false;
								break;
							}
						}
						if(isNew) {
							subs.add(new SubMat(i, tmpJ, j - 1, 1));
						}
					}
				}
			}
			
			StringBuilder sb = new StringBuilder().append("#").append(testCase).append(" ").append(subs.size());
			
			Collections.sort(subs);
			
			for (SubMat subMat : subs) {
				sb.append(" ").append(subMat.ilength).append(" ").append((subMat.sjE-subMat.sjS+1)/2);
			}
			
			System.out.println(sb);
		}
		
	}
}


