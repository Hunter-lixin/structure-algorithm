package com.LeetCode;

/**
 * NO.2 两数相加
 * 给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;

        int carry = 0;
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;

            int sum = carry + x + y;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 4, 3};
        int[] nums2 = new int[]{5, 6, 4};

        ListNode listNode1 = new ListNode(0), listNode2 = new ListNode(0);
        ListNode l1 = listNode1, l2 = listNode2;

        for (int i : nums1) {
            l1.next = new ListNode(i);
            l1 = l1.next;
        }

        for (int i : nums2) {
            l2.next = new ListNode(i);
            l2 = l2.next;
        }

        ListNode resultListNode = addTwoNumbers(listNode1.next, listNode2.next);
        while (resultListNode != null) {
            System.out.println(resultListNode.val);
            resultListNode = resultListNode.next;

        }

    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
