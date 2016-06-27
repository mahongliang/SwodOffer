

public class N16_ReverList {
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x){
			val = x;
		}
	}
	
	public ListNode reservList(ListNode head){
		ListNode pre = null;
		ListNode current = head;
		
		while(current != null){
			ListNode temp = current.next;
			current.next = pre;
			pre = current;
			current = temp;
		}
		
		return pre;
			
	}
	public void print(ListNode head){
		while(head != null){
			System.out.print(head.val+" ");
			head = head.next;
		}
	}
	public static void main(String[] args) {
		N16_ReverList test = new N16_ReverList();
		ListNode n1 = test.new ListNode(1);
		ListNode n2 = test.new ListNode(2);
		ListNode n3 = test.new ListNode(3);
		ListNode n4 = test.new ListNode(4);
		ListNode n5 = test.new ListNode(5);
		
//		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
//		
		//test.findKthToTail(n1, 1);
		test.print(test.reservList(n1));
	}
}
