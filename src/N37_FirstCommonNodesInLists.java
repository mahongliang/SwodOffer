
public class N37_FirstCommonNodesInLists {
	public ListNode findFirstCommListNode(ListNode head1, ListNode head2){
		if (head1 == null || head2 == null) {
			return null;
		}
		
		int length1 = getListLength(head1);
		int length2 = getListLength(head2);
		
		int diff = length1-length2;
		ListNode longlist = head1;
		ListNode shortlist = head2;
		if (diff <0) {
			diff = -diff;
			longlist = head2;
			shortlist = head1;
		}
		
		while(diff > 0){
			longlist = longlist.next;
			diff--;
		}
		
		while(longlist != null && shortlist != null && longlist != shortlist){
			shortlist = shortlist.next;
			longlist = longlist.next;
		}
		
		return longlist;	
	}
	
	private int getListLength(ListNode head){
		int length=0;
		while(head != null){
			length++;
			head = head.next;
		}
		return length;
	}
	
	public static void main(String[] args) {
		 // 第一个公共结点在链表中间
        // 1 - 2 - 3 \
        //            6 - 7
        //     4 - 5 /
		N37_FirstCommonNodesInLists test = new N37_FirstCommonNodesInLists();
		
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n6;
        n6.next = n7;
        n4.next = n5;
        n5.next = n6;
        System.out.println(test.findFirstCommListNode(n1, n4).val); // 6
	}
	
	
}
