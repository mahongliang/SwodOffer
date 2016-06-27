import java.util.Stack;

public class N21_MinInStack<T extends Comparable<? super T>> {

	private Stack<T> dataStack = new Stack<T>();
	private Stack<T> minStack = new Stack<T>();
	
	public void push(T val){
		dataStack.push(val);
		
		if (minStack.size() == 0 || val.compareTo(minStack.peek()) < 0) {
			minStack.push(val);
		}else {
			minStack.push(minStack.peek());
		}
	}
	
	public void pop(){
		dataStack.pop();
		minStack.pop();
	}
	
	public T min(){
		return minStack.peek();
	}
	
	public T top(){
		return dataStack.peek();
	}
	public int size(){
		return dataStack.size();
	}
	public boolean empty(){
		return dataStack.isEmpty();
	}
}
