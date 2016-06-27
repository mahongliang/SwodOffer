import java.util.ArrayList;
import java.util.List;


public class N25_PathInTree {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		
		if (root == null) {
			return result;
		}
		ArrayList<Integer> path = new ArrayList<>();
		path.add(root.val);
		dfs(root, sum-root.val, path, result);
		return result;
		
	}

	public void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
		if (root.left == null && root.right == null && sum == 0) {
				List<Integer> newpath = new ArrayList<>(path);
				result.add(newpath);
		}	
		if (root.left != null) {
			path.add(root.left.val);
			dfs(root.left, sum-root.left.val, path, result);
			path.remove(path.size()-1);
		}
		if (root.right != null) {
			path.add(root.right.val);
			dfs(root.right, sum-root.right.val, path, result);
			path.remove(path.size()-1);
		}	
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(12);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(7);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		
		N25_PathInTree test = new N25_PathInTree();
		List<List<Integer>> result = test.pathSum(n1, 22);
		for (List<Integer> list : result) {
			for (Integer integer : list) {
				System.out.print(integer+" ");
			}
			System.out.println();
		}
		
	}
}
