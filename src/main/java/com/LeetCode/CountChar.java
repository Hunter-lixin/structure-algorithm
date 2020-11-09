package com.LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CountChar {

    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = bReader.readLine()) != null) {

            char s = bReader.readLine().toCharArray()[0];
            int total = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == s || line.charAt(i) == (char) s - 32) {
                    total++;
                }
            }
            System.out.println(total);
        }


        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] numArr = str.split(" ");
            int a = Integer.parseInt(numArr[0]);
            int b = Integer.parseInt(numArr[1]);
            System.out.println(a + b);
        }
    }

}
