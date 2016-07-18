
public class N31_CreatestSumOfSubarrays {
	public int findGreatestSumOfSubarray(int[] arr){
		if (arr == null || arr.length <1) {
			throw new IllegalArgumentException("array must contain an element");
		}
		
		int max = Integer.MIN_VALUE;
		int curmax = 0;
		for (int i : arr) {
			if (curmax <= 0) {
				curmax = i;
			}else {
				curmax += i;
			}
			
			if (curmax > max) {
				max = curmax;
			}
		}
		
		return max;
	}
	public static void main(String[] args) {
		N31_CreatestSumOfSubarrays test = new N31_CreatestSumOfSubarrays();
		int[] data = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] data2 = {-2, -8, -1, -5, -9};
        int[] data3 = {2, 8, 1, 5, 9};
        System.out.println(test.findGreatestSumOfSubarray(data));
        System.out.println(test.findGreatestSumOfSubarray(data2));
        System.out.println(test.findGreatestSumOfSubarray(data3));
	}
}
