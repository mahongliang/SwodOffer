
public class N11_Power {

	public double power(double base, int exponent){
		if (equal(base,0.0) && exponent < 0) {
			throw new RuntimeException("Invaid input");
		}
		
		if (exponent == 0) {
			return 1;
		}
		
		
		long absExp = exponent;
		if (absExp < 0 ) {
			absExp = -absExp;
		}
		
		double result = powerWithUnsignedExponent(base, absExp);
		
		
		if (exponent < 0) {
			result = 1.0/result;
		}
		
		return result;
		
	}
	
	public double powerWithUnsignedExponent(double base, long exp){
		double result = 1.0;
		for (int i = 1; i <= exp; i++) {
			result *=base;
		}
		return result;
	}
	
	private boolean equal(double num1, double num2){
		if ((num1-num2)>-0.000001 && (num1-num2) <0.000001) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		N11_Power test = new N11_Power();
//		 System.out.println(0.0000000000000000000000001111 == 0);  
//	        System.out.println(0.0000000000000000000000000000 == 0);  
//	        System.out.println(test.power(2, -4));  
//	        System.out.println(test.power(2, 4));  
//	        System.out.println(test.power(2, 0));  
	        System.out.println("1: "+test.power(0.00000000000000000000000000001, -1));  
	        System.out.println("2: "+test.power(0.00000000000000000000000000001, 1));  
	        System.out.println("3: "+test.power(0.00000000000000000000000000001, 0));  
	        System.out.println("4: "+test.power(0.00000000000000000000000000000, 0));  
	}
}
