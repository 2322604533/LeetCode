package zeus.arithmetic;

public class SwapPairs {
	
	@SuppressWarnings("all")
	public ListNode swapPairs(ListNode head) {
		ListNode pre = new ListNode(0);
		
		pre.next = head;
		
		ListNode tempNode = pre;
		
		while (tempNode.next != null && tempNode.next.next != null) {
			ListNode firstPiont = tempNode.next;
			ListNode secondPiont = tempNode.next.next;
			
			//交换结点
			tempNode.next = secondPiont;
			firstPiont.next = secondPiont.next;
			secondPiont.next = firstPiont;
			tempNode = firstPiont;
		}
		return pre.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
