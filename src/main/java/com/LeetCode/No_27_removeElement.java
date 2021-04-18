package com.LeetCode;

public class No_27_removeElement {
    public int removeElement(int[] nums, int val) {
        int low = 0;
        int fast = 0;
        int len = nums.length;
        while (fast < len) {
            if (nums[fast] != val) {
                nums[low] = nums[fast];
                low++;
            }
            fast++;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        No_27_removeElement solution = new No_27_removeElement();
        System.out.println(solution.removeElement(nums, val));
    }
}
