package xin.suttonprog.LinkedList;


public class _206ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 采用循环算法
    static class Solution1 {
        public ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode pre = null;

            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }

    // 采用递归算法
    static class Solution2 {
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null ) {
                return head;
            }
            ListNode rhead = reverseList(head.next);
            head.next.next = head;
            head.next = null;

            return rhead;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        ListNode reverser = new Solution2().reverseList(node1);
        System.out.println(reverser.val);
    }


}
