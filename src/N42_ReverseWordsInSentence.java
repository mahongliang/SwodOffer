
public class N42_ReverseWordsInSentence {

	public void reserve(char[] chs, int start, int end){
		if (chs == null|| start > end || start < 0 || end > chs.length) {
			return;
		}
		
		while(start < end){
			char temp = chs[start];
			chs[start] = chs[end];
			chs[end] = temp;
			start++;
			end--;
		}
	}
	
	public char[] reverseSentence(char[] data){
		if (data == null || data.length <1) {
			return data;
		}
		reserve(data, 0, data.length-1);
		
		int start=0;
		int end=0;
		while(start < data.length){
			if (data[start] == ' ') {
				start++;
				end++;
			}else if(end == data.length || data[end] == ' '){
				reserve(data, start, end-1);
				start = end;
			}else {
				end++;
			}
		}
		return data;
	}
	
	public char[] leftRotateStr(char[] data, int n){
		if (data == null || n < 1 || n>data.length) {
			return data;
		}
		
		reserve(data, 0, n-1);
		reserve(data, n, data.length-1);
		reserve(data, 0, data.length-1);
		
		return data;
	}
	
	public static void main(String[] args) {
		N42_ReverseWordsInSentence test = new N42_ReverseWordsInSentence();
		System.out.println(new String(test.reverseSentence("I am a student.".toCharArray())));
        System.out.println(new String(test.reverseSentence("Wonderful".toCharArray())));
        System.out.println(new String(test.reverseSentence("".toCharArray())));
        System.out.println(new String(test.reverseSentence("    ".toCharArray())));
        
        System.out.println(new String(test.leftRotateStr("abcdefg".toCharArray(), 2)));
        System.out.println(new String(test.leftRotateStr("abcdefg".toCharArray(), 1)));
        System.out.println(new String(test.leftRotateStr("abcdefg".toCharArray(), 6)));
        System.out.println(new String(test.leftRotateStr("abcdefg".toCharArray(), 7)));
        System.out.println(new String(test.leftRotateStr("abcdefg".toCharArray(), 0)));
	}
}
