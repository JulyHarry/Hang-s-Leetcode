import Support.ListNode;

public class RemoveDuplicatesfromSortedList {
    /**
     * 由于链表开头可能会有重复项，被删掉的话头指针会改变，而最终却还需要返回链表的头指针。
     * 所以需要定义一个新的节点，然后链上原链表.
     * */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null){
            if (current.val == current.next.val) {
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return head; // attention: must return head or there will be no the first item.
    }
}
