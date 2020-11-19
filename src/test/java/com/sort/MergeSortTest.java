package com.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    MergeSort mergeSort = new MergeSort();

    @Test
    void sort() {
        int[] arr = new int[]{1, 5, 2, 4, 3, 0};
        int[] ans = new int[]{0, 1, 2, 3, 4, 5};
        mergeSort.sort(arr);

        assertArrayEquals(ans, arr);
    }

    @Test
    void sort_with_two_arr() {
        int[] arr = new int[]{2, 1};
        int[] ans = new int[]{1, 2};
        mergeSort.sort(arr);

        assertArrayEquals(ans, arr);
    }

}