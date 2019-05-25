package xin.suttonprog.LinkedList;

import java.util.List;

public class _92ReverseLinkedListII {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 循环方法逆置链表
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
    // Memory Usage: 33.4 MB, less than 100.00% of Java online submissions for Reverse Linked List II.
    static class Solution1 {
        ListNode reverseBetween(ListNode head, int m, int n) {
            if(head == null) {
                return head;
            }
            int change_len = n-m+1; // 需要逆置的节点个数
            ListNode pre_head = null; // 初始化开始逆置的前驱节点
            ListNode result = head; // 最终的链表头节点
            while(head != null && --m > 0) { // 将head向前移动m-1和位置
                pre_head = head;
                head = head.next;
            }
            // 将modify_list_tail指向当前的head，就是逆置之后的尾节点
            ListNode modify_list_tail = head;
            ListNode new_head = null; // 逆置之后的头节点
            while (head != null && change_len > 0) {
                ListNode next = head.next;
                head.next = new_head;
                new_head = head;
                head = next;
                change_len --;
            }
            modify_list_tail.next = head; // 连接逆置之后的尾节点与逆置段的后一个节点
            if(pre_head != null) { // pre_head不为空说明不是从第一个节点开始逆置
                pre_head.next = new_head; // 将逆置链表开始的节点前驱与逆置后的头节点链表
            }else{ // 说明从第一个节点开始逆置，结果为逆置之后的头节点
                result = new_head;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode reverser = new Solution1().reverseBetween(node1,2,4);
        while(reverser != null) {
            System.out.println(reverser.val);
            reverser = reverser.next;
        }
    }

}
