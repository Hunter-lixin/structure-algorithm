package com.LeetCode;

public class No_30001_minMovesToCaptureTheQueen {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        // 车与皇后处在同一行，且中间没有象
        if (a == e && (c != a || d <= Math.min(b, f) || d >= Math.max(b, f))) {
            return 1;
        }
        // 车与皇后处在同一列，且中间没有象
        if (b == f && (d != b || c <= Math.min(a, e) || c >= Math.max(a, e))) {
            return 1;
        }
        // 象、皇后处在同一条对角线，且中间没有车
        if (Math.abs(c - e) == Math.abs(d - f) && ((c - e) * (b - f) != (a - e) * (d - f)
                || a < Math.min(c, e) || a > Math.max(c, e))) {
            return 1;
        }
        return 2;
    }
}
