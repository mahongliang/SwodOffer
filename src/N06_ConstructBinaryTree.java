import javax.management.RuntimeErrorException;
import javax.xml.bind.ValidationEvent;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
}

public class N06_ConstructBinaryTree {
	public TreeNode construct(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length != inorder.length) {
			return null;
		}

		return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	public TreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
		if (ps > pe) {
			return null;
		}

		int val = preorder[ps];
		int index = is;

		// val of index
		while (index <= ie && inorder[index] != val) {
			index++;
		}

		if (index > ie) {
			throw new RuntimeException("Invalid input");
		}

		TreeNode root = new TreeNode(val);
		root.left = construct(preorder, ps + 1, ps + index - is, inorder, is, index - 1);
		root.right = construct(preorder, ps + index - is + 1, pe, inorder, index + 1, ie);

		return root;
	}

	public void printTree(TreeNode root) {
		if (root != null) {
			printTree(root.left);
			System.out.print(root.val + " ");
			printTree(root.right);
		}
	}

	public static void main(String[] args) {
//		int[] preorder = { 1, 2, 4, 7, 3, 5, 6, 8 };
//		int[] inorder = { 4, 7, 2, 1, 5, 3, 8, 6 };
		
		 int[] preorder = {1, 2, 3, 4, 5};  
	        int[] inorder = {5, 4, 3, 2, 1};  
		N06_ConstructBinaryTree test = new N06_ConstructBinaryTree();
		test.printTree(test.construct(preorder, inorder));

	}
}
