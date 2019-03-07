import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

class pos {
	int y, x;

	public pos(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Solution {
	static int N;
	static TreeMap<Integer, pos> numToPos = new TreeMap<>();
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int max;
	static int roomNum, roomNumTmp;
	
	static int preKey;
	static pos prePos;
	static int currentKey;
	static pos currentPos;
	
	static int nx,ny, cnt;
	static boolean isChanged;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine().trim());
		StringTokenizer tokens;

		for (int testCase = 1; testCase <= T; testCase++) {
			max = 0;
			preKey = -2;
			numToPos.clear();

			N = Integer.parseInt(in.readLine().trim());
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					numToPos.put(Integer.parseInt(tokens.nextToken()), new pos(i, j));
				}
			}

			cnt = 0;
			while (!numToPos.isEmpty()) {
				currentKey = numToPos.firstKey();
				currentPos = numToPos.get(currentKey);
				isChanged = false;
				// get new value
				
				if(preKey + 1 != currentKey) {		// is not continuous?
					cnt = 1;
					
					prePos = currentPos;
					roomNumTmp = preKey = currentKey;
					numToPos.remove(currentKey);
					continue;
				} else {							// if it is continuous
					for (int i = 0; i < 4; i++) {	// check whether neighbor
						if(prePos.y + dir[i][0] == currentPos.y && prePos.x + dir[i][1] == currentPos.x) {
							cnt++;
							if(max < cnt) {
								max = cnt;
								roomNum = roomNumTmp;
							}
							isChanged = true;
							
							prePos = currentPos;
							preKey = currentKey;
							numToPos.remove(currentKey);
							break;
						}
					}
					if(!isChanged) {	// not neighbor, new start
						cnt = 1;
						
						prePos = currentPos;
						roomNumTmp = preKey = currentKey;
						numToPos.remove(currentKey);
						continue;
					}
					
				}
			}

			System.out.println("#" + testCase + " " + roomNum + " " + max);
		}
	}
}
