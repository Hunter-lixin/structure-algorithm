package com.LeetCode;

import java.util.Arrays;

public class No_179_largestNumber {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        Integer[] boxedNums = new Integer[len];

        for (int i = 0; i < len; i++) {
            boxedNums[i] = nums[i];
        }

        Arrays.sort(boxedNums, (x, y) ->{
            long sx = 10;
            long sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (boxedNums[0] == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (Integer boxedNum : boxedNums) {
            sb.append(boxedNum);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        No_179_largestNumber solution = new No_179_largestNumber();
        int[] nums = {111311, 1113};
        System.out.println(solution.largestNumber(nums));
    }
}
