
public class N14_ReorderArray {
	public void reorderOddEven(int[] arr) {
		if (arr == null) {
			return;
		}

		int pre = 0;
		int last = arr.length - 1;

		while (pre < last) {
			while (pre < last && (arr[pre] & 0x1) == 1) {
				pre++;
			}

			while (pre < last && (arr[last] & 0x1) == 0) {
				last--;
			}
			
			if (pre < last) {
				int temp = arr[pre];
				arr[pre] = arr[last];
				arr[last] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		N14_ReorderArray test = new N14_ReorderArray();
		int[] arr = {1,2,3,4,5};
		test.reorderOddEven(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
