import java.util.LinkedList;
import java.util.Queue;

public class N07_StackWithTwoQueue {

	private int top;
	private Queue<Integer> q1 = new LinkedList<>();
	private Queue<Integer> q2 = new LinkedList<>();
	
	public void push(int x){
		q1.add(x);
		top = x;
	}
	
	public void pop(){
		while(q1.size() > 1){
			top = q1.remove();
			q2.add(top);
		}
		
		q1.remove();
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
	}
	
	public boolean isEmpty(){
		return q1.isEmpty();
	}
	
	public int top(){
		return top;
	}
}
