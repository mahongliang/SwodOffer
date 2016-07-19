
public class N30_KLeastNumbers {
	public void getLeastNumbers(int[] input, int[] output){
		if (input == null || output == null) {
			throw new IllegalArgumentException("Invalid args");
		}
		
		int start = 0;
		int end = input.length - 1;
		int index = partition(input, start, end);
		int target = output.length -1;
		
		while( index != target){
			if (index < target) {
				start = index +1;
			}else {
				end = index -1;
			}
			index = partition(input,start,end);
		}
		
		System.arraycopy(input, 0, output, 0, output.length);
	}
	
	private int partition(int[] input, int start, int end){
		int tmp = input[start];
		while(start < end){
			while(start < end && input[end] >= tmp){
				end--;
			}
			
			input[start] = input[end];
			while(start <end && input[start] <= tmp){
				start++;			
			}
			input[end] = input[start];
			
		}
		input[start] = tmp;
		return start;
		
	}
	
	public static void main(String[] args) {
		N30_KLeastNumbers test = new N30_KLeastNumbers();
		int[] data = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] output = new int[4];
        test.getLeastNumbers(data, output);
        for (int i : output) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] output2 = new int[8];
        test.getLeastNumbers(data, output2);
        for (int i : output2) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] output3 = new int[1];
        test.getLeastNumbers(data, output3);
        for (int i : output3) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] data2 = {4, 5, 1, 6, 2, 7, 2, 8};
        int[] output4 = new int[2];
        test.getLeastNumbers(data2, output4);
        for (int i : output4) {
            System.out.print(i + " ");
        }
        System.out.println();
	}
	
	//方法二
	
	//最大堆来实现
	//最大值 O(1)
	//插入、删除O(logk)
}
