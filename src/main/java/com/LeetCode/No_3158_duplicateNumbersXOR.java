package com.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class No_3158_duplicateNumbersXOR {
    public int duplicateNumbersXOR(int[] nums) {
        Set<Integer> countSet = new HashSet<>();
        int result = 0;
        for (int num : nums) {
            if (!countSet.add(num)) {
                result ^= num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new No_3158_duplicateNumbersXOR().duplicateNumbersXOR(new int[]{1, 2, 1, 3}));
        System.out.println(new No_3158_duplicateNumbersXOR().duplicateNumbersXOR(new int[]{1, 2, 3}));
        System.out.println(new No_3158_duplicateNumbersXOR().duplicateNumbersXOR(new int[]{1, 2, 2, 1}));
    }
}
