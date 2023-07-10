import java.util.LinkedList;
import java.util.Stack;

public class addTwoNum {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }



    public static void main(String[] args) {
        ListNode a=new ListNode(9);
        ListNode b=new ListNode(9,a);
        ListNode c=new ListNode(9,b);
        ListNode h=new ListNode(9,c);
        ListNode i=new ListNode(9,h);
        ListNode j=new ListNode(9,i);
        ListNode k=new ListNode(9,j);
        ListNode d=new ListNode(9);
        ListNode e=new ListNode(9,d);
        ListNode f=new ListNode(9,e);
        ListNode g=new ListNode(9,f);
        ListNode result=addTwoNum.addTwoNumbers(k,g);
        System.out.println();

    }
}
