package com.LeetCode;

import java.util.Stack;

/**
 * 题目描述：
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class EffectiveBracketCount {

    public static int countEffectiveBracket(String bracketStr) {
        if ("".equals(bracketStr) || bracketStr == null) {
            return 0;
        }

        int count = 0;

        Stack<Integer> stack = new Stack<>();
        int index = -1;

        char[] charArray = bracketStr.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            if ('(' == c) {
                stack.push(i);
            } else if (')' == c) {
                if (stack.empty()) {
                    index = i + 1;
                } else {
                    stack.pop();
                    count = stack.isEmpty() ? Math.max(count, i - index) : Math.max(count, i - stack.peek());
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String bracketStr = "()()";
//        String bracketStr = "()(()()(";
        int count = countEffectiveBracket(bracketStr);

        System.out.println(count);

    }

}
