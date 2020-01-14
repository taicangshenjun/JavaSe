package geekTime.dataStructureAndAlgorithm.array;

/**
 * ����֪������������ÿ���ڴ浥Ԫ����һ����ַ�������ͨ����ַ�������ڴ��е����ݡ�
 * ���������Ҫ������������е�ĳ��Ԫ��ʱ����������ͨ�������Ѱַ��ʽ���������Ԫ�ش洢���ڴ��ַ��
 * a[k]_address = base_address + k * type_size
 * ���� data_type_size ��ʾ������ÿ��Ԫ�صĴ�С��
 * ���Ǿٵ��������������д洢���� int �������ݣ����� data_type_size ��Ϊ 4 ���ֽڡ�
 * �����ʽ�ǳ��򵥣��ҾͲ����������ˡ�
 * 
 * 
 * 
 * Ϊʲô�������������У�����Ҫ�� 0 ��ʼ��ţ������Ǵ� 1 ��ʼ�أ�
 * ������洢���ڴ�ģ�������������±ꡱ��ȷ�еĶ���Ӧ���ǡ�ƫ�ƣ�offset������
 * ǰ��Ҳ����������� a ����ʾ������׵�ַ��a[0] ����ƫ��Ϊ 0 ��λ�ã�Ҳ�����׵�ַ��
 * a[k] �ͱ�ʾƫ�� k �� type_size ��λ�ã����Լ��� a[k] ���ڴ��ַֻ��Ҫ�������ʽ��
 * a[k]_address = base_address + k * type_size
 * ���ǣ��������� 1 ��ʼ�����������Ǽ�������Ԫ�� a[k] ���ڴ��ַ�ͻ��Ϊ��
 * a[k]_address = base_address + (k-1)*type_size
 * �Ա�������ʽ�����ǲ��ѷ��֣��� 1 ��ʼ��ţ�ÿ�������������Ԫ�ض�����һ�μ������㣬���� CPU ��˵�����Ƕ���һ�μ���ָ�
 * 
 * ������Ҫ�ر����һ�������󡱣�
 * �������Ե�ʱ�򣬳��������������������𣬺ܶ��˶��ش�˵���������ʺϲ��롢ɾ����ʱ�临�Ӷ� O(1)��
 * �����ʺϲ��ң�����ʱ�临�Ӷ�Ϊ O(1)����
 * ʵ���ϣ����ֱ����ǲ�׼ȷ�ġ��������ʺϲ��Ҳ��������ǲ��ҵ�ʱ�临�ӶȲ���Ϊ O(1)��
 * �������ź�������飬���ö��ֲ��ң�ʱ�临�Ӷ�Ҳ�� O(logn)��
 * ���ԣ���ȷ�ı���Ӧ���ǣ�����֧��������ʣ������±�������ʵ�ʱ�临�Ӷ�Ϊ O(1)��
 * @author cm
 *
 */
public class Array<T> {
	
	//�洢Ԫ��
	private T[] data;
	//����
	private int length;
	
	public Array() {
		this(10);
	}
	
	@SuppressWarnings("unchecked")
	public Array(int capacity) {
		this.data = (T[]) new Object[capacity];
		this.length = 0;
	}
	
	// ��ȡ��������
	public int getCapacity() {
		return data.length;
	}
	
	// ��ȡ��ǰԪ�ظ���
	public int count() {
		return length;
	}
	
	// �ж������Ƿ�Ϊ��
	public boolean isEmpty() {
		return length == 0;
	}
	
	// �޸� index λ�õ�Ԫ��
	public void set(int index, T element) {
		checkIndex(index);
		data[index] = element;
	}
	
	// ��ȡ��Ӧ index λ�õ�Ԫ��
	public T get(int index) {
		checkIndex(index);
		return data[index];
	}
	
	// �鿴�����Ƿ����Ԫ��e
	public boolean contains(T element) {
		for(int i = 0; i < length; i ++)
			if(data[i].equals(element))
				return true;
		return false;
	}
	
	// ��ȡ��ӦԪ�ص��±�, δ�ҵ������� -1
	public int indexOf(T element) {
		for(int i = 0; i < length; i ++)
			if(data[i].equals(element))
				return i;
		return -1;
	}
	
	// �� index λ�ã�����Ԫ��e, ʱ�临�Ӷ� O(m+n)
	public void add(int index, T element) {
		checkIndexForAdd(index);
		if(data.length == length)
			reSize(length * 2);
		for(int i = length; i > index; i --)
			data[i] = data[i - 1];
		data[index] = element;
		length ++;
	}
	
	// ������ͷ����Ԫ��
	public void addFirst(T element) {
		add(0, element);
	}
	
	// ������β����Ԫ��
	public void addLast(T element) {
		add(length, element);
	}
	
	// ɾ�� index λ�õ�Ԫ�أ�������
	public T remove(int index) {
		T element = null;
		try {
			checkIndex(index);
			element = data[index];
			for(int i = index; i < length - 1; i ++)
				data[i] = data[i + 1];
			data[-- length] = null;
			// ����
	        if (length == data.length / 4 && data.length / 2 != 0) {
	            reSize(data.length / 2);
	        }
		}catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	// ɾ����һ��Ԫ��
	public T removeFirst() {
		return remove(0);
	}
	
	// ɾ��ĩβԪ��
	public T removeLast() {
		return remove(length - 1);
	}
	
	// ��������ɾ��ָ��Ԫ��
	public T remove(T element) {
		int index = indexOf(element);
		if(index != -1)
			return remove(index);
		return null;
	}
	
	// ���ݷ�����ʱ�临�Ӷ� O(n)
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
