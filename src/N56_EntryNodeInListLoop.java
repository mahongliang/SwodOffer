
public class N56_EntryNodeInListLoop {
	public ListNode entryNodeInListLoop(ListNode head){
		ListNode meetingNode = meetingNode(head);
		if (meetingNode == null) {
			return null;
		}
		
		int nodesInLoop = 1;
		ListNode temp = meetingNode;
		while(temp.next != meetingNode){
			nodesInLoop++;
			temp = temp.next;
		}
		
		temp = head;
		for (int i = 0; i < nodesInLoop; i++) {
			temp = temp.next;
		}
		
		ListNode temp1 = head;
		while(temp != temp1){
			temp = temp.next;
			temp1 = temp1.next;
		}
		
		return temp;
	}
	
	public ListNode meetingNode(ListNode head){
		
		if (head == null) {		
			return null;
		}
		ListNode slow = head.next;
		if (slow == null) {
			return null;
		}
		
		ListNode fast = slow.next;
		while(fast != null && slow != null){
			if (fast == slow) {
				return fast;
			}
			
			slow = slow.next;		
			fast = fast.next;
			if (fast !=null) {
				fast = fast.next;
			}
		}	
		return null;
	}
	public static void main(String[] args) {
		N56_EntryNodeInListLoop test = new N56_EntryNodeInListLoop();
		// 1->2->3->4->5->6
	    //       ^        |
	    //       |        |
	    //       +--------+
		ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n3;
        System.out.println(test.entryNodeInListLoop(n1).val);
	}
}
