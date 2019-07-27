package BaekJoon_3425_고스택;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/BaekJoon_3425_고스택/input1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			String line = br.readLine();
			if(line == null) break;
			System.out.println(line);
		}
		
		
		
	}
}