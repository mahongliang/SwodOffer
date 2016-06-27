import java.util.Stack;



public class N19_MirrorOfBinaryTree {

	public void mirrorRecuresively(TreeNode root){
		if (root == null ||( root.left == null && root.right ==null)) {
			return;
		}
		
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		if (root.left != null) {
			mirrorRecuresively(root.left);
		}
		
		if (root.right !=null) {
			mirrorRecuresively(root.right);
		}
	}
	
	public void mirrorIteratively(TreeNode root){
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
			
			if (node.left != null) {
				stack.push(node.left);
			}
			
			if (node.right != null) {
				stack.push(node.right);
			}
		}
		
	}
	
	public void preorder(TreeNode root){
		if (root != null) {
			System.out.println(root.val);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public static void main(String[] args) {
		
		N19_MirrorOfBinaryTree test= new N19_MirrorOfBinaryTree();
		TreeNode n1 = new TreeNode(8);
		TreeNode n2 = new TreeNode(8);
		TreeNode n3 = new TreeNode(7);
		TreeNode n4 = new TreeNode(9);
		TreeNode n5 = new TreeNode(2);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;	
		n2.left = n4;
		n2.right = n5;		
		n5.left = n6;
		n5.right = n7;
		
		test.mirrorRecuresively(n1);
		test.preorder(n1);
		System.out.println("========");
		test.mirrorIteratively(n1);
		test.preorder(n1);
		
		
		
	}
}
