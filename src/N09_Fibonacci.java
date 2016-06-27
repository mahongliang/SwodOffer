
public class N09_Fibonacci {

	public int fibonacciRe(int n){
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fibonacciRe(n-1)+fibonacciRe(n-2);
	}
	public int fibonacci(int n){
		int result1 = 0;
		int result2 = 1;
		int result3 = 0;
		for (int i = 2; i <=n; i++) {
			result3 = result1+result2;
			result1 = result2;
			result2 = result3;
		}
	
		return result3;
	}
	
	public static void main(String[] args) {
		N09_Fibonacci test = new N09_Fibonacci();
		System.out.println(test.fibonacci(7));
		
		System.out.println(test.fibonacciRe(7));
	}
	
	
	
}
