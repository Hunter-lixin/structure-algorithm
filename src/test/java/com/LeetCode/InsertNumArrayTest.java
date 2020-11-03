package com.LeetCode;

import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Interval;

import static org.junit.jupiter.api.Assertions.*;

class InsertNumArrayTest {
    InsertNumArray insertNumArray = new InsertNumArray();

    /**
     * 示例1：
     * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
     * 输出：[[1,5],[6,9]]
     */
    @Test
    void insert_test_1() {
        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval = new int[]{2, 5};
        int[][] result = new int[][]{{1, 5}, {6, 9}};

//        int[][] ans = insertNumArray.insert(intervals, newInterval);
//        for (int i = 0; i < result.length; i++) {
//            assertArrayEquals(result[i], ans[i]);
//        }
        assertArrayEquals(result, insertNumArray.insert(intervals, newInterval));
    }

    /**
     * 示例2：
     * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * 输出：[[1,2],[3,10],[12,16]]
     */
    @Test
    void insert_test_2() {
        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = new int[]{4, 8};
        int[][] result = new int[][]{{1, 2}, {3, 10}, {12, 16}};
        assertArrayEquals(result, insertNumArray.insert(intervals, newInterval));
    }
}