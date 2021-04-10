package com.LeetCode;

public class No_264_nthUglyNumber {
    public int nthUglyNumber(int n) {
        int index = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (isNthUgly(i)) {
                index++;
            }
            if (index == n) {
                return i;
            }
        }
        return 0;
    }

    public boolean isNthUgly(int num) {
        if (num <= 0) {
            return false;
        }
        int[] arr = {2, 3, 5};
        for (int i : arr) {
            while (num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }

    public static void main(String[] args) {
        int n = 1352;
        No_264_nthUglyNumber solution = new No_264_nthUglyNumber();
        System.out.println(solution.nthUglyNumber(n));
    }
}
