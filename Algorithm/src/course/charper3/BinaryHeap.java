package course.charper3;

import java.util.Arrays;

public class BinaryHeap {
	
	public static void upAdjust(int[] array) {
		
	}
	
	public static void downAdjust(int[] array, int parentIndex, int length) {
		int temp = array[parentIndex];
		int childIndex = 2 * parentIndex + 1;
		while(childIndex < length) {
			if(childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
				childIndex ++;
			}
			if(temp <= array[childIndex]) {
				break;
			}
			array[parentIndex] = array[childIndex];
			parentIndex = childIndex;
			childIndex = 2 * childIndex + 1;
		}
		array[parentIndex] = temp;
	}
	
	public static void buildHeap(int[] array) {
		for(int i = (array.length - 2) / 2; i >= 0; i --) {
			downAdjust(array, i, array.length);
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {
				7, 1, 3, 10, 5, 2, 8, 9, 6
		};
		buildHeap(array);
		System.out.println(Arrays.toString(array));
	}

}
