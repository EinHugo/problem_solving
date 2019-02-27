import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int vertexNum;
		for (int testCase = 1; testCase <= 10; testCase++) {
			vertexNum = Integer.parseInt(in.readLine().trim());
//			System.out.println(vertexNum);
			int isRight = 1;
			for (int i = 0; i < vertexNum; i++) {
				String[] line = in.readLine().split(" ");
				if(line.length >= 4) {
					if(Character.isDigit(line[1].charAt(0))) {
						isRight = 0;
						while(++i<vertexNum) {
//							System.out.println(in.readLine());
							in.readLine();
						}
					}
				} else {
					if(!Character.isDigit(line[1].charAt(0))) {
						isRight = 0;
						while(++i<vertexNum) {
//							System.out.println(in.readLine());
							in.readLine();
						}
					}
				}
			}
			System.out.println("#" + testCase + " " + isRight);
		}
	}
}

