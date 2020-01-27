package geekTime.dataStructureAndAlgorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author cm
 *
 */
public class MergeSort {

	public static void sort(int[] array) {
		if(array == null || array.length == 0) {
			throw new RuntimeException("array is empty!");
		}
		mergeSort(array, 0, array.length - 1);
	}
	
	/**
	 * 递归调用
	 * @param array		待排序数组
	 * @param start		起始坐标
	 * @param end		结束坐标
	 */
	private static void mergeSort(int[] array, int start, int end) {
		if(start >= end) {
			return;
		}
		//防止start + end时int范围越界
		int pivot = start + (end - start) / 2;
		mergeSort(array, 0, pivot);
		mergeSort(array, pivot + 1, end);
		merge(array, start, pivot, end);
	}
	
	/**
	 * 融合函数，将数组分为array[start, pivot], array[pivot + 1, end]两部分，
	 * 并且将这两部分按顺序排列在临时数组temp里，
	 * 最后将temp中数据还原替换到原数组array对应位置
	 * @param array		待排序数组
	 * @param start		起始坐标
	 * @param pivot		分界点
	 * @param end		结束坐标
	 */
	private static void merge(int[] array, int start, int pivot, int end) {
		//临时数组
		int[] temp = new int[end - start + 1];
		//左数组待排序下标
		int leftIndex = start;
		//右数组待排序下标
		int rightIndex = pivot + 1;
		//临时数组待放置防止下标
		int index = 0;
		while(leftIndex <= pivot && rightIndex <= end) {
			if(array[leftIndex] <= array[rightIndex]) {
				temp[index ++] = array[leftIndex ++];
			}else {
				temp[index ++] = array[rightIndex ++];
			}
		}
		while(leftIndex <= pivot) {
			temp[index ++] = array[leftIndex ++];
		}
		while(rightIndex <= end) {
			temp[index ++] = array[rightIndex ++];
		}
		for(int i = 0; i < index; i ++) {
			array[start + i] = temp[i];
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {
				10, 9, 8, 3, 6, 2, 1, 7, 2, 5
		};
		MergeSort.sort(array);
		System.out.println(Arrays.toString(array));
	}
	
}
