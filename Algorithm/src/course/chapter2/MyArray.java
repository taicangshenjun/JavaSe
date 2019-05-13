package course.chapter2;

/**
 * 数组数据结构的学习
 * @author cm
 *
 */
public class MyArray {
	
	private int[] array;
	
	//实际元素数量
	private int size;
	
	public MyArray(int capacity){
		this.array = new int[capacity];
		this.size = 0;
	}
	
	/**
	 * 添加元素
	 * @param element
	 * @param index
	 */
	public void insert(int element, int index){
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("超出数组实际元素范围！");
		}
		if(size >= array.length){
			reBuild();
		}
		for(int i = size - 1; i >= index; i --){
			array[i + 1] = array[i];
		}
		array[index] = element;
		size ++;
	}
	
	public int delete(int index){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException("超出数组实际元素范围！");
		}
		int deleteElement = array[index];
		for(int i = index; i < size - 1; i ++){
			array[i] = array[i + 1];
		}
		array[size - 1] = 0;
		size --;
		return deleteElement;
	}
	
	/**
	 * 数组扩容
	 */
	public void reBuild(){
		int[] arrayNew = new int[array.length * 2];
		System.arraycopy(array, 0, arrayNew, 0, array.length);
		array = arrayNew;
	}
	
	/**
	 * 输出数组
	 */
	public void output(){
		String output = "[";
		for(int i = 0; i < size; i ++){
			output += array[i] + ",";
		}
		output = output.lastIndexOf(",") > -1? output.substring(0, output.lastIndexOf(",")) + "]": output + "]";
		System.out.println(output);
	}
	
	public static void main(String[] args) {
		MyArray myArray = new MyArray(1);
		myArray.insert(3, 0);
		myArray.insert(7, 1);
		myArray.insert(9, 2);
		myArray.insert(5, 3);
		myArray.insert(6, 1);
		myArray.output();
		myArray.delete(0);
		myArray.output();
	}
	
}
