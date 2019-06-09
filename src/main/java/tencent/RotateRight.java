package tencent;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 */
public class RotateRight {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String... args) {
        RotateRight rotateRight = new RotateRight();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = new ListNode(7);
        ListNode result = rotateRight.rotateRight(root, 0);
        rotateRight.print(result);

    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int length = 1;
        ListNode once = head;
        while (once.next != null) {
            length++;
            once = once.next;
        }
        once.next = head;
        int moveStep = k % length;

        ListNode moveNode = head;
        for (int i = 0; i < length - moveStep - 1; i++) {
            moveNode = moveNode.next;
        }
        ListNode next = moveNode.next;
        once.next = head;
        moveNode.next = null;
        return next;
    }

    private void print(ListNode head) {
        ListNode once = head;
        while (once != null) {
            System.out.print(once.val + "->");
            once = once.next;
        }
        System.out.println();
    }
}
