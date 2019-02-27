import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
 
public class Solution {
     
    static int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
    static Set<String> numbers;
    static char[][] map;
     
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine().trim());
         
        for (int test = 1; test <= T; test++) {
            numbers = new HashSet<>();
             
            map = new char[4][4];
             
            StringTokenizer tokens = null;
            for (int i = 0; i < 4; i++) {
                tokens = new StringTokenizer(in.readLine().trim());
                for (int j = 0; j < 4; j++) {
                    map[i][j] = tokens.nextToken().charAt(0);
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    getNumbers(i, j, "");
                }
            }
             
            System.out.println("#" + test + " " + numbers.size());
             
        }
         
    }
     
    static void getNumbers(int x, int y, String pre) {
        if(pre.length() == 7) {
            numbers.add(pre);
            return;
        }
         
        else {
            for (int i = 0; i < 4; i++) {
                if(x+dir[i][0] >= 0 && y+dir[i][1] >= 0 && y+dir[i][1] < 4 && x+dir[i][0] < 4) {
                    getNumbers(x+dir[i][0], y+dir[i][1], pre + map[x][y]);
                }
            }
             
        }
    }
     
}