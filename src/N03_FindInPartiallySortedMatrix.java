
public class N03_FindInPartiallySortedMatrix {

	public boolean Find(int[][] arr, int key){
		
		if (arr == null || arr.length < 1 || arr[0].length < 1) {
			return false;
		}
		int rows = arr.length;
		int cols = arr[0].length;
		int row = 0;
		int col = cols-1;
		while(row < rows && col >= 0){
			if (arr[row][col] == key) {
				return true;
			}else if(arr[row][col] > key){
				col--;
			}else {
				row++;
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		N03_FindInPartiallySortedMatrix test = new N03_FindInPartiallySortedMatrix();
		int[][] arr={
				{1,2,8,9},
				{2,4,9,12},
				{4,7,10,13},
				{6,8,11,15}
		};
		 System.out.println(test.Find(arr, 7));    // 要查找的数在数组中  
	        System.out.println(test.Find(arr, 5));    // 要查找的数不在数组中  
	        System.out.println(test.Find(arr, 1));    // 要查找的数是数组中最小的数字  
	        System.out.println(test.Find(arr, 15));   // 要查找的数是数组中最大的数字  
	        System.out.println(test.Find(arr, 0));    // 要查找的数比数组中最小的数字还小  
	        System.out.println(test.Find(arr, 16));   // 要查找的数比数组中最大的数字还大  
	        System.out.println(test.Find(null, 16));     // 健壮性测试，输入空指针  
	}
}
