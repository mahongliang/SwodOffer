import javax.print.attribute.standard.MediaName;

public class N08_MinNumberInRotatedArray {

	public int min(int[] nums){
		if (nums == null) {
			throw new RuntimeException("Invalid input");
		}
		
		int index1=0;
		int index2=nums.length-1;
		
		int indexMid = index1;
		while(nums[index1] >= nums[index2]){
			if (index2-index1 == 1) {
				indexMid = index2;
				break;
			}
			
			indexMid = (index1+index2)/2;
			
			if (nums[index1] == nums[index2] && nums[index1] == nums[indexMid]) {
				return minInorder(nums,index1,index2);
			}
			if (nums[indexMid] >= nums[index1]) {
				index1 = indexMid;
			}else if (nums[indexMid] <= nums[index2]) {
				index2 = indexMid;
			}
		}
		
		return nums[indexMid];
	}
	
	public int  minInorder(int[] nums, int index1, int index2){
		int result = nums[index1];
		for (int i = index1+1; i <= index2; i++) {
			if (result > nums[i]) {
				result = nums[i];
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		N08_MinNumberInRotatedArray test = new N08_MinNumberInRotatedArray();
		
		// 典型输入，单调升序的数组的一个旋转  
        int[] array1 = {3, 4, 5, 1, 2};  
        System.out.println(test.min(array1  ));  
        // 有重复数字，并且重复的数字刚好的最小的数字  
        int[] array2 = {3, 4, 5, 1, 1, 2};  
        System.out.println(test.min(array2));  
        // 有重复数字，但重复的数字不是第一个数字和最后一个数字  
        int[] array3 = {3, 4, 5, 1, 2, 2};  
        System.out.println(test.min(array3));  
        // 有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字  
        int[] array4 = {1, 0, 1, 1, 1};  
        System.out.println(test.min(array4));  
        // 单调升序数组，旋转0个元素，也就是单调升序数组本身  
        int[] array5 = {1, 2, 3, 4, 5};  
        System.out.println(test.min(array5));  
        // 数组中只有一个数字  
        int[] array6 = {2};  
        System.out.println(test.min(array6));  
        // 数组中数字都相同  
        int[] array7 = {1, 1, 1, 1, 1, 1, 1};  
        System.out.println(test.min(array7));  
        System.out.println(test.min(array6));  
        // 输入NULL  
        System.out.println(test.min(null)); 
	}
}
