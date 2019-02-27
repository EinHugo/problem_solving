
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution5550_품 {		// SWexpert #5550. 나는 개구리로소이다

//	static public void print(int[] croak) {
//		System.out.print(croak['c'] +".");
//		System.out.print(croak['r'] +".");
//		System.out.print(croak['o'] +".");
//		System.out.print(croak['a'] +".");
//		System.out.print(croak['k'] + " ");
//	}

	static int[] croak = null;
	
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("res/sample_input5550.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int test_case = 1; test_case <= T; test_case++) {
			croak = new int[128];

			String line = br.readLine().trim();

			char ch;
			int answer = 0;
			for (int i = 0, size = line.length(); i < size; i++) {
				ch = line.charAt(i);
				croak[ch]++;
				switch (ch) {
				case 'k':
					if (croak['a'] < croak[ch]) {
						answer = -1; break;
					} else if (answer < croak['c']) {
						answer = croak['c'];
						break;
					} 
				case 'a':
					if(croak['o'] < croak[ch]) {
						answer = -1; break;
					}
				case 'o':
					if (croak['r'] < croak[ch]){
						answer = -1; break;
					}
				case 'r':
					if (croak['c'] < croak[ch]) {
						answer = -1; break;
					}
				default:
					break;
				}
				if (answer == -1) {
					break;
				} else if(croak['k'] != 0) {
					croak['c']--;
					croak['r']--;
					croak['o']--;
					croak['a']--;
					croak['k']--;
				}

			}

			if (croak['c'] + croak['r'] + croak['o'] + croak['a'] + croak['k'] != croak['c'] * 5) {
				answer = -1;
			}

			System.out.println("#" + test_case + " " + answer);

		}
	}
}