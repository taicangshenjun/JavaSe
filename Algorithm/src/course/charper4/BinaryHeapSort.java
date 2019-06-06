package course.charper4;

import course.util.ArrayUtils;

/**
 * ������
 * ������ʹ������ʵ���������������
 * @author cm
 *
 */
public class BinaryHeapSort {
	
	/**
	 * ���������
	 * @param array
	 */
	public static void buildHeap(int[] array){
		for(int i = (array.length - 2) / 2; i >= 0; i --){
			downAdjust(array, i, array.length);
		}
	}
	
	/**
	 * ������³�
	 * @param array
	 * @param parentIndex
	 */
	public static void downAdjust(int[] array, int parentIndex, int length){
		//���ӽڵ�
		int childIndex = parentIndex * 2 + 1;
		int key = array[parentIndex];
		while(childIndex < length){
			//����������ӽڵ㣬�ұ����ӽڵ��ʹ�����ӽڵ��븸�ڵ�Ƚ�
			if(childIndex < length - 1 && array[childIndex + 1] > array[childIndex]){
				childIndex ++;
			}
			
			if(key < array[childIndex]){
				 array[parentIndex] = array[childIndex];
				 parentIndex = childIndex;
				 childIndex = childIndex * 2 + 1;
			}else{
				break;
			}
		}
		array[parentIndex] = key;
	}
	
	/**
	 * ��������򷽷�
	 * @param array
	 */
	public static void sort(int[] array){
		int length = array.length;
		for(int i = array.length - 1; i > 0; i --){
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			downAdjust(array, 0, -- length);
		}
	}
	
	public static void main(String[] args) {
		int[] array = ArrayUtils.createArray(10);
//		int[] array = new int[]{
//				32,4,33,15,48,36,39,93,78,91
//		};
		ArrayUtils.display(array);
		buildHeap(array);
		ArrayUtils.display(array);
		sort(array);
		ArrayUtils.display(array);
	}

}
