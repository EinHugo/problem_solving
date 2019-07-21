package BaekJoon_16236_아기상어_NP;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main { // 백준 #16236. 아기 상어.

	static int[][] map;
	static int N, answer;
	static Map<Integer, List<Integer>> fishes;
	static int[] babyShark;
	static int[][] dir = { {-1,0}, {1,0}, {0,-1}, {0,1} };
	static int[][] dirCross = { {-1,-1}, {-1,1}, {1,-1}, {1,1} };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input16236_2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine().trim()); // N = size of map
		map = new int[N + 1][N + 1];
		StringTokenizer tokens = null;
		answer = 0;

		fishes = new HashMap<>();
		for (int i = 1; i <= 6; i++) {
			fishes.put(i, new ArrayList<Integer>());
		}
		babyShark = new int[2];

		int tmp;
		for (int i = 1; i <= N; i++) {
			tokens = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= N; j++) {
				tmp = Integer.parseInt(tokens.nextToken());
				map[i][j] = tmp;
				if (tmp != 0) {
					if (tmp == 9) {
						babyShark[0] = i;
						babyShark[1] = j;
						continue;
					}
					List<Integer> tmpList = fishes.get(tmp);
					tmpList.add(i);
					tmpList.add(j);
				}
			}
		}

		// 프린트 찍어보기
//		for (int i = 1; i <= 6; i++) {
//			List<Integer> print = fishes.get(i);
//			for (Integer integer : print) {
//				System.out.print(integer + " ");
//			}
//			System.out.println();
//		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println(answer);
	}

	static void go() {
		int newI = 0, newJ = 0;
		
		for (int i = 1; i < N; i++) {
			
			newI = babyShark[0] - i;
//			newJ = babyShark[0] - j;
		}
	}
	
	static void changeMap(int level) {
		List<Integer> list;

		while (level > 0) {
			list = fishes.get(level--);
			while (list.isEmpty()) {
				map[list.get(0)][list.get(1)] = 1;
				list.remove(1);
				list.remove(0);
			}
		}

	}

}
