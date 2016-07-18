
public class N29_MoreThanHalfNumber {

	public int moreThanHalfNum(int[] nums){
		if (nums == null|| nums.length<1) {
			throw new IllegalArgumentException("array length must large than 0");
		}
		
		int resutl = nums[0];
		int cnt=1;
		for (int i = 1; i < nums.length; i++) {
			if (cnt==0) {
				resutl = nums[i];
				cnt=1;
			}else if (resutl == nums[i]) {
				cnt++;
			}else {
				cnt--;
			}
		}
		
		cnt = 0;
		for (int i : nums) {
			if (resutl == i) {
				cnt++;
			}
		}
		
		if (cnt > nums.length/2) {
			return resutl;
		}
		
		return -1;
	}
	public static void main(String[] args) {
		N29_MoreThanHalfNumber test = new N29_MoreThanHalfNumber();
		// 存在出现次数超过数组长度一半的数字
        int numbers[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(test.moreThanHalfNum(numbers));
        // 出现次数超过数组长度一半的数字都出现在数组的前半部分
        int numbers2[] = {2, 2, 2, 2, 2, 1, 3, 4, 5};
        System.out.println(test.moreThanHalfNum(numbers2));
        // 出现次数超过数组长度一半的数字都出现在数组的后半部分
        int numbers3[] = {1, 3, 4, 5, 2, 2, 2, 2, 2};
        System.out.println(test.moreThanHalfNum(numbers3));
        // 只有一个数
        int numbers4[] = {1};
        System.out.println(test.moreThanHalfNum(numbers4));
        // 输入空指针
        //test.moreThanHalfNum(null);
        // 不存在出现次数超过数组长度一半的数字
        int numbers5[] = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        System.out.println(test.moreThanHalfNum(numbers5));
	}
}
