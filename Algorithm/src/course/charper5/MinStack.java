package course.charper5;

import java.util.Stack;

/**
 * ������Сջ��
 * ��λ�ȡ��ǰջ�е���Сֵ��
 * ������ջ����ջ����ȡ��Сֵ��ʱ�临�Ӷȶ�ΪO(1)
 * @author cm
 *
 */
public class MinStack {

	Stack<Integer> mainStack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(Integer item){
		mainStack.push(item);
		if(minStack.size() == 0 || item < minStack.peek()){
			minStack.push(item);
		}
	}
	
	public Integer pop(){
		Integer item = mainStack.pop();
		if(minStack.size() != 0 && item.intValue() == minStack.peek().intValue()){
			minStack.pop();
		}
		return item;
	}
	
	public Integer getMin(){
		return minStack.peek();
	}
	
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(9);
		System.out.println(stack.getMin());
		stack.push(7);
		System.out.println(stack.getMin());
		stack.push(8);
		stack.push(5);
		stack.push(4);
		stack.push(3);
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
	}
	
}
