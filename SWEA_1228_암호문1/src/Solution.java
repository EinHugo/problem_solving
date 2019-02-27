import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int testCase = 1; testCase <= 10; testCase++) {
			int N = Integer.parseInt(br.readLine().trim());
			LinkedList<String> answer = new LinkedList<>();
			String line = br.readLine().trim();
			int operationNum = Integer.parseInt(br.readLine().trim());
			if(testCase==8) {
//				System.out.println("oNum#####" + operationNum);
			}
			StringTokenizer tokens = new StringTokenizer(line);

			int listSize = 0;

			for (int i = 0; i < 10; i++) {
				answer.add(listSize++, tokens.nextToken());

			}

			line = br.readLine().trim();
			tokens = new StringTokenizer(line);
			int size = tokens.countTokens();
//			System.out.println("size " + size);
			while(operationNum > 0 ) {
//			for (int i = 0; i < tokens.countTokens(); i++) {
				String token = tokens.nextToken();
				if (token.equalsIgnoreCase("I")) {
					int index = Integer.parseInt(tokens.nextToken());
					int count = Integer.parseInt(tokens.nextToken());
//					if(testCase == 8) {
//						System.out.println();
//						System.out.println("index : " + index + " / count : " + count);
//					}
					for (int j = 0; j < count; j++) {
						String nextOne = tokens.nextToken();
//						if(testCase == 8) {
//							System.out.print((index + j) + ": " + nextOne + "/");
//						}
						if (10 < index + j) {
							;
						} else {
//							System.out.print((index + j) + " ");
							answer.add(index + j, nextOne);

						}
	
						listSize++;
					}
					operationNum--;
				}else {
//					System.out.println("TOKEN : " + token);
				}
//				if(testCase == 8) {
//					System.out.println();
//					System.out.println("OPERATION : " + operationNum);
//				}
				if (operationNum < 0) {
					break;
				}
			}
			StringBuilder sb = new StringBuilder().append("#").append(testCase);
			for (int i = 0; i < 10; i++) {
				sb.append(" ").append(answer.get(i));
			}
			System.out.println(sb);
		}
	}
}
