package com.LeetCode;

public class No_153_findMin {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                end = mid ;
            } else {
                start = mid + 1;
            }
        }
        return nums[start];
    }



    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        No_153_findMin solution = new No_153_findMin();
        System.out.println(solution.findMin(nums));
    }
}
