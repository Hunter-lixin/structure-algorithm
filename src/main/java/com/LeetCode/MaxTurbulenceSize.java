package com.LeetCode;

/**
 * 978. 最长湍流子数组
 *
 * 当 A的子数组A[i], A[i+1], ..., A[j]满足下列条件时，我们称其为湍流子数组：
 * <p>
 * 若i <= k < j，当 k为奇数时，A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若i <= k < j，当 k 为偶数时，A[k] > A[k+1]，且当 k为奇数时，A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * <p>
 * 返回 A 的最大湍流子数组的长度。
 * <p>
 *
 * 示例 1：
 * <p>
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 *
 * 示例 2：
 * <p>
 * 输入：[4,8,12,16]
 * 输出：2
 *
 * 示例 3：
 * <p>
 * 输入：[100]
 * 输出：1
 * <p>
 * 提示：
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 */
public class MaxTurbulenceSize {
    public int maxTurbulenceSize(int[] nums) {
        int maxans = 0;
        int[] dp = new int[nums.length];
        if (nums.length <= 1) {
            maxans = nums.length;
        } else {
            maxans = nums[0] == nums[1] ? 1 : 2;
            dp[1] = nums[0] == nums[1] ? 1 : 2;
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                dp[i] = 1;
            } else {
                dp[i] = 2;
            }
            if (nums[i] > nums[i - 1] && nums[i - 1] < nums[i - 2]
                    || nums[i] < nums[i - 1] && nums[i - 1] > nums[i - 2]) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }

            maxans = Math.max(maxans, dp[i]);
        }

        return maxans;
    }

    public static void main(String[] args) {
        MaxTurbulenceSize maxTurbulenceSize = new MaxTurbulenceSize();
        int[] nums1 = new int[]{37, 199, 60, 296, 257, 248, 115, 31, 273, 176};
        System.out.println(maxTurbulenceSize.maxTurbulenceSize(nums1));

        int[] nums2 = new int[]{1, 1, 1, 1};
        System.out.println(maxTurbulenceSize.maxTurbulenceSize(nums2));
    }
}
