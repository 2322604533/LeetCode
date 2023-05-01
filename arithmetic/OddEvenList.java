package zeus.arithmetic;

public class OddEvenList {

    /**
     * 奇偶链表
     * 时间复杂度O(1),空间复杂度O(n)
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
         if (head == null) return head;

         ListNode evenHead = head.next;
         ListNode odd = head;
         ListNode even = evenHead;

         while (even != null && even.next != null) {
             odd.next = even.next;
             odd = odd.next;

             even.next = odd.next;
             even = even.next;
         }
        odd.next = evenHead;
        return head;
    }
}
