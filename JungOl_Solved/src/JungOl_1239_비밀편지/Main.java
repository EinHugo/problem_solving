package JungOl_1239_비밀편지;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;


public class Main {
	
	static HashSet<Integer> A = new HashSet<>();
	static HashSet<Integer> B = new HashSet<>();
	static HashSet<Integer> C = new HashSet<>();
	static HashSet<Integer> D = new HashSet<>();
	static HashSet<Integer> E = new HashSet<>();
	static HashSet<Integer> F = new HashSet<>();
	static HashSet<Integer> G = new HashSet<>();
	static HashSet<Integer> H = new HashSet<>();
	
	static ArrayList<HashSet<Integer>> alphabet = new ArrayList<>();
	
	static int N;
	static int input, ch;
	static int[] chars = { 0, 15, 19, 28, 38, 41, 53, 58 };		// A~H

	public static void main(String[] args) throws Exception {
		
		A.add(0);A.add(1);A.add(2);A.add(4);A.add(8);A.add(16);A.add(32);
		B.add(15);B.add(14);B.add(13);B.add(11);B.add(7);B.add(31);B.add(47);
		C.add(19);C.add(18);C.add(17);C.add(23);C.add(27);C.add(3);C.add(51);
		D.add(28);D.add(29);D.add(30);D.add(24);D.add(20);D.add(12);D.add(60);
		E.add(38);E.add(39);E.add(36);E.add(34);E.add(46);E.add(54);E.add(6);
		F.add(41);F.add(40);F.add(43);F.add(45);F.add(33);F.add(57);F.add(9);
		G.add(53);G.add(52);G.add(55);G.add(49);G.add(61);G.add(37);G.add(21);
		H.add(58);H.add(59);H.add(56);H.add(62);H.add(50);H.add(42);H.add(26);
		
		alphabet.add(A);
		alphabet.add(B);
		alphabet.add(C);
		alphabet.add(D);
		alphabet.add(E);
		alphabet.add(F);
		alphabet.add(G);
		alphabet.add(H);
		
		System.setIn(new FileInputStream("res/input2.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine().trim());
		
		String line = in.readLine();
		StringBuilder sb = new StringBuilder();
		boolean isDecorded;
		
		for (int i = 0; i < N; i++) {
			input = Integer.parseInt(line.substring(i*6, (i*6 + 6)), 2);
			isDecorded = false;
			
			for (int idx = 0; idx < chars.length; idx++) {
				if(alphabet.get(idx).contains(input)) {
					sb.append((char) (idx+'A'));
					isDecorded = true;
					break;
				}
			}
			
			if(!isDecorded) {
				sb = new StringBuilder().append(sb.length()+1);
				break;
			}
		}
		System.out.println(sb);
	}
}
