package Zeus.arithmetic;

public class DeleteDuplicates {
    /**
     * 删除有序链表中重复的数字
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        if (head.val != head.next.val) {
            // 两个结点的值不相等
            head.next = deleteDuplicates(head.next);
        } else {
            // 删除两个值相等结点
            ListNode temp = head;
            while (temp != null && temp.val == head.val) {
                temp = temp.next;
            }
            head = deleteDuplicates(temp);
        }
        return head;
    }
}
