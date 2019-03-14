package com.example.demo;

/**
 * Created by weixiaolong on 2019/1/13.
 */
public class LinkExample {
    public static void main(String... args) {
        ListNode root = new ListNode(1);

        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = new ListNode(7);
        LinkExample l = new LinkExample();
//        l.oddEvenList(root);
//        l.print(l.reverseList(root));
        l.print(l.delete(root, 7));
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode odd = null;
        ListNode oddIndex = null;
        ListNode even = null;
        ListNode evenIndex = null;

        ListNode next = head;
        int i = 1;
        while (next != null) {
            ListNode cur = next;
            next = cur.next;
            if (i % 2 == 1) {
                //odd
                if (odd == null) {
                    odd = cur;
                    oddIndex = odd;
                } else {
                    oddIndex.next = cur;
                    oddIndex = oddIndex.next;
                }
            } else {
                //even
                if (even == null) {
                    even = cur;
                    evenIndex = even;
                } else {
                    evenIndex.next = cur;
                    evenIndex = evenIndex.next;
                }
            }
            i++;
        }
        if (even != null) {
            oddIndex.next = even;
            evenIndex.next = null;
        }
        print(odd);
        return odd;
    }

    public void print(ListNode n) {
        ListNode c = null;
        c = n;
        while (c != null) {
            System.out.print(c.val + " ");
            c = c.next;
        }
    }

        public ListNode reverseList(ListNode head) {
            ListNode pre = head;
            ListNode cur = pre.next;
            ListNode next = null;
            head.next = null;
            while (cur != null) {
                next = cur.next;

                cur.next = pre;

                pre = cur;
                cur = next;
            }
            return pre;
        }

    public ListNode delete(ListNode head, Integer val) {
        ListNode result = head;
        ListNode index = head.next;
        ListNode pre = head;
        while (index != null) {
            if (index.val == val) {
                pre.next = index.next;
                index = index.next;
            } else {
                pre = index;
                index = index.next;
            }
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
