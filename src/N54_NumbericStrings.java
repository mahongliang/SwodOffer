
public class N54_NumbericStrings {
	public boolean isNumeric(String str){
		if (str == null || str.length() < 1) {
			return false;
		}
		
		int index = 0;
		if (str.charAt(index) == '+' || str.charAt(index) == '-') {
			index++;
		}
		
		if (index >= str.length()) {
			return false;
		}
		
		boolean numeric = true;
		index = scanDigits(str, index);
		
		if (index < str.length()) {
			if (str.charAt(index) == '.') {
				index++;
				index = scanDigits(str, index);
				if (index >= str.length()) {
					numeric = true;
				}else if (index < str.length() || str.charAt(index) == 'e' 
						&& str.charAt(index) == 'E') {
					numeric = isExponential(str,index);
				}else {
					numeric = false;
				}
			}else if (str.charAt(index) == 'e' || str.charAt(index) == 'E') {
				numeric = isExponential(str,index);
			}else {
				numeric = false;
			}			
			return numeric;
		}else {
			return true;
		}
		
	}
	
	private boolean isExponential(String str, int index){
		if (index >= str.length() || 
				(str.charAt(index) != 'e'&& str.charAt(index) != 'E')) {
			return false;
		}
		
		index++;
		if (index >= str.length()) {
			return false;
		}
		if (str.charAt(index) == '+' || str.charAt(index)=='-') {
			index++;
		}
		if (index >= str.length()) {
			return false;
		}
		index = scanDigits(str, index);
		
		return index >= str.length();
	}
	
	private int scanDigits(String str, int index){
		while(index < str.length() && str.charAt(index) >='0' && str.charAt(index) <='9'){
			index++;
		}
		return index;
	}
	
	public static void main(String[] args) {
		N54_NumbericStrings test = new N54_NumbericStrings();
		System.out.println(test.isNumeric("100") + "[" + true + "]");
        System.out.println(test.isNumeric("123.45e+6") + "[" + true + "]");
        System.out.println(test.isNumeric("+500") + "[" + true + "]");
        System.out.println(test.isNumeric("5e2") + "[" + true + "]");
        System.out.println(test.isNumeric("3.1416") + "[" + true + "]");
        System.out.println(test.isNumeric("600.") + "[" + true + "]");
        System.out.println(test.isNumeric("-.123") + "[" + true + "]");
        System.out.println(test.isNumeric("-1E-16") + "[" + true + "]");
        System.out.println(test.isNumeric("100") + "[" + true + "]");
        System.out.println(test.isNumeric("1.79769313486232E+308") + "[" + true + "]");
        System.out.println();
        System.out.println(test.isNumeric("12e") + "[" + false + "]");
        System.out.println(test.isNumeric("1a3.14") + "[" + false + "]");
        System.out.println(test.isNumeric("1+23") + "[" + false + "]");
        System.out.println(test.isNumeric("1.2.3") + "[" + false + "]");
        System.out.println(test.isNumeric("+-5") + "[" + false + "]");
        System.out.println(test.isNumeric("12e+5.4") + "[" + false + "]");
	}
}
