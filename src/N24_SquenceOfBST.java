
public class N24_SquenceOfBST {

	public boolean vertitySqucenceOfBST(int[] sequence) {
		if (sequence == null || sequence.length == 0) {

			return false;
		}
		return vertitySqucenceOfBST(sequence, 0, sequence.length - 1);
	}

	public boolean vertitySqucenceOfBST(int[] sequence, int start, int end) {
		if (start >= end) {
			return true;
		}

		int index = start;
		while (index < end && sequence[index] < sequence[end]) {
			index++;
		}

		int right = index;
		while (index < end) {
			if (sequence[index] < sequence[end]) {
				return false;
			}
			index++;
		}

		return vertitySqucenceOfBST(sequence, start, right - 1) && vertitySqucenceOfBST(sequence, right, end - 1);
	}
	public static void main(String[] args) {
		N24_SquenceOfBST test = new N24_SquenceOfBST();
		  int[] data = {4, 8, 6, 12, 16, 14, 10};
	       System.out.println("true: " + test.vertitySqucenceOfBST(data));
	       int[] data2 = {4, 6, 7, 5};
	        System.out.println("true: " + test.vertitySqucenceOfBST(data2));
	        int[] data4 = {5, 4, 3, 2, 1};
	        System.out.println("true: " + test.vertitySqucenceOfBST(data4));
	        // 树中只有1个结点
	        int[] data5 = {5};
	        System.out.println("true: " + test.vertitySqucenceOfBST(data5));
	        int[] data6 = {7, 4, 6, 5};
	        System.out.println("false: " + test.vertitySqucenceOfBST(data6));
	        int[] data7 = {4, 6, 12, 8, 16, 14, 10};
	        System.out.println("false: " + test.vertitySqucenceOfBST(data7));
	}
}
