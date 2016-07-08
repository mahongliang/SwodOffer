
public class N51_DuplicationInArray {
	public int duplicate(int[] nums){
		if (nums == null || nums.length < 1) {
			return -1;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0 || nums[i] >= nums.length) {
				return -1;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			while(nums[i] != i){
				if (nums[i] == nums[nums[i]]) {
					return nums[i];
				}else {
					swap(nums,i,nums[i]);
				}
			}
		}
		return -1;
	}
	
	private void swap(int[] nums,int i, int j){
		int temo=nums[i];
		nums[i] = nums[j];
		nums[j] = temo;
	}
	
	public static void main(String[] args) {
		N51_DuplicationInArray test = new N51_DuplicationInArray();
		 int[] numbers1 = {2, 1, 3, 1, 4};
	        System.out.println(test.duplicate(numbers1));
	        int[] numbers2 = {2, 4, 3, 1, 4};
	        System.out.println(test.duplicate(numbers2));
	        int[] numbers3 = {2, 4, 2, 1, 4};
	        System.out.println(test.duplicate(numbers3));
	        int[] numbers4 = {2, 1, 3, 0, 4};
	        System.out.println(test.duplicate(numbers4));
	        int[] numbers5 = {2, 1, 3, 5, 4};
	        System.out.println(test.duplicate(numbers5));
	}
}
