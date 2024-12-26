package com.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No_3159_occurrencesOfElement {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                indices.add(i);
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (indices.size() < queries[i]) {
                res[i] = -1;
            } else {
                res[i] = indices.get(queries[i] - 1);
            }
        }
        return res;
    }
}
