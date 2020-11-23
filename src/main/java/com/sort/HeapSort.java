package com.sort;

/**
 * 堆排序
 */
public class HeapSort {
    public void sort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    public void heapInsert(int[] arr, int index) {

        while ((index - 1) >> 1 >= 0 && arr[index] > arr[(index - 1) >> 1]) {
            swap(arr, index, (index - 1) >> 1);
            index = (index - 1) >> 1;
        }
    }

    public void heapify(int[] arr, int index, int heapSize) {
        int left = (index << 1) + 1;
        while (left < heapSize) {
            int largest = (left + 1) < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (index == largest) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = (index << 1) + 1;
        }
    }

    public void swap(int[] arr, int source, int target) {
        if (arr[source] == arr[target]) return;
        arr[source] = arr[source] ^ arr[target];
        arr[target] = arr[source] ^ arr[target];
        arr[source] = arr[source] ^ arr[target];
    }
}
