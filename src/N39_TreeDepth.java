import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;


public class N39_TreeDepth {

	public int treeDepth(TreeNode root){
		if (root == null) {
			return 0;
		}
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		
		int length = (left>right)?left+1:right+1;
		
		return length;
	}
	
	public boolean isBalanced1(TreeNode root){
		if (root == null) {
			return true;
		}
		
		int left =  treeDepth(root.left);
		int right = treeDepth(root.right);
		
		int diff = left-right;
		if (diff >1 || diff <-1) {
			return false;
		}
		
		return isBalanced1(root.left)&& isBalanced1(root.right);
	}
	
	
	public boolean isBalanced2(TreeNode root){
		int[] depth = new int[1];
		return isBalanceHelp(root, depth);
	}
	
	public boolean isBalanceHelp(TreeNode root, int[] depth){
		if (root == null) {
			depth[0] = 0;
			return true;
		}
		
		int[] left = new int[1];
		int[] right = new int[1];
		
		if (isBalanceHelp(root.left, left) && isBalanceHelp(root.right, right)) {
			int diff = left[0] - right[0];
			if (diff <=1 && diff >=-1) {
				depth[0] = 1 + (left[0]>right[0]?left[0]:right[0]);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		 // 不是完全二叉树，但是平衡二叉树
	    //             1
	    //         /      \
	    //        2        3
	    //       /\         \
	    //      4  5         6
	    //        /
	    //       7
		TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n7;
        n3.right = n6;
        
        N39_TreeDepth test = new N39_TreeDepth();
        
        System.out.println(test.isBalanced1(n1));
        System.out.println(test.isBalanced2(n1));
        System.out.println("----------------");
	}
}
