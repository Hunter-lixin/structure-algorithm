package com.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * String[] fun(String[] arr1, String[] arr2)
 * 输入：两个String数组
 * 输出：一个String数组
 * 要求输出两个数组中满足如下条件的字符串集合：在其中一个数组中只出现1次，在另外一个数组中没有出现
 * 举例：输入 {“aa”,”bb”,”cc”,”aa”} {“bb”,”dd”,”cc”},输出{“dd”};
 */
public class Main {

    public static String[] getUniArr(String[] arr1, String[] arr2) {

        List<String> list = new ArrayList<>();
        list.addAll(getListInFirstArr(arr1, arr2));
        list.addAll(getListInFirstArr(arr2, arr1));

        return list.toArray(new String[0]);
    }

    public static List<String> getListInFirstArr(String[] arr1, String[] arr2) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            boolean existsInArr1 = false;
            for (int j = 0; j < arr1.length; j++) {
                if (i != j && arr1[i].equals(arr1[j])) {
                    existsInArr1 = true;
                    break;
                }
            }

            if (!existsInArr1) {
                boolean existsInArr2 = false;
                for (String s : arr2) {
                    if (arr1[i].equals(s)) {
                        existsInArr2 = true;
                        break;
                    }
                }
                if (!existsInArr2) {
                    list.add(arr1[i]);
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {

        String[] arr1 = new String[]{"aa", "bb", "cc"};
        String[] arr2 = new String[]{"dd", "bb", "cc"};

        System.out.println(Arrays.asList(getUniArr(arr1, arr2)));

    }

}
