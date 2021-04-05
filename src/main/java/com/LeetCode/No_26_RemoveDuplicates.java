package com.LeetCode;

public class No_26_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {
        No_26_RemoveDuplicates solution = new No_26_RemoveDuplicates();
        int[] nums = {0, 1, 1, 2, 2, 3, 3};
        int ans = solution.removeDuplicates(nums);
        System.out.println(ans);
    }
}
