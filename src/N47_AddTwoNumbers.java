public class N47_AddTwoNumbers {
	public int add(int num1, int num2) {
		int sum = 0;
		int carry = 0;
		do {
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		} while (num2 != 0);

		return sum;

	}

	public static void main(String[] args) {
		N47_AddTwoNumbers test = new N47_AddTwoNumbers();
		System.out.println(test.add(1, 2) + ", " + (1 + 2));
		System.out.println(test.add(13, 34) + ", " + (13 + 34));
		System.out.println(test.add(19, 85) + ", " + (19 + 95));
		System.out.println(test.add(865, 245) + ", " + (865 + 245));
		
	}
}
