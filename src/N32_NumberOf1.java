
public class N32_NumberOf1 {

	public int numberOf1Between1AndN(int n){
		if (n<=0) {
			return 0;
		}
		
		String value = n+"";
		int[] numbers = new int[value.length()];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = value.charAt(i)-'0';
		}
		
		return numberOf1(numbers,0);
	}
	
	private int numberOf1(int[] numbers, int curIdx){
		if (numbers == null || curIdx >=  numbers.length || curIdx <0) {
			return 0;
		}
		int first  = numbers[curIdx];
		int length = numbers.length -curIdx;
		if (length == 1 && first == 0) {
			return 0;
		}
		
		if (length == 1 && first > 0) {
			return 1;
		}
		
		int numFirstDigit = 0;
		
		if (first >1) {
			numFirstDigit = powerBase10(length -1);
		}else if (first == 1) {
			numFirstDigit = atoi(numbers,curIdx+1)+1;
			
		} 
		
		int numOtherDigits = first*(length-1)*powerBase10(length-2);
		
		int numRecursive = numberOf1(numbers, curIdx+1);
		
		return numFirstDigit+numOtherDigits+numRecursive;
	}
	
	private int powerBase10(int n){
		int result = 1;
		for (int i = 0; i < n; i++) {
			result *= 10;
		}
		return result;
	}
	
	private int atoi(int[] numbers, int i){
		int result = 0;
		for (int j = i; j < numbers.length; j++) {
			result = (result*10 + numbers[j]);
		}
		return result;
	}
	public static void main(String[] args) {
		N32_NumberOf1 test = new N32_NumberOf1();
		System.out.println(test.numberOf1Between1AndN(1)); // 1
        System.out.println(test.numberOf1Between1AndN(5)); // 1
        System.out.println(test.numberOf1Between1AndN(10)); // 2
        System.out.println(test.numberOf1Between1AndN(55)); // 16
        System.out.println(test.numberOf1Between1AndN(99)); // 20
        System.out.println(test.numberOf1Between1AndN(10000)); // 4001
        System.out.println(test.numberOf1Between1AndN(21345)); // 18821
        System.out.println(test.numberOf1Between1AndN(0)); // 0
	}
}
