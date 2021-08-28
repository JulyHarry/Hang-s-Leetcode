package MyList;

import Support.ListNode;

import java.util.LinkedList;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/2/21
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(0, head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int l : list) {
            res[i++] = l;
        }
        return res;
    }

    public int[] reversePrint2(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeLast();
        }
        return res;
    }

}
