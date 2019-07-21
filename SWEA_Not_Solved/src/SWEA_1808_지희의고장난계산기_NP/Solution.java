package SWEA_1808_지희의고장난계산기_NP;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {

	static int target;
	static int digit;
	
	static TreeSet<Integer> set = new TreeSet<>();
	
	static HashSet<Integer> tmpCre = new HashSet<>();
	static HashSet<Integer> numbersCre = new HashSet<>();
	static ArrayList<Integer> numbers = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());
		StringTokenizer tokens;
		for (int testCase = 1; testCase <= T; testCase++) {
			set.clear();
			numbers.clear();
			
			tokens = new StringTokenizer(in.readLine().trim());
			for (int i = 0; i < 10; i++) {
				if(tokens.nextToken().contains("1")) {
					numbers.add(i);
				}
			}
			
			String input = in.readLine().trim();
			boolean withoutMul = true;
			for (int i = 0; i < input.length(); i++) {
				if(!numbers.contains(input.charAt(i)-'0')) {
					withoutMul = false;
				}
			}
			
			if(withoutMul) {
//				System.out.println(numbers);
//				System.out.println(input);
				System.out.println("#" + testCase + " " + (input.length() + 1));
				continue;
			}
			
			target = Integer.parseInt(input);		// target : 1 ~ 1,000,000
			
			digit = 0;
			for (int i = 1; target/i != 0; i *= 10) {
				digit++;
			}
			

			
//			System.out.println(set);
//			System.out.println("#" + testCase + " " );
			System.out.println("#" + testCase + " " + "-1");

		}
	}
	
	static void multi() {
		tmpCre.clear();
		for (Integer accum : numbersCre) {
			for (Integer num : numbers) {
				tmpCre.add(accum * 10 + num);
			}
		}
		numbersCre.clear();
		
		HashSet<Integer> swap = numbersCre;
		numbersCre = tmpCre;
		tmpCre = swap;
		
		for (Integer integer : numbersCre) {
			for (Integer integer2 : set) {
				
			}
			set.add(integer);
		}
	}
}

