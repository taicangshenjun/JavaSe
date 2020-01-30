package geekTime.dataStructureAndAlgorithm.sort;

import java.util.Arrays;

import geekTime.dataStructureAndAlgorithm.util.ArrayUtils;

/**
 * 快速排序
 * @author cm
 *
 */
public class QuickSort {

	/**
	 * 排序方法
	 * @param array
	 */
	public static void sort(int[] array) {
		if(array == null || array.length == 0) {
			throw new RuntimeException("array is empty!");
		}
		quickSort(array, 0, array.length - 1);
	}
	
	/**
	 * 递归调用函数
	 * 结束递归条件是起始下标大于或等于结束下标
	 * @param array		待排序数组
	 * @param start		起始下标
	 * @param end		结束下标
	 */
	private static void quickSort(int[] array, int start, int end) {
		if(start >= end) {
			return ;
		}
		int index = findIndex(array, start, end);
		if(index - start > 1) {
			quickSort(array, start, index - 1);
		}
		if(end - index > 1) {
			quickSort(array, index + 1, end);
		}
	}
	
	/**
	 * 以array[start]为基准，将数组分为左边全部小于基准，右边全部大于基准的数组
	 * @param array		待排序数组
	 * @param start		起始下标
	 * @param end		结束下标
	 * @return			返回基准排序后的下标
	 */
	private static int findIndex(int[] array, int start, int end) {
		int index = start;
		int pivot = array[index];
		for(int i = start + 1; i <= end; i ++) {
			if(array[i] < pivot) {
				int temp = array[i];
				array[i] = array[++ index];
				array[index] = temp;
			}
		}
		array[start] = array[index];
		array[index] = pivot;
		return index;
	}
	
	public static void main(String[] args) {
		int[] array = ArrayUtils.createArray(10);
		System.out.println(Arrays.toString(array));
		QuickSort.sort(array);
		System.out.println(Arrays.toString(array));
	}
	
}
