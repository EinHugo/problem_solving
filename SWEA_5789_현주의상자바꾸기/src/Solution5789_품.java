
import java.util.Scanner;
import java.io.FileInputStream;

class Solution5789_품 {		// #5789. 현주의 상자 바꾸기
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("res/sample_input5789.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {

/////////////////////////////////////////////////////////////////////////////////////////////
/*
 * 	N <- # of boxes
 * 	Q <- # of try
 * 	
 * 	boxes[N+1]	
 * 
 * 	for i in (1..Q):
 * 		L <- left bound
 * 		R <- right bound
 * 		for j in (0..R-L-1):
 * 			boxes[L+j] = i
 */
			
			
				int N, Q;
				N = sc.nextInt();
				Q = sc.nextInt();
				int[] boxes = new int[N+1];
				
				for (int i = 1; i <= Q; i++) {
					int L,R;
					L = sc.nextInt();
					R = sc.nextInt();
	//				System.out.println("L : " + L + " / R : " + R);
					for (int j = 0; j <= R-L; j++) {
	//					System.out.print(L+j + " ");
						boxes[L+j] = i;
					}
				}
				System.out.print("#" + test_case);
				for (int i = 1; i <= N; i++) {
					System.out.print(" " + boxes[i]);
				}
				System.out.println();
				
/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
}