package com.LeetCode;

import java.util.Arrays;

public class No_3194_minimumAverage {
    public double minimumAverage(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        int length = nums.length;
        double res = (double) (nums[0] + nums[length - 1]) / 2;
        for (int i = 1; i < length; i++) {
            res = Math.min(res, (double) (nums[i] + nums[length - i - 1]) / 2);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No_3194_minimumAverage().minimumAverage(new int[]{7, 8, 3, 4, 15, 13, 4, 1}));
    }
}
