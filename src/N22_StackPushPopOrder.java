import java.util.Stack;

public class N22_StackPushPopOrder {
	public boolean isPopOrder(int[] pusharr, int[] poparr) {
		Stack<Integer> dataStack = new Stack<>();
		boolean ispossible = false;
		int nextPush = 0;
		int nextPop = 0;
		while(nextPop < poparr.length){
			while(dataStack.isEmpty() || dataStack.peek() != poparr[nextPop]){
				if (nextPush == pusharr.length) {
					break;
				}
				dataStack.push(pusharr[nextPush]);
				nextPush++;
			}
			
			if (dataStack.peek() != poparr[nextPop]) {
				break;
			}
			
			dataStack.pop();
			nextPop++;
		}
		
		if (dataStack.isEmpty() && nextPop == poparr.length) {
			ispossible =  true;
		}
		
		return ispossible;
	}
	
	public static void main(String[] args) {
		
		N22_StackPushPopOrder test = new N22_StackPushPopOrder();
		
		int[] push = { 1, 2, 3, 4, 5 };
        int[] pop = { 4, 5, 3, 2, 1 };
        int[] pop1 = { 4, 3, 5, 1, 2 };
        if (test.isPopOrder(push, pop1)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
        
	}
}
