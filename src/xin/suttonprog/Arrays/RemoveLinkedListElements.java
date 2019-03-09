package xin.suttonprog.Arrays;

/**
 * TODO...
 *
 * @author codingZhengsz
 * @since 2019-03-09 11:35
 **/
public class RemoveLinkedListElements {

    static class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode q = p;
        while(q.next != null) {
            if(q.next.val == val) {
                ListNode tmp = q.next;
                q.next = tmp.next;
            }else {
                q = q.next;
            }
        }
        return p.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(6);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(6);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        removeElements(node1,6);
    }


}
