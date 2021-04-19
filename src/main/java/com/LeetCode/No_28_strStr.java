package com.LeetCode;

public class No_28_strStr {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        No_28_strStr solution = new No_28_strStr();
        System.out.println(solution.strStr(haystack, needle));
    }
}
