package com.sort;

/**
 * 快速排序
 */
public class QuickSort {

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        process(arr, 0, arr.length - 1);
    }

    public void process(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
        int[] equalArea = netherlandsFlag(arr, left, right);
        process(arr, left, equalArea[0] - 1);
        process(arr, equalArea[1] + 1, right);
    }

    public static int[] netherlandsFlag(int[] arr, int left, int right) {
        if (left > right) {
            return new int[]{-1, -1};
        } else if (left == right) {
            return new int[]{left, right};
        }

        int less = left - 1;
        int more = right;
        int index = left;

        while (index < more) {
            if (arr[index] < arr[right]) {
                swap(arr, index++, ++less);
            } else if (arr[index] > arr[right]) {
                swap(arr, index, --more);
            } else {
                index++;
            }
        }
        swap(arr, more, right);
        return new int[]{less + 1, more};
    }

    /**
     * 数组两数交换
     * @param arr 数组
     * @param current 当前位置
     * @param target  目标位置
     */
    public static void swap(int[] arr, int current, int target) {
        if (arr[current] == arr[target]) return;
        arr[current] = arr[current] ^ arr[target];
        arr[target] = arr[current] ^ arr[target];
        arr[current] = arr[current] ^ arr[target];
    }
}
