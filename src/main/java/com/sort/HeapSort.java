package com.sort;

/**
 * 堆排序
 */
public class HeapSort {
    public void sort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }

        //  原始经典堆排序
        /*for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }*/

        // 优化的堆排序
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
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
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
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
