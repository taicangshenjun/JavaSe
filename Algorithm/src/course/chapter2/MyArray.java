package course.chapter2;

/**
 * �������ݽṹ��ѧϰ
 * @author cm
 *
 */
public class MyArray {
	
	private int[] array;
	
	//ʵ��Ԫ������
	private int size;
	
	public MyArray(int capacity){
		this.array = new int[capacity];
		this.size = 0;
	}
	
	/**
	 * ���Ԫ��
	 * @param element
	 * @param index
	 */
	public void insert(int element, int index){
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("��������ʵ��Ԫ�ط�Χ��");
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
			throw new IndexOutOfBoundsException("��������ʵ��Ԫ�ط�Χ��");
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
	 * ��������
	 */
	public void reBuild(){
		int[] arrayNew = new int[array.length * 2];
		System.arraycopy(array, 0, arrayNew, 0, array.length);
		array = arrayNew;
	}
	
	/**
	 * �������
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
