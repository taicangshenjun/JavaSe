package geekTime.dataStructureAndAlgorithm.sort;

import java.util.Arrays;

/**
 * 排序
 * @author cm
 *
 */
public class Sorts {

	/**
	 * 冒泡排序
	 * @param array
	 */
	public static void bubbleSort(int[] array) {
		int length = array.length;
		for(int i = 0; i < length - 1; i ++) {
			//本次是否有排序
			boolean flag = false;
			for(int j = 0; j < length - i - 1; j ++) {
				if(array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					flag = true;
				}
			}
			if(!flag)
				break;
		}
	}
	
	/**
	 * 冒泡排序改进:在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界,
	 * 对于边界外的元素在下次循环中无需比较.
	 * @param array
	 */
	public static void bubbleSort2(int[] array) {
		int length = array.length;
		//比较边界值，只比较边界值之前的元素
		int border = length - 1;
		//最后交换位置
		int lastExchange = border;
		for(int i = 0; i < length - 1; i ++) {
			//本次是否有排序
			boolean flag = false;
			for(int j = 0; j < border; j ++) {
				if(array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					flag = true;
					lastExchange = j;
				}
			}
			if(!flag)
				break;
			else
				border = lastExchange;
		}
	}
	
	/**
	 * 插入排序
	 * @param array
	 */
	public static void insertSort(int[] array) {
		for(int i = 1; i < array.length; i ++) {
			int value = array[i];
			int j = i - 1;
			for(; j >= 0; j --) {
				if(value < array[j]) {
					array[j + 1] = array[j];
				}else {
					break;
				}
			}
			array[j + 1] = value;
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {
			10, 9, 8, 3, 6, 2, 1, 7
		};
		Sorts.insertSort(array);
		System.out.println(Arrays.toString(array));
	}
	
}
