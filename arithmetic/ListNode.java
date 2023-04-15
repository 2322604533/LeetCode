package zeus.arithmetic;

import lombok.Data;

@Data
public class ListNode {
	int val = 0;
	ListNode next = null;
	
	ListNode() {}
	ListNode(int val) { this.val = val;	}
	ListNode(int val,ListNode next) {this.val = val; this.next = next;}
}
