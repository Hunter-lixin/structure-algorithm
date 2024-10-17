package com.LeetCode;

public class No_3191_minOperations {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (i > n - 3) {
                    return -1;
                }
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new No_3191_minOperations().minOperations(new int[]{0, 1, 1, 1, 0, 0}));
        System.out.println(new No_3191_minOperations().minOperations(new int[]{0, 1, 1, 1}));
    }
}
