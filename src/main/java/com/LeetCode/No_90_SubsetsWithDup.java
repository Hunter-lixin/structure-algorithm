package com.LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class No_90_SubsetsWithDup {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        dfs(false, nums, 0);
        return res;
    }

    private void dfs(boolean isChoose, int[] nums, int index) {
        if (nums.length == index) {
            res.add(new ArrayList<>(path));
            return;
        }

        dfs(false, nums, index + 1);

        if (!isChoose && index > 0 && nums[index] == nums[index - 1]) {
            return;
        }

        path.add(nums[index]);
        dfs(true, nums, index + 1);
        path.removeLast();
    }

    public static void main(String[] args) {
        No_90_SubsetsWithDup solution = new No_90_SubsetsWithDup();
        int[] nums = {1, 2, 2, 1};
        List<List<Integer>> res = solution.subsetsWithDup(nums);
        System.out.println(res);
    }
}
