package com.interview;

/**
 * 给定一个非负整数数组，a1,a2,...,an,和一个目标数s。现在你有两个符号+和-。
 * 对于数组中任意一个整数，你都可以从+或- 中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数s的所有添加符号的方法数。
 * <p>
 * 输入： nums:[1, 1, 1, 1, 1], S:3
 * 输出：5
 * <p>
 * 解释：
 * -1+1+1+1+1=3
 * +1-1+1+1+1=3
 * +1+1-1+1+1=3
 * +1+1+1-1+1=3
 * +1+1+1+1-1=3
 * 一共有5种方法最终目标和为3.
 */
public class Main {

    public static int sumCount(int[] nums, int sum) {
        int length = nums.length;
        int ans = 0;
        int numsSum = 0;
        for (int num : nums) {
            numsSum += num;
        }
        for (int num : nums) {
            if ((numsSum - num) == (sum + num)) {
                ans++;
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((numsSum - nums[i] - nums[j]) == (sum + nums[i] + nums[j])) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        //  全是1 满足
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int sum = 3;
        System.out.println(sumCount(nums, sum));

    }

}
