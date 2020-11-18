package com.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveSortTest {

    RecursiveSort recursiveSort = new RecursiveSort();

    @Test
    void sort() {
        int[] arr = new int[]{1, 5, 2, 4, 3, 0};
        int[] ans = new int[]{0, 1, 2, 3, 4, 5};
        recursiveSort.sort(arr);

        assertArrayEquals(ans, arr);
    }

    @Test
    void sort_with_two_arr() {
        int[] arr = new int[]{2, 1};
        int[] ans = new int[]{1, 2};
        recursiveSort.sort(arr);

        assertArrayEquals(ans, arr);
    }

}