package com.LeetCode;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 示例1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 *
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 *
 * 输入：coins = [1], amount = 2
 * 输出：2
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (coin < i && dp[i - coin] > 0) {
                    if (dp[i] > -1) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    } else {
                        dp[i] = dp[i - coin] + 1;
                    }
                } else if (coin == i) {
                    dp[i] = 1;
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        /*int[] coins = new int[]{1, 2, 5};
        int amount = 11;*/

        int[] coins = new int[]{2};
        int amount = 3;

        System.out.println(coinChange(coins, amount));

    }
}
