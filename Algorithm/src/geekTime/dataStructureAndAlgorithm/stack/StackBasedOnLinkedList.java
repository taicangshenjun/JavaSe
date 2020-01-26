package geekTime.dataStructureAndAlgorithm.stack;

/**
 * 基于链表实现的栈。
 * @author cm
 *
 */
public class StackBasedOnLinkedList<T> {
	
	private Node<T> top = null;

	//压栈
	public void push(T data) {
		Node<T> newTop = new Node<T>(data, top);
		top = newTop;
	}

	//出栈
	public T pop() {
		T result = null;
		if(top != null) {
			result = top.getData();
			top = top.getNext();
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		Node<T> node = top;
		while(node != null) {
			builder.append(node.getData().toString()).append(", ");
			node = node.getNext();
		}
		if(builder.lastIndexOf(", ") != -1 && builder.lastIndexOf(", ") == (builder.length() - 2))
			builder.delete(builder.length() - 2, builder.length());
		builder.append("]");
		return builder.toString();
	}

	private static class Node<T> {
		
		private T data;
		
		private Node<T> next;
		
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		public T getData() {
			return data;
		}

		public Node<T> getNext() {
			return next;
		}
		
	}
	
	public static void main(String[] args) {
		StackBasedOnLinkedList<String> stack = new StackBasedOnLinkedList<String>();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		System.out.println(stack.toString());
		String str = stack.pop();
		System.out.println(str);
		System.out.println(stack.toString());
		stack.pop();
		System.out.println(stack.toString());
		stack.pop();
		System.out.println(stack.toString());
	}
	
}
