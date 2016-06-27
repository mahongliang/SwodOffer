
public class N13_PrintToMaxOfDigits {

	public void printOneToNthDigits(int n){
		if (n <1) {
			throw new RuntimeException("invalid input");
		}
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
		
		while(addOne(arr) == 0){
			printArray(arr);
		}
	}
	
	public int addOne(int[] arr){
		int carry=1;
		int index = arr.length-1;
		do {
			arr[index] += carry;
			carry = arr[index]/10;
			arr[index] %= 10;
			index--;
			
		} while (carry != 0 && index >= 0);
		
		if (carry > 0 && index<0) {
			return 1;
		}
		
		return 0;
	}
	
	public void printArray(int[] arr){
		int index = 0;
		while(index < arr.length && arr[index] == 0){
			index++;
		}
		
		for (int i = index; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		
		if (index < arr.length) {
			
			System.out.println();
		}
	}
	public static void main(String[] args) {
		N13_PrintToMaxOfDigits test = new N13_PrintToMaxOfDigits();
		test.printOneToNthDigits(10);
	}
}
