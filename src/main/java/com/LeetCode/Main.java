package com.LeetCode;

import java.util.*;

public class Main {

    public static class MyNode{
        private int preValue;
        private int nextValue;

        public MyNode(int preValue, int nextValue) {
            this.preValue = preValue;
            this.nextValue = nextValue;
        }

        public int getPreValue() {
            return preValue;
        }

        public int getNextValue() {
            return nextValue;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodeCount = sc.nextInt();
        int length = sc.nextInt();
        sc.nextLine();

        List<MyNode> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int preValue = sc.nextInt();
            int nextValue = sc.nextInt();
            list.add(new MyNode(preValue, nextValue));
            list.add(new MyNode(nextValue, preValue));
            sc.nextLine();
        }

        int num = sc.nextInt();

        int ans = 0;
        for (int i = 1; i < nodeCount + 1; i++) {
            ans = Math.max(ans, getTime(list, num, i));
        }

        System.out.println(ans * 2);

    }

    public static int getTime(List<MyNode> list, int key, int expect) {
        if (key == expect) {
            return 1;
        }
        for (MyNode myNode : list) {
            if (myNode.getPreValue() == key && myNode.getNextValue() == expect) {
                return 1;
            }
        }

        int ans = 0;
        for (MyNode myNode : list) {
            if (myNode.preValue == key && myNode.nextValue != expect) {
                int temp =  getTime(list, myNode.nextValue, expect);

                if (ans > 0 && temp > 0) {
                    ans = Math.min(ans, temp);
                } else if (ans == 0 && temp > 0) {
                    ans = temp;
                }
            }
        }

        return ans;
    }

}
