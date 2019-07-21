package SWEA_2007_패턴마디의길이;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		for (int test = 1; test <= T; test++) {
			String sb = in.readLine();
			
//			System.out.println(pattern);
//			System.out.println();
//			int answer = 0;
//			for (int i = length; i < length; i++) {
//				if(sb.substring(i, i+2).contains(pattern)) {
//					answer = length / (i);
//					break;
//					System.out.println(sb.substring(i, i+2));
//				}
//			}
			String pattern = sb.substring(1, 3);
			int a = sb.indexOf(pattern, 3);
//			String[] a = sb.split(pattern);
//			System.out.println(sb.length() + " / " + a.length);
//			for (int i = 0; i < a.length; i++) {
//				System.out.println(a[i]);
//			}
//			System.out.println("#" + test + " " + (sb.length() / (a.length-1)));
			System.out.println("#" + test + " " + (a-1));
		}
		
	}
}
