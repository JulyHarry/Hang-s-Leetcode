import LIST.List;
import Support.ListNode;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSum {

    /*
    1171 remove-zero-sum-consecutive-nodes-from-linked-list/
    https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
     */
    public static ListNode removeZeroSumSublists1(ListNode head) {
        int prefix = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> seen = new HashMap<>();
        seen.put(0, dummy);
        for (ListNode i = dummy; i != null; i = i.next) {
            prefix += i.val;
            seen.put(prefix, i);
        }
        prefix = 0;
        for (ListNode i = dummy; i != null; i = i.next) {
            prefix += i.val;
            i.next = seen.get(prefix).next;
        }
        return dummy.next;
    }

    public static ListNode removeZeroSumSublists2(ListNode head) {
        ListNode dummy = new ListNode(0), cur = dummy;
        dummy.next = head;
        int prefix = 0;
        Map<Integer, ListNode> seen = new HashMap<>();
        while (cur != null) {
            prefix += cur.val;
            if (seen.containsKey(prefix)) {
                cur =  seen.get(prefix).next;
                int p = prefix + cur.val;
                while (p != prefix) {
                    seen.remove(p);
                    cur = cur.next;
                    p += cur.val;
                }
                seen.get(prefix).next = cur.next;
            } else {
                seen.put(prefix, cur);
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(-3);
        ListNode node5 = new ListNode(-2);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(5);
        ListNode node8 = new ListNode(-5);
        ListNode node9 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        ListNode node = null;
        node = removeZeroSumSublists1(node1);
        while (node.next!=null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println(node.val);
        node = removeZeroSumSublists2(node1);
        while (node.next!=null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println(node.val);
    }
}
