package course.charper4;

import course.util.ArrayUtils;

/**
 * 快速排序
 * @author cm
 *
 */
public class QuickSort {

	public static void sort(int[] array, int startIndex, int endIndex){
		if(startIndex >= endIndex){
			return;
		}
		int pivotIndex = partition2(array, startIndex, endIndex);
		sort(array, startIndex, pivotIndex - 1);
		sort(array, pivotIndex + 1, endIndex);
	}
	
	/**
	 * 双边循环法
	 * @param array
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
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
	
	/**
	 * 单边循环法
	 * @param array
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public static int partition2(int[] array, int startIndex, int endIndex){
		int pivot = array[startIndex];
		int mark = startIndex;
		int key = startIndex + 1;
		while(key <= endIndex){
			if(array[key] < pivot){
				int temp = array[key];
				array[key] = array[ ++ mark];
				array[mark] = temp;
			}
			key ++;
		}
		array[startIndex] = array[mark];
		array[mark] = pivot;
		return mark;
	}
	
	public static void main(String[] args) {
		int[] array = ArrayUtils.createArray(10);
//		int[] array = new int[]{
//				11,17,23,48,54,70,54,96,98,41
//		};
		ArrayUtils.display(array);
		sort(array, 0, array.length - 1);
		ArrayUtils.display(array);
	}
	
}
