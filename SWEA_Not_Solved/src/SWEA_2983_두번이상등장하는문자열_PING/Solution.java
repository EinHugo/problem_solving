package SWEA_2983_두번이상등장하는문자열_PING;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.Character.Subset;
import java.util.HashSet;

public class Solution {
	static int L;
	static char[] S;
	static HashSet<Integer> hashingCode = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			StringBuilder sb = new StringBuilder().append("#").append(testCase).append(" ");
			
			L = Integer.parseInt(in.readLine().trim());
			S = in.readLine().trim().toCharArray();
			for (int i = 1; i < L; i++) {
				hashingCode.clear();
				if(!checkSub(i)) {
					sb.append(i-1);
					break;
				}
				System.out.println("#####################" + i);
			}
			
//			sb.append(check(0, L));
			
			System.out.println(sb);
		}
	}
	
	static boolean checkSub(int idx) {
		int hashSum, tmpSum;
		for (int i = 0; i < L-i; i++) {
			hashSum = 0;
			for (int hashIdx = i, j = 1; j <= idx; j++) {
				tmpSum = 1;
				for (int tmp = 0; tmp < j; tmp++) {
					tmpSum *= 10;
				}
				hashSum += tmpSum * S[hashIdx];
			}
			if(hashingCode.contains(hashSum)){
//				System.out.println(S[i]);
				System.out.println(i + "~" + (i+idx) + " " + hashSum);
				return true;
			} else {
				System.out.print(i + "~" + (i+idx) + "  ");
				hashingCode.add(hashSum);
				System.out.println(hashingCode);
			}
		}
		
		
		return false;
	}
}
