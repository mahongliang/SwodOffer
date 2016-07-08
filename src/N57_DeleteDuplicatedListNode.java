import java.awt.print.Printable;


public class N57_DeleteDuplicatedListNode {
	public ListNode deleteDuplication(ListNode head){
		if (head == null) {
			return null;
		}
		
		ListNode dummyhead = new ListNode(-1);
		dummyhead.next = head;
		ListNode node = head;
		ListNode prev = dummyhead;
		while(node != null && node.next != null){
			if (node.val == node.next.val) {
				while(node.next != null && node.val == node.next.val){
					node = node.next;
				}
				prev.next = node.next;
			}else {
				prev.next = node;			
				prev = prev.next;
			}
			node = node.next;
		}
		return dummyhead.next;
	}
	
	public void print(ListNode head){
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	public static void main(String[] args) {
		// 1->1->2->3->3->4->5->5
		N57_DeleteDuplicatedListNode test = new N57_DeleteDuplicatedListNode();
		ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        ListNode n8 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        ListNode result = test.deleteDuplication(n1);
        test.print(result);
	}
}
