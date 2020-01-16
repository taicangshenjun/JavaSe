package geekTime.dataStructureAndAlgorithm.queue;

/**
 * 使用数组实现队列
 * @author cm
 * @param <T>
 */
public class ArrayQueue<T> {
	
	//默认容量
	private final static int DEFAULT_SIZE = 10;
	
	//容量
	private int size;

	//头部下标
	private int head;
	
	//尾部下标
	private int tail;
	
	//存储数据数组
	private T[] datas;
	
	public ArrayQueue(){
		this(DEFAULT_SIZE);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int size) {
		this.size = size;
		this.head = 0;
		this.tail = 0;
		this.datas = (T[]) new Object[size];
	}
	
	/**
	 * 入队
	 * @param element
	 * @return
	 */
	public boolean enQueue(T element) {
		boolean result = false;
		if(tail == size && head > 0)
			checkRelocate();
		if(tail < size) {
			datas[tail ++] = element;
			result = true;
		}
		return result;
	}
	
	/**
	 * 出队
	 * @return
	 */
	public T deQueue() {
		T result = null;
		if(head < tail) {
			result = datas[head];
			datas[head ++] = null;
		}
		return result;
	}
	
	/**
	 * 重定位
	 */
	private void checkRelocate() {
		int interval = tail - head;
		for(int i = 0; i < interval; i ++) {
			datas[i] = datas[i + head];
			datas[i + head] = null;
		}
		head = 0;
		tail = interval;
	}
	
	public static void main(String[] args) {
		ArrayQueue<String> queue = new ArrayQueue<String>(3);
		queue.enQueue("a");
		queue.deQueue();
		queue.enQueue("b");
		queue.enQueue("c");
		queue.deQueue();
		queue.deQueue();
		queue.enQueue("d");
		queue.enQueue("e");
	}
	
}
