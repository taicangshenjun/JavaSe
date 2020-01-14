package geekTime.dataStructureAndAlgorithm.array;

/**
 * 我们知道，计算机会给每个内存单元分配一个地址，计算机通过地址来访问内存中的数据。
 * 当计算机需要随机访问数组中的某个元素时，它会首先通过下面的寻址公式，计算出该元素存储的内存地址：
 * a[k]_address = base_address + k * type_size
 * 其中 data_type_size 表示数组中每个元素的大小。
 * 我们举的这个例子里，数组中存储的是 int 类型数据，所以 data_type_size 就为 4 个字节。
 * 这个公式非常简单，我就不多做解释了。
 * 
 * 
 * 
 * 为什么大多数编程语言中，数组要从 0 开始编号，而不是从 1 开始呢？
 * 从数组存储的内存模型上来看，“下标”最确切的定义应该是“偏移（offset）”。
 * 前面也讲到，如果用 a 来表示数组的首地址，a[0] 就是偏移为 0 的位置，也就是首地址，
 * a[k] 就表示偏移 k 个 type_size 的位置，所以计算 a[k] 的内存地址只需要用这个公式：
 * a[k]_address = base_address + k * type_size
 * 但是，如果数组从 1 开始计数，那我们计算数组元素 a[k] 的内存地址就会变为：
 * a[k]_address = base_address + (k-1)*type_size
 * 对比两个公式，我们不难发现，从 1 开始编号，每次随机访问数组元素都多了一次减法运算，对于 CPU 来说，就是多了一次减法指令。
 * 
 * 这里我要特别纠正一个“错误”：
 * 我在面试的时候，常常会问数组和链表的区别，很多人都回答说，“链表适合插入、删除，时间复杂度 O(1)；
 * 数组适合查找，查找时间复杂度为 O(1)”。
 * 实际上，这种表述是不准确的。数组是适合查找操作，但是查找的时间复杂度并不为 O(1)。
 * 即便是排好序的数组，你用二分查找，时间复杂度也是 O(logn)。
 * 所以，正确的表述应该是，数组支持随机访问，根据下标随机访问的时间复杂度为 O(1)。
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
			builder.append(data[i].toString()).append(", ");
		if(builder.lastIndexOf(", ") != -1 && builder.lastIndexOf(", ") == (builder.length() - 2))
			builder.delete(builder.length() - 2, builder.length());
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
