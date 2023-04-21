package zeus.arithmetic;

import java.util.List;

public class RemoveElements {

    /**
     * 移除链表元素
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);

        dummyHead.next = head;

        ListNode cur = dummyHead;

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();

        head = removeElements(head, 2);


    }
}
