package course.charper5;

import java.util.Stack;

/**
 * 使用栈实现队列操作
 * @author cm
 *
 */
public class StackAchieveQueue {

	private Stack<Integer> stackA;
	
	private Stack<Integer> stackB;
	
	public StackAchieveQueue(){
		stackA = new Stack<Integer>();
		stackB = new Stack<Integer>();
	}
	
	public void offer(Integer num){
		stackA.push(num);
	}
	
	public Integer poll(){
		if(stackB.isEmpty()){
			if(stackA.isEmpty()){
				return null;
			}
			while(!stackA.isEmpty()){
				stackB.push(stackA.pop());
			}
		}
		return stackB.pop();
	}
	
	public static void main(String[] args) {
		StackAchieveQueue queue = new StackAchieveQueue();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		queue.offer(4);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}
	
}
