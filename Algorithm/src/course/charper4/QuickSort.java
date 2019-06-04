package course.charper4;

import course.util.ArrayUtils;

/**
 * ¿ìËÙÅÅÐò
 * @author cm
 *
 */
public class QuickSort {

	public static void sort(int[] array, int startIndex, int endIndex){
		if(startIndex >= endIndex){
			return;
		}
		int pivotIndex = partition(array, startIndex, endIndex);
		sort(array, startIndex, pivotIndex - 1);
		sort(array, pivotIndex + 1, endIndex);
	}
	
	public static int partition(int[] array, int startIndex, int endIndex){
		int pivot = array[startIndex];
		int left = startIndex;
		int right = endIndex;
		while(left != right){
			while(left < right && array[right] >= pivot){
				right --;
			}
			while(left < right && array[left] <= pivot){
				left ++;
			}
			if(left < right){
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
		}
		array[startIndex] = array[left];
		array[left] = pivot;
		return left;
	}
	
	public static void main(String[] args) {
		int[] array = ArrayUtils.createArray(10);
		ArrayUtils.display(array);
		sort(array, 0, array.length - 1);
		ArrayUtils.display(array);
	}
	
}
