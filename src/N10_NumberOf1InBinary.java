
public class N10_NumberOf1InBinary {

	public int numberOfOne(int n){
		int cnt=0;
		int flag = 0x01;
		while(flag != 0){
			if ((n & flag) != 0) {
				cnt++;
			}
			flag = flag<<1;
		}
		return cnt;
	}
	
	public int numberOfOne2(int n){
		int cnt=0;
		while(n != 0){
			cnt++;
			n = (n-1)&n;
		}
		return cnt;
	}
	 
	public static void main(String[] args) {
		N10_NumberOf1InBinary test = new N10_NumberOf1InBinary();
		System.out.println(test.numberOfOne(0));
		System.out.println(test.numberOfOne(1));
		System.out.println(test.numberOfOne(10));
		System.out.println(test.numberOfOne(0x7fffffff));
		System.out.println(test.numberOfOne(0xffffffff));
		System.out.println(test.numberOfOne(0x80000000));
	}
}
