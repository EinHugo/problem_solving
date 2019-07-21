package BaekJoon_16234_인구이동_NP;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

class newHashSet extends HashSet<Integer> { // hashSet<Integer> for unique hash code
	static int count = 0;
	int code = 0;

	public newHashSet() {
		code = count++;
	}

	@Override
	public int hashCode() {
		return code;
	}
}

public class Main16234_반례못찾음 { // BaekJoon #16234. 인구이동

	static int[][] map; // array for each population
	static Set<newHashSet> unions; // set of each union
	static Map<newHashSet, Integer> population; // population value of each union
	static int N, L, R;
	static int count = -1;

	/**
	 * make union step by step, then change the population
	 * 
	 * @return true if someThing change, false if nothing to do
	 */
	static boolean merge_Divide() {

		boolean isChanged = false;
		count++;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				isInSet(i, j);
			}
		}

		int divide;
		for (newHashSet tmpUnion : unions) {
			if (tmpUnion.size() > 1) {
				divide = population.get(tmpUnion) / tmpUnion.size();
				for (Integer xy : tmpUnion) {
					if (map[xy / 100][xy % 100] != divide) {
						map[xy / 100][xy % 100] = divide;
						isChanged = true;
					}
				}
			}
		}

		unions.clear();
		population.clear();

		return isChanged;
	}

	/**
	 * make union for each map[x,y]
	 * check the population difference, and add x,y to the members of union
	 * if there is no exact union, make union
	 * 
	 * @param x, y
	 */
	static void isInSet(int x, int y) {
		int xy = x * 100 + y;

		int diffUp = Math.abs(map[x - 1][y] - map[x][y]);
		int diffLeft = Math.abs(map[x][y - 1] - map[x][y]);

		if (L <= diffUp && diffUp <= R) {
			if (addMember((x - 1) * 100 + y, xy)) {
				if (L <= diffLeft && diffLeft <= R) {
					mergeMember((x * 100 + (y - 1)), xy);
					return;
				}
				return;
			}
		}

		if (L <= diffLeft && diffLeft <= R) {
			if (addMember(x * 100 + (y - 1), xy)) {
				return;
			}
		}
		
		addUnion(xy);
	}

	
	/**
	 * check the union to join,
	 * if there is, add xy to that union & update total population of union
	 * 
	 * @param pre	- adjacent contry
	 * @param xy	- contry to add
	 * @return false if there is no exact union
	 */
	static boolean addMember(int pre, int xy) { 
		for (newHashSet tmpSet : unions) {
			if (tmpSet.contains(pre)) {

				int pop = population.get(tmpSet);
				population.remove(tmpSet);

				tmpSet.add(xy);
				population.put(tmpSet, pop + map[xy / 100][xy % 100]);
				return true;
			}
		}
		return false;
	}

	
	/**
	 * if there are two unique union beside xy contry,
	 * merge unions to one, and update total population
	 * 
	 * @param pre - adjacent contry
	 * @param xy
	 */
	static void mergeMember(int pre, int xy) {
		newHashSet xySet = null;
		newHashSet preSet = null;
		for (newHashSet tmpSet : unions) {
			if (tmpSet.contains(xy)) {
				xySet = tmpSet;
				continue;
			}
			if (tmpSet.contains(pre)) {
				preSet = tmpSet;
			}
		}
//		for (newHashSet tmpSet : unions) {
//			if (tmpSet.contains(pre) && !tmpSet.equals(xySet)) {
//				preSet = tmpSet;
//				break;
//			}
//		}

		if (preSet == null || xySet.size() == preSet.size()) {
			return;
		}

		if (!xySet.equals(preSet)) {
			int tmpPop = population.get(xySet) + population.get(preSet);
			population.remove(preSet);
			population.remove(xySet);
			xySet.addAll(preSet);
			unions.remove(preSet);
			population.put(xySet, tmpPop);
		}
	}

	
	/**
	 * make new union if there is no union
	 * 
	 * @param xy contry to make union
	 */
	static void addUnion(int xy) {
		newHashSet workingSet = new newHashSet();
		workingSet.add(xy);
		unions.add(workingSet);
		population.put(workingSet, map[xy / 100][xy % 100]);
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16234_7.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tokens = new StringTokenizer(in.readLine().trim(), " ");
		N = Integer.parseInt(tokens.nextToken()); // 1~50
		L = Integer.parseInt(tokens.nextToken()); // 1~100
		R = Integer.parseInt(tokens.nextToken()); // 1~100
		map = new int[N + 1][N + 1];
		unions = new HashSet<>();
		population = new HashMap<>();

		// get Values in array 'map'
		for (int i = 1; i <= N; i++) {
			tokens = new StringTokenizer(in.readLine().trim(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken()); 
			}
		}

		// merge until there's nothing to merge
		while (merge_Divide()) 
			;

		System.out.println(count);

	}
}
