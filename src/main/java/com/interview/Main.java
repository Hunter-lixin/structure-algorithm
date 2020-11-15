package com.interview;

/**
 * 示例：
 * 输入: [[1,2,2,1],
 * [3,1,2],
 * [1,3,2],
 * [2,4],
 * [3,1,2],
 * [1,3,1,1]]
 * <p>
 * 输出: 2
 */
public class Main {

    public static int getCount(int[][] numsArray) {
        int ans = 0;

        int length = numsArray.length;
        int index = 0;
        while (index < length) {
            int[] currNums = numsArray[index];
            int numsLength = currNums.length;

            int currAns = 0;

            for (int i = 1; i < numsLength - 1; i++) {
                int currAllValue = getALl(currNums, i);

                int tempAns = 0;

                for (int[] nums : numsArray) {
                    int temp = 0;
                    for (int num : nums) {
                        temp += num;
                        if (temp == currAllValue) {
                            break;
                        }
                        if (temp > currAllValue) {
                            tempAns++;
                            break;
                        }
                    }
                }

                if (currAns == 0) {
                    currAns = tempAns;
                } else if (tempAns > 0 && currAns > 0) {
                    currAns = Math.min(tempAns, currAns);
                }
            }
            index++;

            if (ans == 0) {
                ans = currAns;
            } else if (ans > 0 && currAns > 0) {
                ans = Math.min(ans, currAns);
            }
        }

        return ans;
    }

    public static int getALl(int[] nums, int target) {
        int ans = 0;
        for (int i = 0; i < target; i++) {
            ans += nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] numsArray = new int[][]{{1, 2, 2, 1}, {3, 1, 2}, {1, 3, 2}, {2, 4}, {3, 1, 2}, {1, 3, 1, 1}};
        System.out.println(getCount(numsArray));
    }
}
