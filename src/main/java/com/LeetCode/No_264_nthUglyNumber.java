package com.LeetCode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class No_264_nthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        seen.add(1L);
        queue.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = queue.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    queue.offer(next);
                }
            }
        }
        return ugly;
    }

    public static void main(String[] args) {
        int n = 10;
        No_264_nthUglyNumber solution = new No_264_nthUglyNumber();
        System.out.println(solution.nthUglyNumber(n));
    }
}
