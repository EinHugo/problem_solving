package SWEA_4261_빠른휴대전화키패드;

import java.util.Scanner;
import java.io.FileInputStream;


class Solution4261_품 {// #4261. 빠른 휴대전화 키패드
    static char[] keyMap = new char[130];

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/sample_input4261.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        keyMap['a'] = '2';
        keyMap['b'] = '2';
        keyMap['c'] = '2';
        keyMap['d'] = '3';
        keyMap['e'] = '3';
        keyMap['f'] = '3';
        keyMap['g'] = '4';
        keyMap['h'] = '4';
        keyMap['i'] = '4';
        keyMap['j'] = '5';
        keyMap['k'] = '5';
        keyMap['l'] = '5';
        keyMap['m'] = '6';
        keyMap['n'] = '6';
        keyMap['o'] = '6';
        keyMap['p'] = '7';
        keyMap['q'] = '7';
        keyMap['r'] = '7';
        keyMap['s'] = '7';
        keyMap['t'] = '8';
        keyMap['u'] = '8';
        keyMap['v'] = '8';
        keyMap['w'] = '9';
        keyMap['x'] = '9';
        keyMap['y'] = '9';
        keyMap['z'] = '9';

        for (int test_case = 1; test_case <= T; test_case++) {

            String S = sc.next();    // Key input
            int N = sc.nextInt();    // # of dictionary

            String[] dictionary = new String[1000];
            boolean isSameWord = true;
            int wordLength, wordCount = 0;

            for (int i = 0; i < N; i++) {
                dictionary[i] = sc.next();
                wordLength = dictionary[i].length();

                if (dictionary[i] == null || wordLength != S.length()) {
                    continue;
                }

                isSameWord = true;
                for (int ch = 0; ch < wordLength; ch++) {

                    if (keyMap[dictionary[i].charAt(ch)] != S.charAt(ch)) {
                        isSameWord = false;
                    }
                }

                if (isSameWord) {
                    wordCount++;
                }
            }

            System.out.print("#" + test_case);
            System.out.println(" " + wordCount);

        }
    }
}