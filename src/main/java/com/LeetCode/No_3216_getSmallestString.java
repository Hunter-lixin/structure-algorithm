package com.LeetCode;

public class No_3216_getSmallestString {
    public String getSmallestString(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i + 1 < arr.length; i++) {
            if (arr[i] > arr[i + 1] && arr[i] % 2 == arr[i + 1] % 2) {
                char temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                break;
            }
        }
        return new String(arr);
    }
}
