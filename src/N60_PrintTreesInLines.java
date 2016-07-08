import java.util.LinkedList;
import java.util.Queue;


public class N60_PrintTreesInLines {

	public void print(TreeNode root){
		if (root == null) {
			return;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){		
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.poll();
				System.out.printf("%-3d",temp.val);
				
				if (temp.left != null) {
					queue.add(temp.left);

				}
				if (temp.right != null) {
					queue.add(temp.right);

				}
			}			
			System.out.println();
		}
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
        N60_PrintTreesInLines test = new N60_PrintTreesInLines();
        test.print(n1);
	}
}
