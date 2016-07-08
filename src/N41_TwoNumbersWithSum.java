
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class N41_TwoNumbersWithSum {
	public List<Integer> findNumbersWithSum(int[] data, int sum){
		List<Integer> result = new ArrayList<Integer>();
		if (data == null) {
			return result;
		}
		
		int ahead = data.length-1;
		int behind = 0;
		long curSum=0;
		while(behind < ahead){
			curSum = data[behind]+data[ahead];
			if (curSum == sum) {
				result.add(data[behind]);
				result.add(data[ahead]);
				break;
			}else if (curSum > sum) {
				ahead--;
			}else {
				behind++;
			}		
		}
		return result;
	}
	
	public List<List<Integer>> findContinuousSequence(int sum){
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (sum <3) {
			return results;
		}
		
		int small = 1;
		int big = 2;
		int middle = (1+sum)/2;
		
		int cursum = small+big;
		
		while(small < middle){
			if (cursum == sum) {
				List<Integer> result = new ArrayList<Integer>(2);
				for (int i = small; i <= big; i++) {
					result.add(i);
				}
				results.add(result);
			}
			
			while(cursum > sum && small < middle){
				cursum -= small;
				small++;
				if (cursum == sum) {
					List<Integer> result = new ArrayList<Integer>(2);
					for (int i = small; i <= big; i++) {
						result.add(i);
					}
					results.add(result);
				}	
			}
			
			big++;
			cursum += big;
		}
		return results;
	}
	public static void main(String[] args) {
		N41_TwoNumbersWithSum test = new N41_TwoNumbersWithSum();
		int[] data1 = {1, 2, 4, 7, 11, 15};
        System.out.println(test.findNumbersWithSum(data1, 15));
        int[] data2 = {1, 2, 4, 7, 11, 16};
        System.out.println(test.findNumbersWithSum(data2, 17));
        int[] data3 = {1, 2, 4, 7, 11, 16};
        System.out.println(test.findNumbersWithSum(data3, 10));
        
        System.out.println(test.findContinuousSequence(1));
        System.out.println(test.findContinuousSequence(3));
        System.out.println(test.findContinuousSequence(4));
        System.out.println(test.findContinuousSequence(9));
        System.out.println(test.findContinuousSequence(15));
        System.out.println(test.findContinuousSequence(100));
	}
}
