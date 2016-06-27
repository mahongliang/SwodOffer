

public class N17_MergeSortedLists {

	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x){
			val = x;
		}
	}
	
	public ListNode mergeSortedLists(ListNode head1, ListNode head2){
		if (head1 ==null) {
			return head2;
		}
		
		if (head2 == null) {
			return head1;
		}
		
		
		ListNode mergeHead = null;
		
		if (head1.val < head2.val) {
			mergeHead = head1;
			mergeHead.next = mergeSortedLists(head1.next, head2);
		}else {
			mergeHead = head2;
			mergeHead.next = mergeSortedLists(head1, head2.next);
		}
		
		return mergeHead;
	}
	public void print(ListNode head){
		while(head != null){
			System.out.print(head.val+" ");
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		N17_MergeSortedLists test= new N17_MergeSortedLists();
		ListNode n1 = test.new ListNode(1);
		ListNode n2 = test.new ListNode(2);
		ListNode n3 = test.new ListNode(3);
		ListNode n4 = test.new ListNode(4);
		ListNode n5 = test.new ListNode(5);
		
//		n1.next = n3;
//		n3.next = n5;
//		
//		n2.next = n4;
		
		test.print(test.mergeSortedLists(n1, n2));
		
		
		
		
	}
}
