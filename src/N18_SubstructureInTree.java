

public class N18_SubstructureInTree {
	class ListNode{
		int val;
		ListNode left;
		ListNode rigth;
		public ListNode(int x){
			val = x;
		}
	}
	
	public boolean hasSubTree(ListNode tree1, ListNode tree2){
		boolean result = false;
		if (tree1 != null && tree2 != null) {
			if (tree1.val == tree2.val) {
				result = doesTree1HaveTree2(tree1, tree2);
			}
			
			if (!result) {
				result = hasSubTree(tree1.left, tree2);
			}
			
			if (! result) {
				result = hasSubTree(tree1.rigth, tree2);
			}
		}
		return result;
	}
	
	public boolean doesTree1HaveTree2(ListNode tree1, ListNode tree2){
		
		if (tree2 == null) {
			return true;
		}
		
		if (tree1 == null) {
			return false;
		}
		
		
		if (tree1.val != tree2.val) {
			return false;
		}
		
		return doesTree1HaveTree2(tree1.left, tree2.left)&&
				doesTree1HaveTree2(tree1.rigth, tree2.rigth);
	}
	
	public static void main(String[] args) {
		N18_SubstructureInTree test = new N18_SubstructureInTree();
		ListNode n1 = test.new ListNode(8);
		ListNode n2 = test.new ListNode(8);
		ListNode n3 = test.new ListNode(7);
		ListNode n4 = test.new ListNode(9);
		ListNode n5 = test.new ListNode(2);
		ListNode n6 = test.new ListNode(4);
		ListNode n7 = test.new ListNode(7);
		n1.left = n2;
		n1.rigth = n3;	
		n2.left = n4;
		n2.rigth = n5;		
		n5.left = n6;
		n5.rigth = n7;
		
		
		ListNode n8 = test.new ListNode(8);
		ListNode n9 = test.new ListNode(9);
		ListNode n10 = test.new ListNode(2);
		n8.left = n9;
		n8.rigth = n10;
		
	
		
		if (test.hasSubTree(n1,n8)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}

		
	}
	
	
}
