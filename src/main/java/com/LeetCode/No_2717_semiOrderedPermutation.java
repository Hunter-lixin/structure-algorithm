package com.LeetCode;

public class No_2717_semiOrderedPermutation {
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int first = 0, last = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                first = i;
            }
            if (nums[i] == n) {
                last = i;
            }
        }
        return first + n - 1 - last - (last < first ? 1 : 0);
    }
}
