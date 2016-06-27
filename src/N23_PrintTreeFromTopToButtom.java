import java.util.LinkedList;
import java.util.Queue;

public class N23_PrintTreeFromTopToButtom {

	public void printTreeFromTopToButtom(TreeNode root){
		if (root == null) {
			return;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode temp =queue.peek();
			System.out.print(temp.val+" ");
			queue.remove();
			
			if (temp.left != null) {
				queue.add(temp.left);
			}
			
			if (temp.right != null) {
				queue.add(temp.right);
			}
			
		}
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(6);
		TreeNode n3 = new TreeNode(14);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(8);
		TreeNode n6 = new TreeNode(12);
		TreeNode n7 = new TreeNode(16);
		
		n1.left = n2;
		n1.right = n3;
		
		n2.left = n4;
		n2.right = n5;
		
		n3.left = n6;
		n3.right =n7;
		
		N23_PrintTreeFromTopToButtom test = new N23_PrintTreeFromTopToButtom();
		test.printTreeFromTopToButtom(n1);
	}
}
