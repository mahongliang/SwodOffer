
public class N26_CopyComplexList {

	public class ComplexListNode{
		int value;
		ComplexListNode next;
		ComplexListNode sibling;
	}
	
	public ComplexListNode clone(ComplexListNode head){
		if (head == null) {
			return null;
		}
		
		clonesNode(head);
		connectNodes(head);
		return reconnectNodes(head);
	}
	
	public void clonesNode(ComplexListNode head){
		while( head != null){
			ComplexListNode tmp = new ComplexListNode();
			tmp.value = head.value;
			tmp.next = head.next;
			head.next = tmp;
			head = tmp.next;
		}
	}
	
	public void connectNodes(ComplexListNode head){
		while( head != null){
			if (head.sibling != null) {
				head.next.sibling = head.sibling.next;
			}
			head = head.next.next;
		}
	}
	
	public ComplexListNode reconnectNodes(ComplexListNode head){
		if (head == null) {
			return null;
		}
		
		ComplexListNode newHead = head.next;
		ComplexListNode pointer = newHead;
		head.next = newHead.next;
		head = head.next;
		
		while(head != null){
			pointer.next = head.next;
			pointer = pointer.next;
			
			head.next = pointer.next;
			head = head.next;		
		}
		return newHead;	
	}
	
	public void printList(ComplexListNode head){
		while(head != null){
			System.out.print(head.value + "->");
			head = head.next;
		}
		System.out.println("null");
	}
	
	public static void main(String[] args) {
		
		N26_CopyComplexList test = new N26_CopyComplexList();
		 	ComplexListNode head = test.new ComplexListNode();
	        head.value = 1;
	        head.next = test.new ComplexListNode();
	        head.next.value = 2;
	        head.next.next = test.new ComplexListNode();
	        head.next.next.value = 3;
	        head.next.next.next = test.new ComplexListNode();
	        head.next.next.next.value = 4;
	        head.next.next.next.next = test.new ComplexListNode();
	        head.next.next.next.next.value = 5;
	        head.sibling = head.next.next;
	        head.next.sibling = head.next.next.next.next.next;
	        head.next.next.next.sibling = head.next;
	        ComplexListNode tmp = head;
	        test.printList(head);
	        
	        
	        ComplexListNode newHead = test.clone(head);
	        test.printList(head);
	}
}
