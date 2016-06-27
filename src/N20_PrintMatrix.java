
public class N20_PrintMatrix {

	public void printMatrixClockwisely(int[][] arr) {
		if (arr == null) {
			return;
		}
		int rows = arr.length;
		int cols = arr[0].length;
		int start = 0;
		while (rows > 2 * start && cols > 2 * start) {
			printMatrixInCircle(arr, rows, cols, start);
			start++;
		}

	}

	private void printMatrixInCircle(int[][] arr, int rows, int cols, int start) {
		// TODO Auto-generated method stub
		int endX = cols - 1 - start;
		int endY = rows - 1 - start;

		for (int i = start; i <= endX; i++) {
			System.out.print(arr[start][i] + " ");
		}

		if (start < endY) {
			for (int i = start + 1; i <= endY; i++) {
				System.out.print(arr[i][endX] + " ");
			}
		}

		if (start < endX && start < endY) {
			for (int i = endX - 1; i >= start; i--) {
				System.out.print(arr[endY][i] + " ");
			}
		}

		if (start < endX && start < endY - 1) {
			for (int i = endY - 1; i >= start + 1; i--) {
				System.out.print(arr[i][start]+" ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		N20_PrintMatrix test = new N20_PrintMatrix();
		test.printMatrixClockwisely(arr);
		
	}

}
