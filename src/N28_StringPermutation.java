
public class N28_StringPermutation {

	public void permute(char[] str){
		if (str == null || str.length < 1) {
			return;
		}
		
		permute(str, 0);
	}
	
	private void permute(char[] str, int start){
		if (start >= str.length) {
			System.out.println(new String(str)+" ");
		}
		
		for (int i = start; i <= str.length -1; i++) {
			swap(str, start, i);
			permute(str, start+1);
			swap(str, start, i);
		}
	}
	
	private void swap(char[] str, int i, int j){
		char ch = str[i];
		str[i] = str[j];
		str[j] = ch;
	}
	
	public static void main(String[] args) {
		N28_StringPermutation test = new N28_StringPermutation();
		char[] c1 = {'a', 'b', 'c'};
        test.permute(c1);
        System.out.println();
        char[] c2 = {'a', 'b', 'c', 'd'};
        test.permute(c2);
	}
}
