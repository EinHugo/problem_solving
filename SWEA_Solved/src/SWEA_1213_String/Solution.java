package SWEA_1213_String;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test = 1; test <= 10; test++) {
			in.readLine();
			String pattern = in.readLine().trim();
			String line = in.readLine();
			int index = 1, count = 0;
			while(index > 0) {
				index = line.indexOf(pattern, index);
//				System.out.println(index);
				count++; index++;
			}
			
			count--;
			System.out.println("#" + test + " " + count);
		}
		
	}
}
