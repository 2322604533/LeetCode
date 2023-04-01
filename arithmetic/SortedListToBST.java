package Zeus.arithmetic;

public class SortedListToBST {

    /**
     * 将有序数列转换成二叉平衡树；
     * 二叉平衡树的中序遍历为有序序列，可以采用递归的方式进行
     * -10,-3,0,5,9
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        // 只含有一个结点
        if (head.next == null) return new TreeNode(head.val);

        ListNode slow = head, quick = head, pre = null;

        // 只要定位中心元素=>快慢指针法找中心元素
        while (quick != null && quick.next != null) {
            pre = slow;

            slow = slow.next;

            quick = quick.next.next;
        }

        // pre.next = null; 这句话是用来切割链表的，递归的跳出条件即为空。
        // 否则 root.left = sortedListToBST(head); 会一直往后面到链表最后面。
        pre.next = null;

        // 将找到的链表中间结点为根元素
        TreeNode root = new TreeNode(slow.val);

        root.left = sortedListToBST(head);

        root.right = sortedListToBST(slow.next);

        return root;
    }

}
