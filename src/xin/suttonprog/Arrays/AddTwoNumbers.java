package xin.suttonprog.Arrays;

/**
 * TODO...
 *
 * @author codingZhengsz
 * @since 2019-03-04 19:40
 **/
public class AddTwoNumbers {

    static class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1,ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode p = l1,q = l2,tail = head;

        while(p != null || q != null) {
            int val1 = (p == null) ? 0 : p.val;
            int val2 = (q == null) ? 0 : q.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if(p != null) {
                p = p.next;
            }
            if(q != null) {
                q = q.next;
            }
        }
        if(carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head.next;
    }

    public static void main(String[] args) {

    }

}
