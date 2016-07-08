import java.util.LinkedList;
import java.util.List;


public class N45_LastNumberInCircle {
	public int lastRemaining(int n, int m){
		if (n<1||m<1) {
			return -1;
		}
		
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		
		int idx=0;
		while(list.size() >1){
			
			for (int i = 1; i < m; i++) {
				idx = (idx+1)%list.size();
			}
			
			list.remove(idx);
		}
		
		return list.get(0);
	}
	public static void main(String[] args) {
		N45_LastNumberInCircle test = new N45_LastNumberInCircle();
		System.out.println(test.lastRemaining(5, 3)); // 最后余下3
        System.out.println(test.lastRemaining(5, 2)); // 最后余下2
        System.out.println(test.lastRemaining(6, 7)); // 最后余下4
        System.out.println(test.lastRemaining(6, 6)); // 最后余下3
        System.out.println(test.lastRemaining(0, 0)); // 最后余下-1
		
	}
}
