package geekTime.dataStructureAndAlgorithm.array;

/**
 * 基于数组实现的LRU缓存
 * 1. 空间复杂度为
 * 2. 时间复杂度为
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
	 * 增加元素
	 * @param data
	 */
	public void add(T data) {
		int index = findIndex(data);
		//该元素不存在
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
	 * 查询数组中是否有该元素
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
	 * 向后移动
	 * @param start		起始下标
	 */
	private void moveBackward(int start) {
		int end = size == capacity? size - 1: size;
		moveBackward(start, end);
	}
	
	/**
	 * 向后移动
	 * @param start		起始下标
	 * @param end		结束下标
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
