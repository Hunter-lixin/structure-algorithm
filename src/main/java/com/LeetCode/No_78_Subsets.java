package com.LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class No_78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();

        dfs(nums, len, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int len, int index, Deque<Integer> path, List<List<Integer>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        dfs(nums, len, index + 1, path, res);

        path.add(nums[index]);
        dfs(nums, len, index + 1, path, res);
        path.removeLast();
    }

    public static void main(String[] args) {
        No_78_Subsets solution = new No_78_Subsets();
        int[] nums = {1, 2, 3};

        System.out.println(solution.subsets(nums));
    }
}
