
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// SW Academy #1249. [S/W 문제해결 응용] 4일차 - 보급로

public class Solution1249_품 {

	static int N;
	static int[][] map,cost;
	static StringBuilder answer = null;
	static int[][] dirGo = { { -1, 0 }, { 0, -1 } };	// 상 좌
	static int[][] dirBack = { { 1, 0 }, { 0, 1 } };	// 하 우
	static int[][] dirAll = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };	// 하 우
	static boolean isSorted;
	
	public static void setMinCost(int i, int j) { // 출발지로부터(상, 좌) 자신에게 도달하는 코스트 계산
		int min = Integer.MAX_VALUE;
		int adI, adJ;

		for (int k = 0; k < 2; k++) {
			adI = i + dirGo[k][0];
			adJ = j + dirGo[k][1];

			if (adI < 0 || adI >= N || adJ < 0 || adJ >= N)
				continue;

			min = (cost[adI][adJ] + map[i][j] < min ? cost[adI][adJ] + map[i][j] : min);
		}
		cost[i][j] = min;
	}
	
	public static void setMinCost2(int i, int j) { // 역방향으로 가는 경우 계산
		int min = cost[i][j];
		int adI, adJ;
		for (int k = 0; k < 4; k++) {
			adI = i + dirAll[k][0];
			adJ = j + dirAll[k][1];
			
			if (adI < 0 || adI >= N || adJ < 0 || adJ >= N)
				continue;
			
			min = (cost[adI][adJ] + map[i][j] < min ? cost[adI][adJ] + map[i][j] : min);
		}
		if(min < cost[i][j]) {
			cost[i][j] = min;
			isSorted = false;
		}
	}

	public static void searchByStep1() {		// 맨하탄 거리 이용하여 이동하며 순차 탐색
		
		for (int start = 1; start < N; start++) { // Map의 절반 탐색
			for (int i = 0, j = start; j >= 0; i++, j--) {
				setMinCost(i, j);
			}
		}
		
		for (int start = 1; start < N; start++) { // Map의 나머지 절반 탐색
			for (int i = start, j = N - 1; i < N; i++, j--) {
				setMinCost(i, j);
			}
		}
	}
	public static void searchByStep2() {		// setMinCost2

		for (int start = 1; start < N; start++) { 
			for (int i = 0, j = start; j >= 0; i++, j--) {
				setMinCost2(i, j);
			}
		}

		for (int start = 1; start < N; start++) { 
			for (int i = start, j = N - 1; i < N; i++, j--) {
				setMinCost2(i, j);
			}
		}		
	}

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/sample_input1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int testCase = 1; testCase <= T; testCase++) {
			answer = new StringBuilder();
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			cost = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = br.read() - '0';
					cost[i][j] = map[i][j];
				}
				br.readLine(); // 개행문자 제거
			}

			searchByStep1();
			
			isSorted = true;
			while(isSorted) {
				searchByStep2();
				if(isSorted)
					break;
				isSorted=true;
			}
			
			
//			for (int i = 0; i < N-1; i++) {
//				isSorted = true;
//				searchByStep2();
//				if(isSorted)
//					break;
//			}
			
			System.out.println("#" + testCase + " " + cost[N - 1][N - 1]);
		}
	}
}

