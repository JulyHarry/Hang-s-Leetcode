import LIST.List;
import Support.ListNode;

public class RemoveNthFromEnd {
    public static ListNode removeA1(ListNode head, int n){
        // 注意学习双指针，一快一慢的思想
        ListNode headNode = new ListNode(0);
        ListNode fastNode = headNode;
        ListNode slowNode = headNode;
        headNode.next = head;
        if (head.next == null) return null;
        for (int i = 0; i < n + 1; i++){
            fastNode = fastNode.next;
        }
        while (fastNode != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        slowNode.next = slowNode.next.next;
        return headNode.next;
    }

    public static ListNode removeA2(ListNode head, int n){
        int cnt = 0;
        int tar = 0;
        ListNode k = head;
        ListNode m = head;
        if (k.next == null) return k.next;
        while (k.next != null){
            cnt++;
            k = k.next;
            if (k.next == null) cnt++;
        }
        while (m.next != null){
            tar++;
            if (cnt == n || n > cnt) {
                return head.next;
            }
            if (tar == cnt - n) {
                if (m.next.next != null){
                    m.next = m.next.next;
                    return head;
                }else {
                    m.next = null;
                    return head;
                }
            }else m = m.next;
        }
        return head;
    }

    public  ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prenode = new ListNode(0);
        prenode.next = head;
        ListNode first = prenode;
        ListNode second = prenode;
        if (head.next == null) return null;
        for (int i=0; i<n+1; i++) {
            first = first.next;
        }
        while (first.next!=null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return prenode.next;
    }
}
