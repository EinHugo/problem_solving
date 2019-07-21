package SWEA_1857_종민이의도미노_NP;

import java.io.FileInputStream;
import java.util.Scanner;


class Solution {// #1857. 종민이의 도미노

	static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	
//	static int whatIsNext(int[][] plate,  int i, int j) {
//		int max = -1;
//		
//		for (int k = 0; k < 4; k++) {
//			i = i + dir[k][0];
//			j = j + dir[k][1];
//			
//			(max <= )
//		}
//		
//		return 0;
//	}
	
    public static void main(String args[]) throws Exception {
    	
        System.setIn(new FileInputStream("res/sample_input1857.txt"));


        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();


        for (int test_case = 1; test_case <= T; test_case++) {

            /////////////////////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////////////////////////

            int N = sc.nextInt();   // # of plate (1 <= N <= 2000)
            int[][] plate = new int[N+2][N+2];
            int[][] nextOne = new int[N+2][N+2];
            int K = sc.nextInt();	// # of domino
            
            for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					plate[i][j] = sc.nextInt();
//					System.out.print(plate[i][j]);
				}
//				System.out.println();
			}
            
            for (int i = 0; i < K; i++) {
				
			}

            
            
          
//            System.out.print("#" + test_case);
//            System.out.println(" " + wordCount);

        }
    }
}