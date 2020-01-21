package geekTime.dataStructureAndAlgorithm.array;

/**
 * ��������ʵ�ֵ�LRU����
 * 1. �ռ临�Ӷ�Ϊ
 * 2. ʱ�临�Ӷ�Ϊ
 * @author cm
 *
 */
public class LRUBasedArray<T> {
	
	private T[] datas;
	
	private int size;
	
	private int capacity;
	
	private final static int DEFAULT_CAPACITY = 10;
	
	@SuppressWarnings("unchecked")
	public LRUBasedArray() {
		this.capacity = DEFAULT_CAPACITY;
		this.datas = (T[]) new Object[DEFAULT_CAPACITY];
	}
	
	@SuppressWarnings("unchecked")
	public LRUBasedArray(int capacity) {
		this.capacity = capacity;
		this.datas = (T[]) new Object[capacity];
	}
	
	/**
	 * ����Ԫ��
	 * @param data
	 */
	public void add(T data) {
		int index = findIndex(data);
		//��Ԫ�ز�����
		if(index == -1) {
			moveBackward(0);
			if(size < capacity)
				size ++;
		}else {
			moveBackward(0, index);
		}
		datas[0] = data;
	}
	
	/**
	 * ��ѯ�������Ƿ��и�Ԫ��
	 * @param data
	 * @return
	 */
	private int findIndex(T data) {
		int index = -1;
		for(int i = 0; i < size; i ++)
			if(datas[i].equals(data))
				index = i;
		return index;
	}
	
	/**
	 * ����ƶ�
	 * @param start		��ʼ�±�
	 */
	private void moveBackward(int start) {
		int end = size == capacity? size - 1: size;
		moveBackward(start, end);
	}
	
	/**
	 * ����ƶ�
	 * @param start		��ʼ�±�
	 * @param end		�����±�
	 */
	private void moveBackward(int start, int end) {
		for(int i = end; i > start; i --)
			datas[i] = datas[i - 1];
	}
	
	@SuppressWarnings("unchecked")
	public void clear() {
		this.datas = (T[]) new Object[capacity];
		this.size = 0;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("Array size: %d, capacity: %d", size, capacity));
		builder.append("[");
		for(int i = 0; i < size; i ++)
			builder.append(datas[i].toString()).append(", ");
		if(builder.lastIndexOf(", ") != -1 && builder.lastIndexOf(", ") == (builder.length() - 2))
			builder.delete(builder.length() - 2, builder.length());
		builder.append("]");
		return builder.toString();
	}
	
	public static void main(String[] args) {
		LRUBasedArray<String> array = new LRUBasedArray<String>(5);
		array.add("aaa");
		array.add("bbb");
		array.add("ccc");
		array.add("aaa");
		System.out.println(array.toString());
		array.add("ccc");
		System.out.println(array.toString());
		array.add("ddd");
		array.add("eee");
		System.out.println(array.toString());
		array.add("fff");
		array.add("bbb");
		System.out.println(array.toString());
		array.clear();
		System.out.println(array.toString());
	}
	
}
