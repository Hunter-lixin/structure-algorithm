package com.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class RecursiveSort {

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        process(arr, 0, arr.length - 1);
    }

    public void process(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }

        int middle = left + ((right - left) >> 1);

        process(arr, left, middle);
        process(arr, middle + 1, right);
        merge(arr, left, middle, right);
    }

    public void merge(int[] arr, int left, int middle, int right) {
        int[] helpArr = new int[right - left + 1];
        int i = 0, pLeft = left, pRight = middle + 1;

        while (pLeft <= middle && pRight <= right) {
            helpArr[i++] = arr[pLeft] <= arr[pRight] ? arr[pLeft++] : arr[pRight++];
        }

        while (pLeft <= middle) {
            helpArr[i++] = arr[pLeft++];
        }

        while (pRight <= right) {
            helpArr[i++] = arr[pRight++];
        }

        if (helpArr.length >= 0) System.arraycopy(helpArr, 0, arr, left, helpArr.length);
    }
}
