package tencent;

/**
 * Created by weixiaolong on 2019/3/10.
 */
public class AddTwoNumber {

    public static void main(String... args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode two = l2;
        ListNode head;
        ListNode pre = new ListNode(0);
        head = pre;
        while (first != null || two != null || pre.val >= 10) {
            boolean carry = false;
            if (pre.val >= 10) {
                carry = true;
                pre.val = pre.val - 10;
            }
            ListNode next = createNode(first, two, carry);
            if (first != null) {
                first = first.next;
            }
            if (two != null) {
                two = two.next;
            }
            pre.next = next;
            pre = next;
        }
        return head.next;
    }

    ListNode createNode(ListNode l1, ListNode l2, boolean carry) {
        int val = carry ? 1 : 0;
        if (l1 == null && l2 == null) {
        } else if (l1 == null && l2 != null) {
            val = val + l2.val;
        } else if (l2 == null && l1 != null) {
            val = val + l1.val;
        } else {
            val = val + l1.val + l2.val;
        }
        return new ListNode(val);
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}