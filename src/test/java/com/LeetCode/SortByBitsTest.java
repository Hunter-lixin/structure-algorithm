package com.LeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortByBitsTest {

    SortByBits sortByBits = new SortByBits();

    /**
     * 输入：arr = [0,1,2,3,4,5,6,7,8]
     * 输出：[0,1,2,4,8,3,5,6,7]
     * 解释：[0] 是唯一一个有 0 个 1 的数。
     * [1,2,4,8] 都有 1 个 1 。
     * [3,5,6] 有 2 个 1 。
     * [7] 有 3 个 1 。
     * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
     *
     */
    @Test
    void sortByBits_1() {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] res = new int[]{0, 1, 2, 4, 8, 3, 5, 6, 7};
        assertArrayEquals(res, sortByBits.sortByBits(arr));
    }

    /**
     * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
     * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
     * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
     */
    @Test
    void sortByBits_2() {
        int[] arr = new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        int[] res = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
        assertArrayEquals(res, sortByBits.sortByBits(arr));
    }

    /**
     * 输入：arr = [10000,10000]
     * 输出：[10000,10000]
     */
    @Test
    void sortByBits_3() {
        int[] arr = new int[]{10000,10000};
        int[] res = new int[]{10000,10000};
        assertArrayEquals(res, sortByBits.sortByBits(arr));
    }

}