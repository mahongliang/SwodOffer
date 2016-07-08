import java.util.Arrays;


public class N44_ContinousCards {

	public boolean isContinuous(int[] nums){
		if (nums == null || nums.length != 5) {
			return false;
		}
		
		Arrays.sort(nums);
		
		int numOfZero=0;
		int numOfGap=0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				numOfZero++;
			}
		}
		
		int small = numOfZero;
		int big = small+1;
		while(big < nums.length){
			if (nums[small] == nums[big]) {
				return false;
			}
			
			numOfGap += (nums[big]-nums[small]-1);
			small = big;
			big++;
		}
		
		return numOfGap>numOfZero?false:true;
	}
	
	public static void main(String[] args) {
		N44_ContinousCards test = new N44_ContinousCards();
		int[] numbers1 = {1, 3, 2, 5, 4};
        System.out.println(test.isContinuous(numbers1));
        int[] numbers2 = {1, 3, 2, 6, 4};
        System.out.println(test.isContinuous(numbers2));
        int[] numbers3 = {0, 3, 2, 6, 4};
        System.out.println(test.isContinuous(numbers3));
        int[] numbers4 = {0, 3, 1, 6, 4};
        System.out.println(test.isContinuous(numbers4));
        int[] numbers5 = {1, 3, 0, 5, 0};
        System.out.println(test.isContinuous(numbers5));
	}
}
