
public class N35_FirstNotRepeatingChar {

	public char firstNotRepeatingChar(String str){
		if (str == null || str.length() <1) {
			throw new IllegalArgumentException("Arg shoud not be null or empty");
		}
		
		int tablesize = 256;
		int[] hashTable = new int[tablesize];
		for (int i = 0; i < str.length(); i++) {
			hashTable[str.charAt(i)]++;
		}
		
		for (int i = 0; i < str.length(); i++) {
			if (hashTable[str.charAt(i)] == 1) {
				return str.charAt(i);
			}
		}
		
		return '\0';
	}
	
	public static void main(String[] args) {
		N35_FirstNotRepeatingChar test = new N35_FirstNotRepeatingChar();
		System.out.println(test.firstNotRepeatingChar("google")); // l
        System.out.println(test.firstNotRepeatingChar("aabccdbd")); // '\0'
        System.out.println(test.firstNotRepeatingChar("abcdefg")); // a
        System.out.println(test.firstNotRepeatingChar("gfedcba")); // g
        System.out.println(test.firstNotRepeatingChar("zgfedcba")); // z
	}
}
