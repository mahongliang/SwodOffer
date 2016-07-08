
public class N59_SymmetricalBinaryTree {
	public boolean isSymmetrical(TreeNode root){
		return isSymmetrical(root.left ,root.right);
	}
	
	public boolean isSymmetrical(TreeNode root1, TreeNode root2){
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.val != root2.val) {
			return false;
		}
		
		return isSymmetrical(root1.left, root2.right) && 
				isSymmetrical(root1.right, root2.left);
	}
}
