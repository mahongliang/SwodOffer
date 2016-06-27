

public class N15_KthNodeFromEnd {

	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x){
			val = x;
		}
	}
	public ListNode findKthToTail(ListNode head, int k){
		if (head == null || k==0) {
			return null;
		}
		ListNode first = head;
		ListNode sencond = null;
		
		for (int i = 0; i < k-1; i++) {
			if (first.next != null) {
				first = first.next;
			}else {
				return null;
			}
		}
		
		sencond = head;
		while(first.next != null){
			first = first.next;
			sencond = sencond.next;
		}
		
		return sencond;
	}
	
	public void print(ListNode head){
		while(head != null){
			System.out.print(head.val+" ");
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		N15_KthNodeFromEnd test = new N15_KthNodeFromEnd();
		ListNode n1 = test.new ListNode(1);
		ListNode n2 = test.new ListNode(2);
		ListNode n3 = test.new ListNode(3);
		ListNode n4 = test.new ListNode(4);
		ListNode n5 = test.new ListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		//test.findKthToTail(n1, 1);
		test.print(test.findKthToTail(n1, 5));
	}
}
