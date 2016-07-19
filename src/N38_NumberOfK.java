
public class N38_NumberOfK {

	private int getFirstK(int[] data, int k, int start, int end) {
		if (data == null || data.length < 1 || start > end) {
			return -1;
		}

		int midIdx = start + (end - start) / 2;
		int midData = data[midIdx];
		if (midData == k) {
			if ((midIdx > 0 && data[midIdx - 1] != k) || midIdx == 0) {
				return midIdx;
			} else {
				end = midIdx - 1;
			}
		} else if (midData > k) {
			end = midIdx - 1;
		} else {
			start = midIdx + 1;
		}

		return getFirstK(data, k, start, end);

	}

	private int getLastK(int[] data, int k, int start, int end) {
		if (data == null || data.length < 1 || start > end) {
			return -1;
		}

		int midIdx = start + (end - start) / 2;
		int midData = data[midIdx];

		if (midData == k) {
			if ((midIdx < data.length - 1 && data[midIdx + 1] != k) || midIdx == data.length - 1) {
				return midIdx;
			} else {
				start = midIdx + 1;
			}
		} else if (midData < k) {
			start = midIdx + 1;
		} else {
			end = midIdx - 1;
		}

		return getLastK(data, k, start, end);
	}

	public int getNumberOfK(int[] data, int k) {
		int number = 0;
		if (data != null && data.length > 0) {
			int first = getFirstK(data, k, 0, data.length - 1);
			int last = getLastK(data, k, 0, data.length - 1);
			if (first > -1 && last > -1) {
				number = last - first + 1;
			}
		}

		return number;
	}

	public static void main(String[] args) {

		N38_NumberOfK test = new N38_NumberOfK();
		// 查找的数字出现在数组的中间
		int[] data1 = { 1, 2, 3, 3, 3, 3, 4, 5 };
		System.out.println(test.getNumberOfK(data1, 3)); // 4
		// 查找的数组出现在数组的开头
		int[] data2 = { 3, 3, 3, 3, 4, 5 };
		System.out.println(test.getNumberOfK(data2, 3)); // 4
		// 查找的数组出现在数组的结尾
		int[] data3 = { 1, 2, 3, 3, 3, 3 };
		System.out.println(test.getNumberOfK(data3, 3)); // 4
		// 查找的数字不存在
		int[] data4 = { 1, 3, 3, 3, 3, 4, 5 };
		System.out.println(test.getNumberOfK(data4, 2)); // 0
		// 查找的数字比第一个数字还小，不存在
		int[] data5 = { 1, 3, 3, 3, 3, 4, 5 };
		System.out.println(test.getNumberOfK(data5, 0)); // 0
		// 查找的数字比最后一个数字还大，不存在
		int[] data6 = { 1, 3, 3, 3, 3, 4, 5 };
		System.out.println(test.getNumberOfK(data6, 0)); // 0
		// 数组中的数字从头到尾都是查找的数字
		int[] data7 = { 3, 3, 3, 3 };
		System.out.println(test.getNumberOfK(data7, 3)); // 4
		// 数组中的数字从头到尾只有一个重复的数字，不是查找的数字
		int[] data8 = { 3, 3, 3, 3 };
		System.out.println(test.getNumberOfK(data8, 4)); // 0
		// 数组中只有一个数字，是查找的数字
		int[] data9 = { 3 };
		System.out.println(test.getNumberOfK(data9, 3)); // 1
		// 数组中只有一个数字，不是查找的数字
		int[] data10 = { 3 };
		System.out.println(test.getNumberOfK(data10, 4)); // 0
	}
}
