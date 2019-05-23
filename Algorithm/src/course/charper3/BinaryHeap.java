package course.charper3;

import java.util.Arrays;

public class BinaryHeap {
	
	/**
	 * 上浮
	 * @param array
	 */
	public static void upAdjust(int[] array) {
		int childIndex = array.length - 1;
		int parentIndex = (childIndex - 1) / 2;
		int key = array[childIndex];
		while(array[parentIndex] > key && childIndex > 0){
			array[childIndex] = array[parentIndex];
			childIndex = parentIndex;
			parentIndex = (parentIndex - 1) / 2;
		}
		array[childIndex] = key;
	}
	
	/**
	 * 下沉操作：与左右两个子节点比较大小，如果大于他们，则与更小的一个子节点交换位置
	 * @param array
	 * @param parentIndex
	 * @param length
	 */
	public static void downAdjust(int[] array, int parentIndex, int length) {
		int key = array[parentIndex];
		int childIndex = parentIndex * 2 + 1;
		while(childIndex < length){
			if(childIndex + 1 < length && array[childIndex + 1] < array[childIndex]){
				childIndex ++;
			}
			if(array[childIndex] >= key){
				break;
			}
			array[parentIndex] = array[childIndex];
			parentIndex = childIndex;
			childIndex = childIndex * 2 + 1;
		}
		array[parentIndex] = key;
	}
	
	public static void buildHeap(int[] array) {
		for(int i = (array.length - 2) / 2; i >= 0; i --){
			downAdjust(array, i, array.length);
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{
				1, 3, 2, 6, 5, 7, 8, 9, 10, 0
		};
		upAdjust(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {
				7, 1, 3, 10, 5, 2, 8, 9, 6
		};
		buildHeap(array);
		System.out.println(Arrays.toString(array));
	}

}
