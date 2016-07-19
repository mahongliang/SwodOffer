import java.util.Vector;

public class N27_ConverBinarySearchTree {
	
	public class BinaryTreeNode{
		int value;
		BinaryTreeNode left;
		BinaryTreeNode right;
	}

	public BinaryTreeNode convert(BinaryTreeNode root){
		BinaryTreeNode[] lastNode = new BinaryTreeNode[1];
		convertNode(root, lastNode);
		BinaryTreeNode head = lastNode[0];
		while(head != null && head.left != null){
			head = head.left;
		}
		return head;
	}
	
	public void convertNode(BinaryTreeNode node ,BinaryTreeNode[] lastNode){
		if (node != null) {
			if (node.left != null) {
				convertNode(node.left, lastNode);
			}
			
			node.left = lastNode[0];
			
			if (lastNode[0] != null) {
				lastNode[0].right = node;
			}
			
			lastNode[0] = node;
			
			if (node.right != null) {
				convertNode(node.right, lastNode);
			}
		}
	}
	
	public void printTree(BinaryTreeNode root){
		if (root != null) {
			printTree(root.left);
			System.out.print(root.value +" ");
			printTree(root.right);
		}
	}
	 private  void printList(BinaryTreeNode head) {
	        while (head != null) {
	            System.out.print(head.value + "->");
	            head = head.right;
	        }
	        System.out.println("null");
	    }
	public static void main(String[] args) {
//      10
//         /      \
//        6        14
//       /\        /\
//      4  8     12  16
		
		N27_ConverBinarySearchTree test = new N27_ConverBinarySearchTree();
		BinaryTreeNode node10 = test.new BinaryTreeNode();
        node10.value = 10;
        BinaryTreeNode node6 = test.new BinaryTreeNode();
        node6.value = 6;
        BinaryTreeNode node14 = test.new BinaryTreeNode();
        node14.value = 14;
        BinaryTreeNode node4 = test.new BinaryTreeNode();
        node4.value = 4;
        BinaryTreeNode node8 = test.new BinaryTreeNode();
        node8.value = 8;
        BinaryTreeNode node12 = test.new BinaryTreeNode();
        node12.value = 12;
        BinaryTreeNode node16 = test.new BinaryTreeNode();
        node16.value = 16;
        node10.left = node6;
        node10.right = node14;
        node6.left = node4;
        node6.right = node8;
        node14.left = node12;
        node14.right = node16;
        System.out.print("Before convert: ");
        test.printTree(node10);
        System.out.println("null");
        BinaryTreeNode head = test.convert(node10);
        System.out.print("After convert : ");
        test.printList(head);
        System.out.println();
        
        Vector v = new Vector<>();
	
	}
}
