package com.LeetCode;

public class No_263_isUgly {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        int[] array = {2, 3, 5};
        for (int i : array) {
            while (n % i == 0) {
                n /= i;
            }
        }

        return n == 1;
    }
}
