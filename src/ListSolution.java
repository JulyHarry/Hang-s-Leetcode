import Support.ListNode;

import java.util.Stack;

public class ListSolution {
    public static ListNode reverseList(ListNode head) {
        Stack<Integer> s = new Stack<Integer>();
        while(head.next!=null) {
            s.push(head.val);
            head = head.next;
        }
        ListNode root = head;
        while (!s.isEmpty()) {
            head.next = new ListNode(s.pop());
            head = head.next;
        }
        return root;
    }

    public static void print (ListNode l) {
        while(l!=null) {
            System.out.print(l.val+" ");
            l = l.next;
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        print(a1);
        print(reverseList(a1));
    }
}
