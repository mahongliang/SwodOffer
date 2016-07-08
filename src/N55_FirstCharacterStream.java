
public class N55_FirstCharacterStream {
	private int index = 0;
	private int[] occurrence;
	public N55_FirstCharacterStream(){
		occurrence = new int[256];
		for (int i = 0; i < occurrence.length; i++) {
			occurrence[i]=-1;
		}
	}
	
	public void insert(char ch){
		if (ch > 255) {
			throw new IllegalArgumentException("must be ASCII");
		}
		
		if (occurrence[ch] == -1) {
			occurrence[ch] = index;
		}else {
			occurrence[ch] = -2;
		}
		index++;
	}
	public char firstAppearingOnce(String str){
		if (str == null) {
			throw new IllegalArgumentException("null error");
		}
		for (int i = 0; i < str.length(); i++) {
			insert(str.charAt(i));
		}
		
		char ch='\0';
		int minIndex = Integer.MAX_VALUE;
		for (int i = 0; i < occurrence.length; i++) {
			if (occurrence[i] >= 0 && occurrence[i]<minIndex) {
				ch = (char)i;
				minIndex = occurrence[i];
			}
		}
		return ch;
	}
	public static void main(String[] args) {
		
		  System.out.println(new N55_FirstCharacterStream().firstAppearingOnce("")); // '\0'
	        System.out.println(new N55_FirstCharacterStream().firstAppearingOnce("g")); // 'g'
	        System.out.println(new N55_FirstCharacterStream().firstAppearingOnce("go")); // 'g'
	        System.out.println(new N55_FirstCharacterStream().firstAppearingOnce("goo")); // 'g'
	        System.out.println(new N55_FirstCharacterStream().firstAppearingOnce("goog")); // '\0'
	        System.out.println(new N55_FirstCharacterStream().firstAppearingOnce("googl")); // l
	        System.out.println(new N55_FirstCharacterStream().firstAppearingOnce("google")); // l
	}
}
