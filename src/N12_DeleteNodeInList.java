


public class N12_DeleteNodeInList {
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x){
			val = x;
		}
	}
	public void deleteNode(ListNode head, ListNode node){
		if (head == null || node == null) {
			return;
		}
		
		if (node.next != null) { 
			node.val = node.next.val;
			node.next = node.next.next;
		}else if (head == node) {
			head = null;
		}else {
			ListNode temp = head;
			while(temp.next != node){
				temp = temp.next;
			}
			
			temp.next = null;
		}
	}
}
