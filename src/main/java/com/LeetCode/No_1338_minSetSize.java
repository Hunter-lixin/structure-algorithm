package com.LeetCode;

import java.util.*;

public class No_1338_minSetSize {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> occ = new ArrayList<>(freq.values());
        Collections.sort(occ, Collections.reverseOrder());
        int cnt = 0, ans = 0;
        for (int c : occ) {
            cnt += c;
            ans += 1;
            if (cnt * 2 >= arr.length) {
                break;
            }
        }
        return ans;
    }
}
