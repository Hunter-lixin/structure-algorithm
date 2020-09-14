package com.LeetCode;

/**
 * NO.3 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * <p>
 * 示例1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String input) {
        if ("".equals(input) || input == null) {
            return 0;
        }

        int i = 0, k, max = 0;
        char[] charArray = input.toCharArray();
        int length = charArray.length;

        for (int j = 0; j < length; j++) {
            for (k = i; k < j; k++) {
                if (charArray[k] == charArray[j]) {
                    i = k + 1;
                    break;
                }
            }

            max = Math.max(max, j - i + 1);
        }

        return max;

        /*
        int result = 0;
        List<Character> list = new ArrayList<>();
        char[] charArray = input.toCharArray();
        int lenght = charArray.length;

        for (int i = 0; i < lenght; i++) {
            list = new ArrayList<>();
            list.add(charArray[i]);
            for (int j = i + 1; j < lenght; j++) {
                if (list.contains(charArray[j])) {
                    break;
                }
                list.add(charArray[j]);
            }
            result = Math.max(result, list.size());
        }
        return result;*/
    }

    public static void main(String[] args) {

        String input = "bbbbb";
        int result = lengthOfLongestSubstring(input);
        System.out.println(result);

    }

}
