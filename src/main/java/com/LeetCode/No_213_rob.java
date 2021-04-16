package com.LeetCode;

import java.util.Arrays;

public class No_213_rob {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(robRange(nums, 0, len - 1), robRange(nums, 1, len));

    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(first, nums[start + 1]);

        for (int i = start + 2; i < end; i++) {
            int temp = second;
            second = Math.max(second, first + nums[i]);
            first = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        No_213_rob solution = new No_213_rob();
        System.out.println(solution.rob(nums));
    }
}

