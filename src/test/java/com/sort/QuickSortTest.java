package com.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    QuickSort quickSort = new QuickSort();

    @Test
    void sort_with_one_element() {
        int[] arr = new int[]{1};
        int[] expectResult = new int[]{1};
        quickSort.sort(arr);
        assertArrayEquals(expectResult, arr);
    }

    @Test
    void sort_with_two_element() {
        int[] arr = new int[]{2, 1};
        int[] expectResult = new int[]{1, 2};
        quickSort.sort(arr);
        assertArrayEquals(expectResult, arr);
    }

    @Test
    void sort_with_three_element() {
        int[] arr = new int[]{3, 2, 1};
        int[] expectResult = new int[]{1, 2, 3};
        quickSort.sort(arr);
        assertArrayEquals(expectResult, arr);
    }

    @Test
    void sort_with_random_element() {
        int[] arr = generateRandomArray(100, 15);
        int[] expectedArr = new int[arr.length];
        System.arraycopy(arr, 0, expectedArr, 0, expectedArr.length);
        quickSort.sort(arr);
        Arrays.sort(expectedArr);
        assertArrayEquals(expectedArr, arr);
    }


    public int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize - 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue - 1) * Math.random());
        }

        return arr;
    }
}