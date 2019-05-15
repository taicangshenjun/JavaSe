package course.chapter2;

/**
 * 循环队列的数据结构
 * @author cm
 *
 */
public class MyQueue {
	
	private int[] array;
	
	private int front;
	
	private int rear;
	
	public MyQueue(int capacity) throws Exception{
		if(capacity <= 0){
			throw new Exception("玩啥嘞！");
		}
		this.array = new int[capacity];
	}
	
	/**
	 * 入队
	 * @param element
	 * @throws Exception
	 */
	public void enQueue(int element) throws Exception{
		if((rear + 1) % array.length == front){
			throw new Exception("队列已满！");
		}
		array[rear] = element;
		rear = (rear + 1) % array.length;
	}
	
	/**
	 * 出队
	 * @return
	 * @throws Exception
	 */
	public int deQueue() throws Exception{
		if(rear == front){
			throw new Exception("队列已空！");
		}
		int deQueueElement = array[front];
		array[front] = 0;
		front = (front + 1) % array.length;
		return deQueueElement;
	}

	@Override
	public String toString() {
		String result = "[";
		for(int i = front; i != rear; i = (i + 1) % array.length){
			result += array[i] + ",";
		}
		result = result.lastIndexOf(",") > -1? result.substring(0, result.lastIndexOf(",")) + "]": result + "]";
		return result;
	}
	
}
