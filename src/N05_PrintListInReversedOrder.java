import java.util.Stack;

class ListNode{
	int val;
	ListNode next;
	public ListNode(int x) {
		// TODO Auto-generated constructor stub
		val = x;
	}
}
public class N05_PrintListInReversedOrder {

	public void printListReversingly_Iteratively(ListNode root){
		
		Stack<ListNode> stack = new Stack<ListNode>();
		while(root != null){
			stack.push(root);
			root = root.next;
		}
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop().val);
		}
	}
	
	public void printListRerversingly_Recursively(ListNode root){
		if (root != null) {
			if (root.next != null) {
				printListRerversingly_Recursively(root.next);
			}
			
			System.out.println(root.val);
		}
	}
	public static void main(String[] args) {
		
		N05_PrintListInReversedOrder test = new N05_PrintListInReversedOrder();
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
		
		test.printListReversingly_Iteratively(n1);
		test.printListRerversingly_Recursively(n1);
		
	}
}
