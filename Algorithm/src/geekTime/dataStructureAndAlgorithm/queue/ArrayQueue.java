package geekTime.dataStructureAndAlgorithm.queue;

/**
 * ʹ������ʵ�ֶ���
 * @author cm
 * @param <T>
 */
public class ArrayQueue<T> {
	
	//Ĭ������
	private final static int DEFAULT_SIZE = 10;
	
	//����
	private int size;

	//ͷ���±�
	private int head;
	
	//β���±�
	private int tail;
	
	//�洢��������
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
	 * ���
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
	 * ����
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
	 * �ض�λ
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
