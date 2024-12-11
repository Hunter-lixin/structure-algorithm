package com.LeetCode;

import java.util.PriorityQueue;

public class No_2931_maxSpending {
    public long maxSpending(int[][] values) {
        int m = values.length, n = values[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{values[i][n - 1], i, n - 1});
        }

        long ans = 0;
        for (int turn = 1; turn <= m * n; turn++) {
            int[] top = pq.poll();
            int val = top[0], i = top[1], j = top[2];
            ans += (long) val * turn;
            if (j > 0) {
                pq.offer(new int[]{values[i][j - 1], i, j - 1});
            }
        }
        return ans;
    }
}
