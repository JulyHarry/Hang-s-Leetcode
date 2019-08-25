import Support.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode headNode = new ListNode(0);
        ListNode current = headNode;
        headNode.next = head;
        while (current.next != null && current.next.next != null){
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            second.next = first;
            current.next = second;
            current = current.next.next;
        }
        return headNode.next;
    }

    public ListNode swapPairsA2(ListNode head){
        // 没弄懂
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode  = head.next;
        head.next = swapPairs(nextNode.next);
        nextNode.next = head;
        return nextNode;
    }
}
