package geekTime.dataStructureAndAlgorithm.array;

/**
 * 通用数组函数
 * @author cm
 *
 */
public class Array<T> {
	
	//存储元素
	private T[] data;
	//容量
	private int length;
	
	public Array() {
		this(10);
	}
	
	@SuppressWarnings("unchecked")
	public Array(int capacity) {
		this.data = (T[]) new Object[capacity];
		this.length = 0;
	}
	
	// 获取数组容量
	public int getCapacity() {
		return data.length;
	}
	
	// 获取当前元素个数
	public int count() {
		return length;
	}
	
	// 判断数组是否为空
	public boolean isEmpty() {
		return length == 0;
	}
	
	// 修改 index 位置的元素
	public void set(int index, T element) {
		checkIndex(index);
		data[index] = element;
	}
	
	// 获取对应 index 位置的元素
	public T get(int index) {
		checkIndex(index);
		return data[index];
	}
	
	// 查看数组是否包含元素e
	public boolean contains(T element) {
		for(int i = 0; i < length; i ++)
			if(data[i].equals(element))
				return true;
		return false;
	}
	
	// 获取对应元素的下标, 未找到，返回 -1
	public int indexOf(T element) {
		for(int i = 0; i < length; i ++)
			if(data[i].equals(element))
				return i;
		return -1;
	}
	
	// 在 index 位置，插入元素e, 时间复杂度 O(m+n)
	public void add(int index, T element) {
		checkIndexForAdd(index);
		if(data.length == length)
			reSize(length * 2);
		for(int i = length; i > index; i --)
			data[i] = data[i - 1];
		data[index] = element;
		length ++;
	}
	
	// 向数组头插入元素
	public void addFirst(T element) {
		add(0, element);
	}
	
	// 向数组尾插入元素
	public void addLast(T element) {
		add(length, element);
	}
	
	// 删除 index 位置的元素，并返回
	public T remove(int index) {
		T element = null;
		try {
			checkIndex(index);
			element = data[index];
			for(int i = index; i < length - 1; i ++)
				data[i] = data[i + 1];
			data[-- length] = null;
			// 缩容
	        if (length == data.length / 4 && data.length / 2 != 0) {
	            reSize(data.length / 2);
	        }
		}catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	// 删除第一个元素
	public T removeFirst() {
		return remove(0);
	}
	
	// 删除末尾元素
	public T removeLast() {
		return remove(length - 1);
	}
	
	// 从数组中删除指定元素
	public T remove(T element) {
		int index = indexOf(element);
		if(index != -1)
			return remove(index);
		return null;
	}
	
	// 扩容方法，时间复杂度 O(n)
	@SuppressWarnings("unchecked")
	private void reSize(int capacity) {
		T[] newData = (T[]) new Object[capacity];
		for(int i = 0; i < length; i ++)
			newData[i] = data[i];
		data = newData;
	}
	
	private void checkIndex(int index) {
		if(index < 0 || index >= length)
			throw new IndexOutOfBoundsException("Out of bounds! Require index >= 0 and index < size.");
	}
	
	private void checkIndexForAdd(int index) {
		if(index < 0 || index > length)
			throw new IndexOutOfBoundsException("Out of bounds! Require index >=0 and index <= size.");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("Array size: %d, capacity: %d", length, data.length));
		builder.append("[");
		for(int i = 0; i < length; i ++)
			builder.append(data[i].toString()).append(" ,");
		if(builder.lastIndexOf(",") == (builder.length() - 1))
			builder.deleteCharAt(builder.length() - 1);
		builder.append("]");
		return builder.toString();
	}
	
	public static void main(String[] args) {
		Array<String> array = new Array<String>();
		for(int i = 1; i <= 20; i ++) {
			array.addLast(i + "");
		}
		System.out.println(array.toString());
		array.remove(15);
		System.out.println(array.toString());
		array.removeFirst();
		array.removeFirst();
		array.removeFirst();
		array.removeFirst();
		array.removeFirst();
		array.removeFirst();
		array.removeFirst();
		array.removeFirst();
		array.removeFirst();
		array.removeFirst();
		System.out.println(array.toString());
	}

}
