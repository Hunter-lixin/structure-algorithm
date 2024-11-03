package com.LeetCode;

public class No_633_judgeSquareSum {
    public boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; i++) {
            double b = Math.sqrt(c - i * i);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new No_633_judgeSquareSum().judgeSquareSum(3));
        System.out.println(new No_633_judgeSquareSum().judgeSquareSum(5));

    }
}
