
public class N04_ReplaceBlank {

	
	public void ReplaceBlank(char[] str, int length){
		if (str == null || length <1) {
			return;
		}
		
		int numberOfBlank=0;
		int originalLegth=0;
		int i=0;
		while(str[i] != '\0'){
			originalLegth++;
			if (str[i] == ' ') {
				numberOfBlank++;
			}
			i++;
		}
		
		int newLength = originalLegth+numberOfBlank*2;
		if (newLength > length) {
			return;
		}
		
		int indexOfOriginal = originalLegth;
		int indexOfNew = newLength;
		while(indexOfOriginal >= 0 && indexOfNew > indexOfOriginal){
			if (str[indexOfOriginal] == ' ') {
				str[indexOfNew--] = '0';
				str[indexOfNew--] = '2';
				str[indexOfNew--] = '%';
			}else {
				str[indexOfNew--] = str[indexOfOriginal];
			}
			indexOfOriginal--;
		}
		
	}
	public static void main(String[] args) {
		N04_ReplaceBlank test= new N04_ReplaceBlank();
		char[] str = new char[100];
		str[0] = 'h';
		str[1] = 'e';
		str[2] = 'l';
		str[3] = 'l';
		str[4] = 'o';
		str[5] = ' ';
		str[6] = 'w';
		str[7] = 'o';
		str[8] = 'r';
		str[9] = 'l';
		test.ReplaceBlank(str, 100);
		
		System.out.println(str);
	}
}
