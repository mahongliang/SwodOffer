import java.util.Arrays;


public class N52_ArrayConstruction {
	public double[] multiply(double[] data){
		if (data == null || data.length < 2) {
			return null;
		}
		
		double[] result = new double[data.length];
		result[0] = 1;
		
		for (int i = 1; i < result.length; i++) {
			result[i] = result[i-1]*data[i-1];
		}
		
		double temp = 1;
		for (int i = data.length-2; i >=0; i--) {
			temp = temp *data[i+1];
			result[i] = temp * result[i];		
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		N52_ArrayConstruction test = new N52_ArrayConstruction();
		double[] array1 = {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(test.multiply(array1))); // double expected[] = {120, 60, 40, 30, 24};
        double[] array2 = {1, 2, 0, 4, 5};
        System.out.println(Arrays.toString(test.multiply(array2))); // double expected[] = {0, 0, 40, 0, 0};
        double[] array3 = {1, 2, 0, 4, 0};
        System.out.println(Arrays.toString(test.multiply(array3))); // double expected[] = {0, 0, 0, 0, 0};
        double[] array4 = {1, -2, 3, -4, 5};
        System.out.println(Arrays.toString(test.multiply(array4))); // double expected[] = {120, -60, 40, -30, 24};
        double[] array5 = {1, -2};
        System.out.println(Arrays.toString(test.multiply(array5))); // double expected[] = {-2, 1};
	}
}
